package es.mde.tizona.rest.mina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.repositorios.artefactos.minas.MinaDAO;
import es.mde.tizona.rest.ArtefactoSearchCriteria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MinaDAOImpl implements MinaDAOCustom {

	@Autowired
	MinaDAO minaDAO;

	@Override
	public List<Mina> getMinas(ArtefactoSearchCriteria searchCriteria) {
		Specification<Mina> minaSpecifications = MinaSpecifications.createMinaSpecifications(searchCriteria);
		return this.minaDAO.findAll(minaSpecifications);
	}

}
