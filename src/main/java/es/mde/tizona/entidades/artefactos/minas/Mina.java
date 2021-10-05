package es.mde.tizona.entidades.artefactos.minas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@Entity
@Table(name = "MINAS")
public class Mina extends ArtefactoImpl {

	private int diametro;
	private int fondo;
	private int longitud;
	private int altura;
	private String materialEnvuelta;
	private String situacionEspoleta;
	private String tipoExplosivo;
	private int pesoExplosivo;
	private boolean asaTransporte;
	private String sistemaIniciacion;
	private String tipoMina;

	public Mina() {
		super();
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public int getFondo() {
		return fondo;
	}

	public void setFondo(int fondo) {
		this.fondo = fondo;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getMaterialEnvuelta() {
		return materialEnvuelta;
	}

	public void setMaterialEnvuelta(String materialEnvuelta) {
		this.materialEnvuelta = materialEnvuelta;
	}

	public String getSituacionEspoleta() {
		return situacionEspoleta;
	}

	public void setSituacionEspoleta(String situacionEspoleta) {
		this.situacionEspoleta = situacionEspoleta;
	}

	public String getTipoExplosivo() {
		return tipoExplosivo;
	}

	public void setTipoExplosivo(String tipoExplosivo) {
		this.tipoExplosivo = tipoExplosivo;
	}

	public int getPesoExplosivo() {
		return pesoExplosivo;
	}

	public void setPesoExplosivo(int pesoExplosivo) {
		this.pesoExplosivo = pesoExplosivo;
	}

	public boolean isAsaTransporte() {
		return asaTransporte;
	}

	public void setAsaTransporte(boolean asaTransporte) {
		this.asaTransporte = asaTransporte;
	}

	public String getSistemaIniciacion() {
		return sistemaIniciacion;
	}

	public void setSistemaIniciacion(String sistemaIniciacion) {
		this.sistemaIniciacion = sistemaIniciacion;
	}

	public String getTipoMina() {
		return tipoMina;
	}

	public void setTipoMina(String tipoMina) {
		this.tipoMina = tipoMina;
	}

}
