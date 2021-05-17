package es.mde.SpringBasics.entidades.oneToMany;

import javax.persistence.ManyToOne;

public class Elemento {

	private int id;
	private String nombre;
	private long precio;
	private String fabricante;

	@ManyToOne
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

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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

	@Override
	public String toString() {
		return "Elemento [id=" + id + ", nombre=" + nombre + ", padreConColeccion=" + padreConColeccion + "]";
	}

	
}
