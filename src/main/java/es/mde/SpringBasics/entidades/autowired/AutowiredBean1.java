package es.mde.SpringBasics.entidades.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


import es.mde.SpringBasics.entidades.log.LoggingTester;

@Component("numero1")
//@Primary
public class AutowiredBean1 implements AutowiredInterfz{

	private final Logger log = LoggerFactory.getLogger(LoggingTester.class);
	public String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

//	@Autowired
	public void AutowiredBean1(String string1) {
		mensaje = "Soy el bean 1";
	}

	public void imprimeMensaje() {
		log.info(mensaje);
	}
}
