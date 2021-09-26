package es.mde.tizona.entidades.artefactos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROYECTILES")
public class Proyectil extends Municion{

	private String dibujoBajoBandaConduccion;

	
	public Proyectil() {
		super();
	}

	public String getDibujoBajoBandaConduccion() {
		return dibujoBajoBandaConduccion;
	}

	public void setDibujoBajoBandaConduccion(String dibujoBajoBandaConduccion) {
		this.dibujoBajoBandaConduccion = dibujoBajoBandaConduccion;
	}
	
}
