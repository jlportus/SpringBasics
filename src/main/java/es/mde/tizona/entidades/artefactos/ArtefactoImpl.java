package es.mde.tizona.entidades.artefactos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos.ArchivoArtefacto;
import es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos.ArchivoArtefactoImpl;

@Entity

@Table(name = "ARTEFACTOS")
public class ArtefactoImpl implements Artefacto {

	@Id
	@GeneratedValue
	Long id;

	private String nombre;
	@Column(length = 5000)
	private String descripcion;
	@Column(length = 5000)
	private String funcionamiento;
	private String forma;
	private String color;
	private String fabricacion;
	private String[] encontradoEn;
	
	@OneToMany
	private Collection<ArchivoArtefactoImpl> listadoImagenes = new ArrayList<ArchivoArtefactoImpl>();
	private String marcasFrio;
	private String marcasPintura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFuncionamiento() {
		return funcionamiento;
	}

	public void setFuncionamiento(String funcionamiento) {
		this.funcionamiento = funcionamiento;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}

	public String[] getEncontradoEn() {
		return encontradoEn;
	}

	public void setEncontradoEn(String[] encontradoEn) {
		this.encontradoEn = encontradoEn;
	}

	public Collection<ArchivoArtefactoImpl> getListadoImagenes() {
		return listadoImagenes;
	}

	public void setListadoImagenes(Collection<ArchivoArtefactoImpl> listadoImagenes) {
		this.listadoImagenes = listadoImagenes;
	}

	public String getMarcasFrio() {
		return marcasFrio;
	}

	public void setMarcasFrio(String marcasFrio) {
		this.marcasFrio = marcasFrio;
	}

	public String getMarcasPintura() {
		return marcasPintura;
	}

	public void setMarcasPintura(String marcasPintura) {
		this.marcasPintura = marcasPintura;
	}

	public ArtefactoImpl() {
//		this.listadoImagenes = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "ArtefactiImpl [nombre=" + nombre + ", descripcion=" + descripcion + ", funcionamiento=" + funcionamiento
				+ ", forma=" + forma + ", color=" + color + ", fabricacion=" + fabricacion + ", encontradoEn="
				+ Arrays.toString(encontradoEn) + ", listadoImagenes=" + ", marcasFrio=" + marcasFrio
				+ ", marcasPintura=" + marcasPintura + "]";
	}

}
