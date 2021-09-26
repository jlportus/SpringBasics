package es.mde.tizona.entidades.artefactos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GRANADAS")
public class Granada extends Municion {

	private String medioLanzamineto;

	public Granada() {
		super();
	}

	public String getMedioLanzamineto() {
		return medioLanzamineto;
	}

	public void setMedioLanzamineto(String medioLanzamineto) {
		this.medioLanzamineto = medioLanzamineto;
	}

}
