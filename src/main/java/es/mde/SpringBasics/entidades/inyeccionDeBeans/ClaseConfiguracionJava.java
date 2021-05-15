package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;
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
}
