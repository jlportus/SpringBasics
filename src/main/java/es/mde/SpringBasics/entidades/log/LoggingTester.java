package es.mde.SpringBasics.entidades.log;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoggingTester {

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
		System.out.println("Estoy en el bean de testing logging");
	}
	
	
}
