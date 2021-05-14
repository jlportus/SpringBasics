package es.mde.SpringBasics.entidades.oneToMany;

import java.util.ArrayList;
import java.util.Collection;

public class PadreConColeccion {

	private int id;
	private String nombre;
	private Collection<Elemento> listadoElementos;

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

	public Collection<Elemento> getListadoElementos() {
		return listadoElementos;
	}

	public void setListadoElementos(Collection<Elemento> listadoElementos) {
		this.listadoElementos = listadoElementos;
	}

	public PadreConColeccion() {
		listadoElementos = new ArrayList<Elemento>();
	}
	
	public PadreConColeccion(String nombre) {
		this();
		this.nombre = nombre;
	}

	//Metodo Sincronizador
	public void addElemento(Elemento elemento) {
		 this.listadoElementos.add(elemento);
		 elemento.setPadreConColeccion(this);
		}
}
