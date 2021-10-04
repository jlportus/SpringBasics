package es.mde.tizona.repositorios.artefactos.minas;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.Nullable;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.rest.mina.MinaDAOCustom;

@RepositoryRestResource(path="minas"
						,itemResourceRel="mina"
						,collectionResourceRel="minas")

public interface MinaDAO extends JpaRepository<Mina, Long>, JpaSpecificationExecutor<Mina>, MinaDAOCustom {

	@Override
	List<Mina> findAll(@Nullable Specification<Mina> spec) ;
	
	

}
