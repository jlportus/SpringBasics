package es.mde.tizona.entidades.artefactos.municiones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Misil")
@Table(name = "MISILES")
public class Misil extends Cohete {
	private String sistemaGuia;

	public Misil() {
		super();
	}

	public String getSistemaGuia() {
		return sistemaGuia;
	}

	public void setSistemaGuia(String sistemaGuia) {
		this.sistemaGuia = sistemaGuia;
	}

}
