package es.mde.SpringBasics.entidades.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoggingTester {
	private final Logger log = LoggerFactory.getLogger(LoggingTester.class);
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
    
	public LoggingTester() {
		super();
	}
	
	@Bean
	public void metodoTester() {
		log.info("Estoy en el bean de testing logging");
	}
	
	
}
