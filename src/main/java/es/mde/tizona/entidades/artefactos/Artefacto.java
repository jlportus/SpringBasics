package es.mde.tizona.entidades.artefactos;

import java.util.Collection;

import es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos.ArchivoArtefacto;

public interface Artefacto {

	String getNombre();
	String getDescripcion();
	String getForma();
	String getColor();
	String getFuncionamiento();
	String getFabricacion();
	String[] getEncontradoEn();
//	Collection<ArchivoArtefacto> getListadoImagenes();
	String getMarcasFrio();
	String getMarcasPintura();
	
}
