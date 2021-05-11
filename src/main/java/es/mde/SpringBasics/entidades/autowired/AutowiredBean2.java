package es.mde.SpringBasics.entidades.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import es.mde.SpringBasics.entidades.log.LoggingTester;


@Component("numero2")
//@Primary
public class AutowiredBean2 implements AutowiredInterfz{

	private final Logger log = LoggerFactory.getLogger(LoggingTester.class);
	public String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

//	@Autowired
	public void AutowiredBean2(String string1, String strin2) {
		this.mensaje = "Soy el bean 2";
	}

	public void imprimeMensaje() {
		log.info(mensaje);
	}
}
