package es.mde.tizona.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.mde.tizona.entidades.artefactos.Artefacto;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.repositorios.artefactos.ArtefactoDAO;

@RepositoryRestController
@RequestMapping(path = "/artefactos/search")
public class ArtefactoController {

	ArtefactoDAOImpl artefactoDAO;

	@Autowired
	public ArtefactoController(ArtefactoDAOImpl artefactoDAO) {
		this.artefactoDAO = artefactoDAO;
	}

	// collection Model

	// introduzco los posibles parametros para los filtros
	@GetMapping(path = "filtrar")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> buscarArtefacto(
			@RequestParam(required = false) Optional<String> forma, PersistentEntityResourceAssembler assembler

	) {

		// hago un objeto que construye los criterios de busqueda opcionales.
		ArtefactoSearchCriteria searchCriteria = ArtefactoSearchCriteria.builder()
				// meto aqui los parametros de la clase SearcCriteria
				.forma(forma)

				// Construyo
				.build();

		// Recupero los artefactos con los criterios seleccionados
		List<ArtefactoImpl> listadoArtefactos = artefactoDAO.getArtefactos(searchCriteria);

		return assembler.toCollectionModel(listadoArtefactos);

	}
}
