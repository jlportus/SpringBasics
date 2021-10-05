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

	
	
}
