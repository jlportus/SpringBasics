package es.mde.tizona.rest;

import java.util.Optional;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchCriteriaDeArtefactos {

// Criterios comunes de artefactos

	private Optional<String> forma;
	private Optional<String> color;
	private Optional<String> fabricacion;
	private Set<String> encontradoEn;
	private Optional<String> marcasFrio;
	private Optional<String> marcasPintura;

// criterios especificos de Minas
	
	// para diametro
	private Optional<Integer> diametroMax;
	private Optional<Integer> diametroMin;
	// para fondo
	private Optional<Integer> fondoMax;
	private Optional<Integer> fondoMin;
	// para longitud
	private Optional<Integer> longitudMax;
	private Optional<Integer> longitudMin;
	// para altura
	private Optional<Integer> alturaMax;
	private Optional<Integer> alturaMin;

	private Optional<String> materialEnvuelta;
	private Optional<String> situacionEspoleta;

	// no se consideran criterios de busqueda
	// private Optional<String> tipoExplosivo;
	// private Optional<Integer> pesoExplosivo;
	private Optional<Boolean> asaTransporte;
	private Optional<String> sistemaIniciacion;
	private Optional<String> tipoMina;

// de Municiones
	
	// para calibre
	private Optional<Integer> calibreMax;
	private Optional<Integer> calibreMin;
	// longitud ya esta en mina
	private Optional<String> proposito;
	private Optional<Boolean> aletas;

// de proyectil
	private Optional<String> dibujoBajoBandaConduccion;

// de bombas de aviacion
	private Optional<Boolean> pinturaProteccionTermica;
	private Optional<Integer> distanciaAnillasMax;
	private Optional<Integer> distanciaAnillasMin;
	private Optional<String> tipoEstabilizador;
	private Optional<Boolean> venterolEnEstabilizador;

// de Cohete
	private Optional<String> colorBandaMotor;

// de Misil
	private Optional<String> sistemaGuia;

// de Granada
	private Optional<String> medioLanzamiento;

// de espoleta
	// diametro ya esta
	// altura ya esta
	private Optional<String> tipoIniciacion;
	// para profundidad
	private Optional<Integer> profundidadCavidadMax;
	private Optional<Integer> profundidadCavidadMin;
	private Optional<String> tipoEspoleta;
	
// de Otro
	// proposito ya esta;
	
	
	public Optional<String> getForma() {
		return forma;
	}
	public Optional<String> getColor() {
		return color;
	}
	public Optional<String> getFabricacion() {
		return fabricacion;
	}
	public Set<String> getEncontradoEn() {
		return encontradoEn;
	}
	public Optional<String> getMarcasFrio() {
		return marcasFrio;
	}
	public Optional<String> getMarcasPintura() {
		return marcasPintura;
	}
	public Optional<Integer> getDiametroMax() {
		return diametroMax;
	}
	public Optional<Integer> getDiametroMin() {
		return diametroMin;
	}
	public Optional<Integer> getFondoMax() {
		return fondoMax;
	}
	public Optional<Integer> getFondoMin() {
		return fondoMin;
	}
	public Optional<Integer> getLongitudMax() {
		return longitudMax;
	}
	public Optional<Integer> getLongitudMin() {
		return longitudMin;
	}
	public Optional<Integer> getAlturaMax() {
		return alturaMax;
	}
	public Optional<Integer> getAlturaMin() {
		return alturaMin;
	}
	public Optional<String> getMaterialEnvuelta() {
		return materialEnvuelta;
	}
	public Optional<String> getSituacionEspoleta() {
		return situacionEspoleta;
	}
	public Optional<Boolean> getAsaTransporte() {
		return asaTransporte;
	}
	public Optional<String> getSistemaIniciacion() {
		return sistemaIniciacion;
	}
	public Optional<String> getTipoMina() {
		return tipoMina;
	}
	public Optional<Integer> getCalibreMax() {
		return calibreMax;
	}
	public Optional<Integer> getCalibreMin() {
		return calibreMin;
	}
	public Optional<String> getProposito() {
		return proposito;
	}
	public Optional<Boolean> getAletas() {
		return aletas;
	}
	public Optional<String> getDibujoBajoBandaConduccion() {
		return dibujoBajoBandaConduccion;
	}
	public Optional<Boolean> getPinturaProteccionTermica() {
		return pinturaProteccionTermica;
	}
	public Optional<Integer> getDistanciaAnillasMax() {
		return distanciaAnillasMax;
	}
	public Optional<Integer> getDistanciaAnillasMin() {
		return distanciaAnillasMin;
	}
	public Optional<String> getTipoEstabilizador() {
		return tipoEstabilizador;
	}
	public Optional<Boolean> getVenterolEnEstabilizador() {
		return venterolEnEstabilizador;
	}
	public Optional<String> getColorBandaMotor() {
		return colorBandaMotor;
	}
	public Optional<String> getSistemaGuia() {
		return sistemaGuia;
	}
	public Optional<String> getMedioLanzamiento() {
		return medioLanzamiento;
	}
	public Optional<String> getTipoIniciacion() {
		return tipoIniciacion;
	}
	public Optional<Integer> getProfundidadCavidadMax() {
		return profundidadCavidadMax;
	}
	public Optional<Integer> getProfundidadCavidadMin() {
		return profundidadCavidadMin;
	}
	public Optional<String> getTipoEspoleta() {
		return tipoEspoleta;
	}



	
}
