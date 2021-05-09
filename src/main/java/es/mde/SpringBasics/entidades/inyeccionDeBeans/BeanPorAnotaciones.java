package es.mde.SpringBasics.entidades.inyeccionDeBeans;

import org.springframework.stereotype.Component;

@Component
public class BeanPorAnotaciones {
	String campoNombre = "Esto es un Bean por anotaciones";

	public void setCampoNombre(String campoNombre) {
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

	@Override
	public String toString() {
		return "Probando el metodo string de mi bean por Anotaciones";
	}
}
