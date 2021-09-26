package es.mde.tizona.entidades.artefactos;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MUNICIONES")
public class Municion extends ArtefactoImpl{

	
	private int calibre;
	private int longitud;
	private String cargaInterior;
	private String proposito;
	private boolean aletas;
	
	@OneToMany
	private Collection<Espoleta> espoletasCompatibles;
	private String[] bandasPintura;
	@OneToMany
	private Collection<ArtefactoImpl> subArtefactos;
	
	
	public Municion() {
		super();
	}
	
	public int getCalibre() {
		return calibre;
	}
	public void setCalibre(int calibre) {
		this.calibre = calibre;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getCargaInterior() {
		return cargaInterior;
	}
	public void setCargaInterior(String cargaInterior) {
		this.cargaInterior = cargaInterior;
	}
	public String getProposito() {
		return proposito;
	}
	public void setProposito(String proposito) {
		this.proposito = proposito;
	}
	public boolean isAletas() {
		return aletas;
	}
	public void setAletas(boolean aletas) {
		this.aletas = aletas;
	}
	public Collection<Espoleta> getEspoletasCompatibles() {
		return espoletasCompatibles;
	}
	public void setEspoletasCompatibles(Collection<Espoleta> espoletasCompatibles) {
		this.espoletasCompatibles = espoletasCompatibles;
	}
	public String[] getBandasPintura() {
		return bandasPintura;
	}
	public void setBandasPintura(String[] bandasPintura) {
		this.bandasPintura = bandasPintura;
	}
	public Collection<ArtefactoImpl> getSubArtefactos() {
		return subArtefactos;
	}
	public void setSubArtefactos(Collection<ArtefactoImpl> subArtefactos) {
		this.subArtefactos = subArtefactos;
	}
	
}
