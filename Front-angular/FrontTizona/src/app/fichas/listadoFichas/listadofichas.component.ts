import { Component, Input, OnInit } from "@angular/core";
import { Artefacto } from "../models/artefactos/Artefacto";
import { SearchCriteria } from "../models/search/search-criteria";
import { CriteriosBusquedaService } from "../services/criterios-busqueda.service";
import { FichaService } from "../services/ficha.service";

@Component({
  selector: "app-listadofichas",
  templateUrl: "./listadofichas.component.html",
  styles: [],
})
export class ListadofichasComponent implements OnInit {
  observable$: any;
  fichas: Artefacto[] = [];

  constructor(
    private fichaService: FichaService,
    private criteriosService: CriteriosBusquedaService
  ) {}

  ngOnInit() {
    this.criteriosService.criteriosObservados.subscribe((response) => {
      console.log(response);
      this.mostrarArtefactosFiltrados(response);
    });
  }

  mostrarArtefactosFiltrados(searchCriteria: SearchCriteria) {
    console.log("nuevos criterios" + JSON.stringify(searchCriteria));
    this.observable$ = this.fichaService
      .getFichasFiltradas(searchCriteria)
      .subscribe(
        (response) => (this.fichas = this.fichaService.extraerFicha(response))
      );
    this.fichas = Array.from(this.observable$);
  }
}
