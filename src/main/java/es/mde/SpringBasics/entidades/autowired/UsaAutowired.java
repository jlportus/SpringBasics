package es.mde.SpringBasics.entidades.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsaAutowired {

	private AutowiredInterfz autoenlazado;

	public UsaAutowired(@Qualifier("numero3") AutowiredInterfz autoenlazado) {
		
		
		this.autoenlazado = autoenlazado;
	}

	public void init() {
		autoenlazado.imprimeMensaje();
	}

}
