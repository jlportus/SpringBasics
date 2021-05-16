package es.mde.SpringBasics.repositorios;

import javax.persistence.PrePersist;

import org.springframework.stereotype.Component;

@Component
public class GeneradorListener {

	@PrePersist
	public void prePersist(Object object) {
		System.out.println("Soy un listener");
	}
}
