import {
  Component,
  OnInit,
} from "@angular/core";
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
    this.searchCriteriaCache = this.searchCriteria;
    // console.log(JSON.stringify(this.searchCriteriaCache));
    this.criteriosService.onChangeCriteria(this.searchCriteriaCache);
    this.searchCriteriaCache = new SearchCriteriaImpl();
  }
}
