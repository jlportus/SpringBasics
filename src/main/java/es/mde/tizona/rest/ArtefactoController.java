package es.mde.tizona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

import es.mde.tizona.repositorios.artefactos.ArtefactoDAO;

@RepositoryRestController
@RequestMapping(path = "/artefactos/search")
public class ArtefactoController {

	ArtefactoDAO artefactoDAO;

	@Autowired
	public ArtefactoController(ArtefactoDAO artefactoDAO) {
		this.artefactoDAO = artefactoDAO;
	}
	
	//collection Model

}
