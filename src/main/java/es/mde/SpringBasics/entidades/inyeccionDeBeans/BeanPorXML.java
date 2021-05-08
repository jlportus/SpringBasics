package es.mde.SpringBasics.entidades.inyeccionDeBeans;

public class BeanPorXML {

	String campoNombre;

	public void setCampoNombre(String campoNombre) {
		this.campoNombre = campoNombre;
	}

	public String getCampoNombre() {
		return campoNombre;
	}

	public BeanPorXML() {
	}

	public void init() {
		System.out.println(campoNombre);
	}

	@Override
	public String toString() {
		return "Probando el metodo string de mi bean por XML";
	}
}
