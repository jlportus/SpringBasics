package es.mde.tizona.rest.artefacto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.repositorios.artefactos.ArtefactoDAO;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ArtefactoDAOImpl implements ArtefactoDAOCustom {

	@Autowired
	ArtefactoDAO artefactoDAO;

	
	
	@Override
	public List<ArtefactoImpl> getArtefactos(SearchCriteriaDeArtefactos searchCriteria) {
		Specification<ArtefactoImpl> artefactoSpecifications = (Specification<ArtefactoImpl>) SearchSpecs.createSpecifications(searchCriteria);
		return this.artefactoDAO.findAll(artefactoSpecifications);
	}

}
