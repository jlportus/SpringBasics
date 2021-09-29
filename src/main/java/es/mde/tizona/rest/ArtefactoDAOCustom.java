package es.mde.tizona.rest;

import java.util.List;

import es.mde.tizona.entidades.artefactos.Artefacto;

public interface ArtefactoDAOCustom {

	List<Artefacto> getArtefactos(ArtefactoSearchCriteria searchCriteria);
}
