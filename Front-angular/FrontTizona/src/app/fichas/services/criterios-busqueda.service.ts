import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { SearchCriteriaImpl } from "../models/search/search-criteriaImpl";

@Injectable({
  providedIn: "root",
})
export class CriteriosBusquedaService {
  
  //behaviour subject permite suscribirse cada vez que haya un cambio en el objeto
  public criteriosObservados: BehaviorSubject<SearchCriteriaImpl> =
    new BehaviorSubject<SearchCriteriaImpl>(new SearchCriteriaImpl);

  constructor() {}

  //con el .next se cambia el valor del behavioursubject -> desencadena el suscribe
  onChangeCriteria = (criterio: SearchCriteriaImpl) =>
    this.criteriosObservados.next(criterio);
}
