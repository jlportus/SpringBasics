package es.mde.SpringBasics.entidades.POJO;

//import javax.persistence.Entity; // Obsoleto con Spring Boot 3 y mapeo por XML
//import javax.persistence.GeneratedValue; // Obsoleto con Spring Boot 3 y mapeo por XML
//import javax.persistence.Id; // Obsoleto con Spring Boot 3 y mapeo por XML

public class UsuarioXML {

	private int id;
	private String nombre;
	private String correo;

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

	public UsuarioXML() {

	}

}
