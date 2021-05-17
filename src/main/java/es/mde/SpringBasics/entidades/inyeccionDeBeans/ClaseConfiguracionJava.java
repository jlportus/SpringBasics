package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;
import es.mde.SpringBasics.rest.ElementoController;
import es.mde.SpringBasics.rest.Mixins;
import net.bytebuddy.asm.Advice.This;

@Configuration
public class ClaseConfiguracionJava {

	// voy a aprovechar el Bean de configuracion XML para sobreescribirlo
	@Bean(name = "BeanConfigJava")
	public ClaseConfiguracionJava beanPorClaseConfiguracionJava() {
		ClaseConfiguracionJava beanConfigJava = new ClaseConfiguracionJava() {

			@Override
			public String toString() {

				return "Probando el to string de la clase de configuracion Java";
			}

		};

		return beanConfigJava;

	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
	    ObjectMapper mapper = new ObjectMapper();
	      mapper.addMixIn(Elemento.class, Mixins.Elemento.class);
	    return mapper;
	  }
	
	@Bean
	RepresentationModelProcessor<RepositorySearchesResource> searchLinks(RepositoryRestConfiguration config) {
	    return new RepresentationModelProcessor<RepositorySearchesResource>() {

	        @Override
	        public RepositorySearchesResource process(RepositorySearchesResource searchResource) {

	            //le indico la entidad donde tiene que insertar el enlace
	            if (searchResource.getDomainType().equals(Elemento.class)) {

	              //si el enlace coincide lo insertara con el siguiente bloque

	                try {

	                    //Le digo el nombre de mi metodo personalizado
	                    String nombreMetodo = "getPacos";

	                    //busco en la entidad el metodo que coincide con el mio personalizado
	                    //(le tengo que decir tambien los parametros que recibe + Assembler)
	                    Method method = ElementoController.class.getMethod(nombreMetodo, String.class,
	                            PersistentEntityResourceAssembler.class);

	                    //capto la URI de la entidad con linkTo
	                    URI uri = org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
	                            .linkTo(method).toUri();

	                    //me construyo la url al metodo
	                    String url = new URI(uri.getScheme()
	                                        , uri.getUserInfo()
	                                        , uri.getHost()
	                                        , uri.getPort()
	                                        , config.getBasePath() + uri.getPath()
	                                        , uri.getQuery()
	                                        , uri.getFragment()).toString();
	                          //el ?txt sera el parametro recibido
	                    searchResource.add(new Link(url + "{?txt}", nombreMetodo));
	                } catch (NoSuchMethodException | URISyntaxException e) {
	                    e.printStackTrace();
	                }
	            }

	            return searchResource;
	        }

	    };
	}
	
}
