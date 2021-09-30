package es.mde.tizona.rest;

import java.util.Optional;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArtefactoSearchCriteria {

	private Optional<String> forma;
	private Optional<String> color;
	private Optional<String> fabricacion;
	private Set<String> encontradoEn;
	private Optional<String> marcasFrio;
	private Optional<String> marcasPintura;

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

}
