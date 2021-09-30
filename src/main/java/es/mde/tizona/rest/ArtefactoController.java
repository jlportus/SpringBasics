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
			//meto los parametros opcionales -> luego los debo meter al builder y tienen que estar en Specifications
			@RequestParam(required = false) 
			Optional<String> forma, 
			@RequestParam(required = false) 
			Optional<String> color,
			@RequestParam(required = false) 
			Optional<String> fabricacion,
			@RequestParam(required = false) 
			Optional<String> marcasFrio,
			@RequestParam(required = false) 
			Optional<String> marcasPintura,
			
			//de minas
			@RequestParam(required = false) 
			Optional<String> materialEnvuelta,
			
			//El assembler para que construya la respuesta
			PersistentEntityResourceAssembler assembler

	) {

		// hago un objeto que construye los criterios de busqueda opcionales.
		ArtefactoSearchCriteria searchCriteria = ArtefactoSearchCriteria.builder()
				// meto aqui los parametros de la clase SearchCriteria
				.forma(forma)
				.color(color)
				.fabricacion(fabricacion)
				.marcasFrio(marcasFrio)
				.marcasPintura(marcasPintura)
				
				//de mina
				.materialEnvuelta(materialEnvuelta)

				// Construyo
				.build();

		// Recupero los artefactos con los criterios seleccionados
		List<ArtefactoImpl> listadoArtefactos = artefactoDAO.getArtefactos(searchCriteria);

		return assembler.toCollectionModel(listadoArtefactos);

	}
}
