package es.mde.tizona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import es.mde.tizona.entidades.artefactos.Artefacto;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.repositorios.artefactos.ArtefactoDAO;

@Transactional
public class ArtefactoDAOImpl implements ArtefactoDAOCustom {

	@Autowired
	ArtefactoDAO artefactoDAO;

	public ArtefactoDAOImpl() {
	}

	@Override
	public List<Artefacto> getArtefactos(ArtefactoSearchCriteria searchCriteria) {
//		Specification<ArtefactoImpl> artefactoSpecifications = Artefacto.createFilmSpecifications(searchCriteria);
		return null;
	}

}
