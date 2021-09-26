package es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARCHIVOS")
public class ArchivoArtefactoImpl implements ArchivoArtefacto{
	
	@Id
	@GeneratedValue
	Long id;
	
	private String nombreArchivo;
	private String URLArchivo;
	
	@Override
	public String getNombreArchivo() {
	
		return nombreArchivo;
	}
	@Override
	public String getURLArchivo() {
		
		return URLArchivo;
	}
	
}
