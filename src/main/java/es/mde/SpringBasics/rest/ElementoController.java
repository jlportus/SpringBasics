package es.mde.SpringBasics.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;
import es.mde.SpringBasics.repositorios.ElementoDAO;

@RepositoryRestController
@RequestMapping(path = "/elemento/search")
public class ElementoController {

	ElementoDAO elementoDAO;

	@Autowired
	public ElementoController(ElementoDAO elementoDAO) {
		this.elementoDAO = elementoDAO;
	}

	@GetMapping("/pacos")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getPacos(@RequestParam String txt, 
			PersistentEntityResourceAssembler assembler) {

	      //aqui llamo a mi emtodo personalizado Custom de la IntfzDAO
	      List<Elemento> elementosDePaco = elementoDAO.getPacos(txt);

	      //el assembler.toColletionModel me construye la salida
	      return assembler.toCollectionModel(elementosDePaco);
	    }

}
