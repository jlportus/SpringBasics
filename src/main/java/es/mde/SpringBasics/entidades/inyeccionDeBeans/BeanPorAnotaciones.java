package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanPorAnotaciones {

	@Value("${campoExterno}")
	String campoNombre;// = "Esto es un Bean por anotaciones";

	public void setCampoNombre(@Value("${campoExterno2}") String campoNombre) {
		this.campoNombre = campoNombre;
	}

	public String getCampoNombre() {
		return campoNombre;
	}

	public BeanPorAnotaciones() {
	}

	public void init() {
		System.out.println(campoNombre);
	}
	
	@Bean
	public String probandoVariablesExternas( @Value("${campoExterno2}") String valor ) {
		System.err.println(valor);
		return valor;
	}

	@Override
	public String toString() {
		return "Probando el metodo string de mi bean por Anotaciones";
	}
}
