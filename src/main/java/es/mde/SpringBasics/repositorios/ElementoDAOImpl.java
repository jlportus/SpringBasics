package es.mde.SpringBasics.repositorios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;
import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

@Transactional
public class ElementoDAOImpl implements ElementoDAOCustom {

	@Autowired
	ElementoDAO elementoDAO;

	@Autowired
	PadreConColeccionDAO padreConColeccionDAO;
	
	public ElementoDAOImpl() {
	}

	@Override
	public List<Elemento> getPacos(String txt) {
		List<PadreConColeccion> padres = padreConColeccionDAO.findByNombreIgnoreCaseContaining(txt);
		padres.forEach(System.out::println);

		List<Elemento> elementos = elementoDAO.findAll();
		elementos.forEach(System.out::println);

		// creo la variable donde voy a almacenar el resultado
		Set<Elemento> elementosDePaco = new HashSet<Elemento>();

		elementos.forEach(e -> {
			padres.forEach(p -> {
				if (e.getPadreConColeccion().getId() == p.getId()) {
					elementosDePaco.add(e);
				}
			});

		});
		elementosDePaco.forEach(System.out::println);

		return new ArrayList<Elemento>(elementosDePaco);
	}

}
