package es.mde.tizona.repositorios.archivosArtefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.archivosArtefactos.ArchivoArtefactos.ArchivoArtefactoImpl;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@RepositoryRestResource(path="archivoArtefactos"
						,itemResourceRel="archivoArtefacto"
						,collectionResourceRel="archivoArtefactos")
public interface ArchivoArtefactoDAO extends JpaRepository<ArchivoArtefactoImpl, Long> {

}
