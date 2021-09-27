package es.mde.tizona.entidades.artefactos.municiones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Bomba")
@Table(name = "BOMBAS")
public class BombaAviacion extends Municion {
	private String[] bandaPintura;
	private boolean pinturaProteccionTermica;
	private int distanciaAnillas;
	private String tipoEstabilizador;
	private boolean venterolEnEstabilizador;

	public BombaAviacion() {
		super();
	}

	public String[] getBandaPintura() {
		return bandaPintura;
	}

	public void setBandaPintura(String[] bandaPintura) {
		this.bandaPintura = bandaPintura;
	}

	public boolean isPinturaProteccionTermica() {
		return pinturaProteccionTermica;
	}

	public void setPinturaProteccionTermica(boolean pinturaProteccionTermica) {
		this.pinturaProteccionTermica = pinturaProteccionTermica;
	}

	public int getDistanciaAnillas() {
		return distanciaAnillas;
	}

	public void setDistanciaAnillas(int distanciaAnillas) {
		this.distanciaAnillas = distanciaAnillas;
	}

	public String getTipoEstabilizador() {
		return tipoEstabilizador;
	}

	public void setTipoEstabilizador(String tipoEstabilizador) {
		this.tipoEstabilizador = tipoEstabilizador;
	}

	public boolean isVenterolEnEstabilizador() {
		return venterolEnEstabilizador;
	}

	public void setVenterolEnEstabilizador(boolean venterolEnEstabilizador) {
		this.venterolEnEstabilizador = venterolEnEstabilizador;
	}

}
