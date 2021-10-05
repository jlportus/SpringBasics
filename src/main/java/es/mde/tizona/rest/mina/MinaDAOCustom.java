package es.mde.tizona.rest.mina;

import java.util.List;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;

public interface MinaDAOCustom {

	List<Mina> getMinas(SearchCriteriaDeArtefactos searchCriteria);

}
