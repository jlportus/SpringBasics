package es.mde.SpringBasics.entidades.herencia;

public class HijoHerencia extends PadreHerencia {

	private String nombre;
	private String correo;

	public HijoHerencia() {
		super();
	}

	public HijoHerencia(String nombre) {
		super();
		this.nombre = nombre;
		this.correo = nombre + "@correo.es";

	}

}
