package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.bytebuddy.asm.Advice.This;

@Configuration
public class BeanPorClaseConfiguracionJava {

	// voy a aprovechar el Bean de configuracion XML para sobreescribirlo
	@Bean(name = "BeanConfigJava")
	public BeanPorClaseConfiguracionJava beanPorClaseConfiguracionJava() {
		BeanPorClaseConfiguracionJava beanConfigJava = new BeanPorClaseConfiguracionJava() {

			@Override
			public String toString() {

				return "Probando el to string de la clase de configuracion Java";
			}

		};

		return beanConfigJava;

	}
}
