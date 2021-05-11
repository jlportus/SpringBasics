package es.mde.SpringBasics.entidades.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.mde.SpringBasics.entidades.log.LoggingTester;

@Component("numero3")
public class AutowiredBean3 implements AutowiredInterfz{

	private final Logger log = LoggerFactory.getLogger(LoggingTester.class);
	public String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	@Autowired
	public void AutowiredBean3() {
		mensaje = "Soy el bean 3";
	}
	@Autowired
	public void imprimeMensaje() {
		log.info(mensaje);
	}
}
