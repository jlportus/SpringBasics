package es.mde.tizona.rest;

import java.util.List;

import es.mde.tizona.entidades.artefactos.Artefacto;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

public interface ArtefactoDAOCustom {

	List<ArtefactoImpl> getArtefactos(ArtefactoSearchCriteria searchCriteria);
}
