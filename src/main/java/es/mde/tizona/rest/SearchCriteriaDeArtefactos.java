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
	//longitud ya esta en mina
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
	
	public Optional<String> getForma() {
		return forma;
	}
	public void setForma(Optional<String> forma) {
		this.forma = forma;
	}
	public Optional<String> getColor() {
		return color;
	}
	public void setColor(Optional<String> color) {
		this.color = color;
	}
	public Optional<String> getFabricacion() {
		return fabricacion;
	}
	public void setFabricacion(Optional<String> fabricacion) {
		this.fabricacion = fabricacion;
	}
	public Set<String> getEncontradoEn() {
		return encontradoEn;
	}
	public void setEncontradoEn(Set<String> encontradoEn) {
		this.encontradoEn = encontradoEn;
	}
	public Optional<String> getMarcasFrio() {
		return marcasFrio;
	}
	public void setMarcasFrio(Optional<String> marcasFrio) {
		this.marcasFrio = marcasFrio;
	}
	public Optional<String> getMarcasPintura() {
		return marcasPintura;
	}
	public void setMarcasPintura(Optional<String> marcasPintura) {
		this.marcasPintura = marcasPintura;
	}
	public Optional<Integer> getDiametroMax() {
		return diametroMax;
	}
	public void setDiametroMax(Optional<Integer> diametroMax) {
		this.diametroMax = diametroMax;
	}
	public Optional<Integer> getDiametroMin() {
		return diametroMin;
	}
	public void setDiametroMin(Optional<Integer> diametroMin) {
		this.diametroMin = diametroMin;
	}
	public Optional<Integer> getFondoMax() {
		return fondoMax;
	}
	public void setFondoMax(Optional<Integer> fondoMax) {
		this.fondoMax = fondoMax;
	}
	public Optional<Integer> getFondoMin() {
		return fondoMin;
	}
	public void setFondoMin(Optional<Integer> fondoMin) {
		this.fondoMin = fondoMin;
	}
	public Optional<Integer> getLongitudMax() {
		return longitudMax;
	}
	public void setLongitudMax(Optional<Integer> longitudMax) {
		this.longitudMax = longitudMax;
	}
	public Optional<Integer> getLongitudMin() {
		return longitudMin;
	}
	public void setLongitudMin(Optional<Integer> longitudMin) {
		this.longitudMin = longitudMin;
	}
	public Optional<Integer> getAlturaMax() {
		return alturaMax;
	}
	public void setAlturaMax(Optional<Integer> alturaMax) {
		this.alturaMax = alturaMax;
	}
	public Optional<Integer> getAlturaMin() {
		return alturaMin;
	}
	public void setAlturaMin(Optional<Integer> alturaMin) {
		this.alturaMin = alturaMin;
	}
	public Optional<String> getMaterialEnvuelta() {
		return materialEnvuelta;
	}
	public void setMaterialEnvuelta(Optional<String> materialEnvuelta) {
		this.materialEnvuelta = materialEnvuelta;
	}
	public Optional<String> getSituacionEspoleta() {
		return situacionEspoleta;
	}
	public void setSituacionEspoleta(Optional<String> situacionEspoleta) {
		this.situacionEspoleta = situacionEspoleta;
	}
	public Optional<Boolean> getAsaTransporte() {
		return asaTransporte;
	}
	public void setAsaTransporte(Optional<Boolean> asaTransporte) {
		this.asaTransporte = asaTransporte;
	}
	public Optional<String> getSistemaIniciacion() {
		return sistemaIniciacion;
	}
	public void setSistemaIniciacion(Optional<String> sistemaIniciacion) {
		this.sistemaIniciacion = sistemaIniciacion;
	}
	public Optional<String> getTipoMina() {
		return tipoMina;
	}
	public void setTipoMina(Optional<String> tipoMina) {
		this.tipoMina = tipoMina;
	}

	public Optional<Integer> getCalibreMax() {
		return calibreMax;
	}
	public void setCalibreMax(Optional<Integer> calibreMax) {
		this.calibreMax = calibreMax;
	}
	public Optional<Integer> getCalibreMin() {
		return calibreMin;
	}
	public void setCalibreMin(Optional<Integer> calibreMin) {
		this.calibreMin = calibreMin;
	}
	public Optional<String> getProposito() {
		return proposito;
	}
	public void setProposito(Optional<String> proposito) {
		this.proposito = proposito;
	}
	public Optional<Boolean> getAletas() {
		return aletas;
	}
	public void setAletas(Optional<Boolean> aletas) {
		this.aletas = aletas;
	}
	public Optional<String> getDibujoBajoBandaConduccion() {
		return dibujoBajoBandaConduccion;
	}
	public void setDibujoBajoBandaConduccion(Optional<String> dibujoBajoBandaConduccion) {
		this.dibujoBajoBandaConduccion = dibujoBajoBandaConduccion;
	}
	public Optional<Boolean> getPinturaProteccionTermica() {
		return pinturaProteccionTermica;
	}
	public void setPinturaProteccionTermica(Optional<Boolean> pinturaProteccionTermica) {
		this.pinturaProteccionTermica = pinturaProteccionTermica;
	}
	public Optional<Integer> getDistanciaAnillasMax() {
		return distanciaAnillasMax;
	}
	public void setDistanciaAnillasMax(Optional<Integer> distanciaAnillasMax) {
		this.distanciaAnillasMax = distanciaAnillasMax;
	}
	public Optional<Integer> getDistanciaAnillasMin() {
		return distanciaAnillasMin;
	}
	public void setDistanciaAnillasMin(Optional<Integer> distanciaAnillasMin) {
		this.distanciaAnillasMin = distanciaAnillasMin;
	}
	public Optional<String> getTipoEstabilizador() {
		return tipoEstabilizador;
	}
	public void setTipoEstabilizador(Optional<String> tipoEstabilizador) {
		this.tipoEstabilizador = tipoEstabilizador;
	}
	public Optional<Boolean> getVenterolEnEstabilizador() {
		return venterolEnEstabilizador;
	}
	public void setVenterolEnEstabilizador(Optional<Boolean> venterolEnEstabilizador) {
		this.venterolEnEstabilizador = venterolEnEstabilizador;
	}
	
	
	
}
