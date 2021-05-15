package es.mde.SpringBasics.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

public class Mixins {

	@JsonPropertyOrder({ "nombre",  "id" })
	@JsonIgnoreProperties(value = { "fabricante", "precio" })
	public abstract class Elemento {

		@JsonIgnore
		private PadreConColeccion padreConColeccion;

	}

}
