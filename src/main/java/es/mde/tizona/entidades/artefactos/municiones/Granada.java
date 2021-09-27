package es.mde.tizona.entidades.artefactos.municiones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Granada")
@Table(name = "GRANADAS")
public class Granada extends Municion {

	private String medioLanzamiento;

	public Granada() {
		super();
	}

	public String getMedioLanzamiento() {
		return medioLanzamiento;
	}

	public void setMedioLanzamiento(String medioLanzamineto) {
		this.medioLanzamiento = medioLanzamineto;
	}

}
