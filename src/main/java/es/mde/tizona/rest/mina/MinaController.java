package es.mde.tizona.rest.mina;

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

@RepositoryRestController
@RequestMapping(path = "/artefactos/search")
public class MinaController {

	MinaDAOImpl minaDAO;

	@Autowired
	public MinaController(MinaDAOImpl minaDAO) {
		this.minaDAO = minaDAO;
	}

	// collection Model

	// introduzco los posibles parametros para los filtros
//	@GetMapping(path = "filtrar")
//	@ResponseBody
//	public CollectionModel<PersistentEntityResource> buscarMina(
//			//meto los parametros opcionales -> luego los debo meter al builder y tienen que estar en Specifications
//			@RequestParam(required = false) 
//			Optional<String> materialEnvuelta,
//			
//			//El assembler para que construya la respuesta
//			PersistentEntityResourceAssembler assembler
//
//	) {
//
//		// hago un objeto que construye los criterios de busqueda opcionales.
//		MinaSearchCriteria searchCriteria = MinaSearchCriteria.builder()
//				// meto aqui los parametros de la clase SearchCriteria
//				.materialEnvuelta(materialEnvuelta)
//
//				// Construyo
//				.build();
//
//		// Recupero los artefactos con los criterios seleccionados
////		List<Mina> listadoArtefactos = minaDAO.getMinas(searchCriteria);
//
//		return assembler.toCollectionModel(listadoArtefactos);
//
//	}
}
