package es.mde.SpringBasics.entidades.oneToMany;

public class Elemento {

	private int id;
	private String nombre;

	private PadreConColeccion padreConColeccion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PadreConColeccion getPadreConColeccion() {
		return padreConColeccion;
	}

	public void setPadreConColeccion(PadreConColeccion padreConColeccion) {
		this.padreConColeccion = padreConColeccion;
	}

	public Elemento() {

	}

	public Elemento(String nombre) {
		this.nombre = nombre;
	}
}
