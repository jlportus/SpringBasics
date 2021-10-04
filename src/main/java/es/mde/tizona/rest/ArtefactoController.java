package es.mde.tizona.rest;

import java.util.Collection;
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
import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.repositorios.artefactos.ArtefactoDAO;
import es.mde.tizona.repositorios.artefactos.minas.MinaDAO;
import es.mde.tizona.repositorios.artefactos.municiones.MunicionDAO;
import es.mde.tizona.rest.mina.MinaDAOImpl;

@RepositoryRestController
@RequestMapping(path = "/artefactos/search")
public class ArtefactoController {

	//Poner todas las DAOImpl de cada clase para acceder al metodo de busqueda con SearCriteria
	@Autowired
	ArtefactoDAOImpl artefactoDAO;
	@Autowired
	MinaDAOImpl minaDAO;

	@Autowired
	public ArtefactoController(
			ArtefactoDAOImpl artefactoDAO, 
			MinaDAOImpl minaDAO) {
		this.artefactoDAO = artefactoDAO;
		this.minaDAO = minaDAO;
	}

	// collection Model

	// introduzco los posibles parametros para los filtros
	@GetMapping(path = "filtrar")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> buscarArtefacto(
			// meto los parametros opcionales -> luego los debo meter al builder y 
			// tienen que estar en Specifications
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

			// de minas
			@RequestParam(required = false) 
			Optional<String> materialEnvuelta,

			// El assembler para que construya la respuesta
			PersistentEntityResourceAssembler assembler
	) {
		// hago un objeto que construye los criterios de busqueda opcionales.
		ArtefactoSearchCriteria searchCriteria = ArtefactoSearchCriteria.builder() //Aunque salga error funciona bien
				// meto aqui los parametros de la clase SearchCriteria
				.forma(forma)
				.color(color)
				.fabricacion(fabricacion)
				.marcasFrio(marcasFrio)
				.marcasPintura(marcasPintura)

				// de mina
				.materialEnvuelta(materialEnvuelta)

				// Construyo
				.build();

		List<?> listadoArtefactos;
		
		//controlo los parametros propios de cada subclase
		if (!materialEnvuelta.isPresent()) {
			// System.out.println("es un artefacto!!");
			listadoArtefactos = artefactoDAO.getArtefactos(searchCriteria);
		} else {
			// System.out.println("es una mina");
			listadoArtefactos = minaDAO.getMinas(searchCriteria);
		}
		;
		return assembler.toCollectionModel(listadoArtefactos);
	}
}
