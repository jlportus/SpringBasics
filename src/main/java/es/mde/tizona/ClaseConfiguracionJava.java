package es.mde.tizona;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Configuration
@ComponentScan("mde")
public class ClaseConfiguracionJava {

	@Bean
	RepresentationModelProcessor<RepositorySearchesResource> addSearchLinks(RepositoryRestConfiguration config) {
		Map<Class<?>, Class<?>> controllersRegistrados = new HashMap<>();

		// le indico la entidad donde tiene que insertar el enlace y el controlador
//		controllersRegistrados.put(ActividadConID.class, ListadoController.class);
//		controllersRegistrados.put(AusenciaConID.class, AusenciasController.class);

		return new RepresentationModelProcessor<RepositorySearchesResource>() {

			@SuppressWarnings("deprecation")
			@Override
			public RepositorySearchesResource process(RepositorySearchesResource searchResource) {

				// si el enlace coincide lo insertara con el siguiente bloque
				if (controllersRegistrados.containsKey(searchResource.getDomainType())) {
					Method[] metodos = controllersRegistrados.get(searchResource.getDomainType()).getDeclaredMethods();
					for (Method m : metodos) {
						if (!m.isAnnotationPresent(ResponseBody.class))
							continue;
						try {
							Object[] pathVars = Stream.of(m.getParameters())
									.filter(p -> p.isAnnotationPresent(PathVariable.class))
									.map(p -> "(" + p.getName() + ")").collect(Collectors.toList()).toArray();
							URI uri = linkTo(m, pathVars).toUri();
							String path = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),
									config.getBasePath() + uri.getPath(), uri.getQuery(), uri.getFragment()).toString()
											.replace("(", "{").replace(")", "}");
							String requestParams = Stream.of(m.getParameters())
									.filter(p -> p.isAnnotationPresent(RequestParam.class)).map(Parameter::getName)
									.collect(Collectors.joining(","));
							searchResource.add(new Link(path + "{?" + requestParams + "}", m.getName()));
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
					}
				}

				return searchResource;
			}

		};

	}

	@Bean
	CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(false);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}

}
