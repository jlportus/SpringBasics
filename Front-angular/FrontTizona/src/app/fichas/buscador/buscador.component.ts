import { Component, OnInit } from "@angular/core";
import { SearchCriteriaImpl } from "../models/search/search-criteriaImpl";
import { CriteriosBusquedaService } from "../services/criterios-busqueda.service";

@Component({
  selector: "app-buscador",
  templateUrl: "./buscador.component.html",
  styles: [],
})
export class BuscadorComponent implements OnInit {
  searchCriteria: SearchCriteriaImpl = new SearchCriteriaImpl();
  searchCriteriaCache: SearchCriteriaImpl = this.searchCriteria;

  constructor(private criteriosService: CriteriosBusquedaService) {}

  ngOnInit() {}

  buscar() {
    this.searchCriteriaCache = new SearchCriteriaImpl();
    Object.keys(this.searchCriteria).map((key) => {
      if (this.searchCriteria[key] != "") {
        Object.defineProperty(this.searchCriteriaCache, key, {
          value: this.searchCriteria[key],
          writable: true,
          enumerable: true,
          configurable: true,
        });
      }
    });
    // console.log(JSON.stringify(this.searchCriteriaCache));

    this.criteriosService.onChangeCriteria(this.searchCriteriaCache);
  }
}
