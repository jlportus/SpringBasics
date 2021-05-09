package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
