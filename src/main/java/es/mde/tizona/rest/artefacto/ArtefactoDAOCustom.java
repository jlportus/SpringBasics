package es.mde.tizona.rest.artefacto;

import java.util.List;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;

public interface ArtefactoDAOCustom {

	List<ArtefactoImpl> getArtefactos(SearchCriteriaDeArtefactos searchCriteria);
}
