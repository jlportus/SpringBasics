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
import es.mde.tizona.rest.artefacto.ArtefactoDAOImpl;

@RepositoryRestController
@RequestMapping(path = "/artefactos/search")
public class ControllerDeArtefactos {

	//Poner todas las DAOImpl de cada clase para acceder al metodo de busqueda con SearCriteria
	@Autowired
	ArtefactoDAOImpl artefactoDAO;

	@Autowired
	public ControllerDeArtefactos(
			ArtefactoDAOImpl artefactoDAO
			) {
		this.artefactoDAO = artefactoDAO;
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
			Optional<Integer> diametroMax,
			@RequestParam(required = false) 
			Optional<Integer> diametroMin,
			@RequestParam(required = false) 
			Optional<Integer> fondoMax,
			@RequestParam(required = false) 
			Optional<Integer> fondoMin,
//			@RequestParam(required = false) 
//			Optional<Integer> longitudMax,
//			@RequestParam(required = false) 
//			Optional<Integer> longitudMin,
			@RequestParam(required = false) 
			Optional<Integer> alturaMax,
			@RequestParam(required = false) 
			Optional<Integer> alturaMin,
			@RequestParam(required = false) 
			Optional<String> materialEnvuelta,
			@RequestParam(required = false) 
			Optional<String> situacionEspoleta,
			@RequestParam(required = false) 
			Optional<Boolean> asaTransporte,
			@RequestParam(required = false) 
			Optional<String> sistemaIniciacion,
			@RequestParam(required = false) 
			Optional<String> tipoMina,
			
			// de municion
			@RequestParam(required = false) 
			Optional<Integer> calibreMax,
			@RequestParam(required = false) 
			Optional<Integer> calibreMin,
			@RequestParam(required = false) 
			Optional<Integer> longitudMax,
			@RequestParam(required = false) 
			Optional<Integer> longitudMin,
			@RequestParam(required = false) 
			Optional<String> proposito,
			@RequestParam(required = false) 
			Optional<Boolean> aletas,

			// El assembler para que construya la respuesta
			PersistentEntityResourceAssembler assembler
	) {
		// hago un objeto que construye los criterios de busqueda opcionales
		SearchCriteriaDeArtefactos searchCriteria = SearchCriteriaDeArtefactos.builder() //Aunque salga error funciona bien
				// meto aqui los parametros de la clase SearchCriteria
				.forma(forma)
				.color(color)
				.fabricacion(fabricacion)
				.marcasFrio(marcasFrio)
				.marcasPintura(marcasPintura)

				// de mina
				.diametroMax(diametroMax)
				.diametroMin(diametroMin)
				.fondoMax(fondoMax)
				.fondoMin(fondoMin)
//				.longitudMax(longitudMax)
//				.longitudMin(longitudMin)
				.alturaMax(alturaMax)
				.alturaMin(alturaMin)
				.materialEnvuelta(materialEnvuelta)
				.situacionEspoleta(situacionEspoleta)
				.asaTransporte(asaTransporte)
				.sistemaIniciacion(sistemaIniciacion)
				.tipoMina(tipoMina)
				
				// de municion
				.calibreMax(calibreMax)
				.calibreMin(calibreMin)
				.longitudMax(longitudMax)
				.longitudMin(longitudMin)
				.proposito(proposito)
				.aletas(aletas)

				// Construyo
				.build();

		List<?> listadoArtefactos = artefactoDAO.getArtefactos(searchCriteria);
				
		return assembler.toCollectionModel(listadoArtefactos);
	}
}
