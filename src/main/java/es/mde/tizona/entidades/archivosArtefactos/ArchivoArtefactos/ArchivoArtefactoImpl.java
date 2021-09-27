package es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@Entity
@Table(name = "ARCHIVOS")
public class ArchivoArtefactoImpl implements ArchivoArtefacto {

	@Id
	@GeneratedValue
	Long id;

	private String nombreArchivo;
	private String uRLArchivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_Artefacto")
	private ArtefactoImpl artefacto;

	public ArtefactoImpl getArtefacto() {
		return artefacto;
	}

	public void setArtefacto(ArtefactoImpl artefacto) {
		this.artefacto = artefacto;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public String getNombreArchivo() {

		return nombreArchivo;
	}

	public void setuRLArchivo(String uRLArchivo) {
		this.uRLArchivo = uRLArchivo;
	}

	@Override
	public String getuRLArchivo() {

		return uRLArchivo;
	}

	public ArchivoArtefactoImpl() {

	}

}
