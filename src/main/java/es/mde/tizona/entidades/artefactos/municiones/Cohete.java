package es.mde.tizona.entidades.artefactos.municiones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Cohete")
@Table(name = "COHETES")
public class Cohete extends Municion{

	private String colorBandaMotor;

	
	public Cohete() {
		super();
	}

	public String getColorBandaMotor() {
		return colorBandaMotor;
	}

	public void setColorBandaMotor(String colorBandaMotor) {
		this.colorBandaMotor = colorBandaMotor;
	}
	
}
