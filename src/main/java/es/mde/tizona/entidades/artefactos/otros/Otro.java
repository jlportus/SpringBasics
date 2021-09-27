package es.mde.tizona.entidades.artefactos.otros;

import javax.persistence.Entity;
import javax.persistence.Table;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@Entity
@Table(name = "OTROS")
public class Otro extends ArtefactoImpl {
	private String proposito;
	

	public Otro() {
		super();
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

}
