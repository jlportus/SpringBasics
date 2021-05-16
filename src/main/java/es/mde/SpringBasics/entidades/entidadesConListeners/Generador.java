package es.mde.SpringBasics.entidades.entidadesConListeners;

import javax.persistence.EntityListeners;

import es.mde.SpringBasics.repositorios.GeneradorListener;

@EntityListeners(GeneradorListener.class)
public class Generador {

	private int id;
	private String nombre;

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

	public Generador() {

	}
}
