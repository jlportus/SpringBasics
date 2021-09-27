package es.mde.tizona.entidades.artefactos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ESPOLETAS")
public class Espoleta extends ArtefactoImpl{

	private String diametro;
	private int altura;
	private String tipoIniciacion;
	private String tipoExplosivo;
	private int cantidadExplosivo;
	private String retardoSeguridad;
	private int profundidadCavidad;
	private String tipoEspoleta;
	
	
	
	public Espoleta() {
		super();
	}
	public String getDiametro() {
		return diametro;
	}
	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getTipoIniciacion() {
		return tipoIniciacion;
	}
	public void setTipoIniciacion(String tipoIniciacion) {
		this.tipoIniciacion = tipoIniciacion;
	}
	public String getTipoExplosivo() {
		return tipoExplosivo;
	}
	public void setTipoExplosivo(String tipoExplosivo) {
		this.tipoExplosivo = tipoExplosivo;
	}
	public int getCantidadExplosivo() {
		return cantidadExplosivo;
	}
	public void setCantidadExplosivo(int cantidadExplosivo) {
		this.cantidadExplosivo = cantidadExplosivo;
	}
	public String getRetardoSeguridad() {
		return retardoSeguridad;
	}
	public void setRetardoSeguridad(String retardoSeguridad) {
		this.retardoSeguridad = retardoSeguridad;
	}
	public int getProfundidadCavidad() {
		return profundidadCavidad;
	}
	public void setProfundidadCavidad(int profundidadCavidad) {
		this.profundidadCavidad = profundidadCavidad;
	}
	public String getTipoEspoleta() {
		return tipoEspoleta;
	}
	public void setTipoEspoleta(String tipoEspoleta) {
		this.tipoEspoleta = tipoEspoleta;
	}
	
	
}
