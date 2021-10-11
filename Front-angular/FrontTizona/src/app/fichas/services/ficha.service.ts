import { HttpClient } from "@angular/common/http";
import { Injectable, Type } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { Key } from "selenium-webdriver";
import { environment } from "src/environments/environment";
import { Artefacto } from "../models/artefactos/Artefacto";
import { ArtefactoImpl } from "../models/artefactos/ArtefactoImpl";
import { SearchCriteria } from "../models/search/search-criteria";

@Injectable({
  providedIn: "root",
})
export class FichaService {
  private urlEndPoint: string = environment.urlAPI + `/artefactos`;

  constructor(private http: HttpClient) {}

  //post
  postArtefacto(artefacto: Artefacto): Observable<any> {
    return this.http.post(`${this.urlEndPoint}`, artefacto).pipe(
      catchError((e) => {
        if (e.status === 400) {
          return throwError(e);
        }
        if (e.error.mensaje) {
          console.error(e.error.mensaje);
        }
        return throwError(e);
      })
    );
  }

  //get
  getFichas(): Observable<any> {
    // console.log(`Url acceso a la peticion ${this.urlEndPoint}`);
    let objetoApiFichas = this.http.get<any>(this.urlEndPoint);

    // console.log(objetoApiPersonas);
    return objetoApiFichas;
  }

  extraerFicha(respuestaApi: any): Artefacto[] {
    const fichas: Artefacto[] = [];
    let num = 1;

    console.log(JSON.stringify(respuestaApi._embedded));

    // Array.from(respuestaApi._embedded).forEach((element) => {
    //   Array(element).forEach((p) => {
    //     Array(p).forEach((artefacto) => {
    //       console.log(artefacto);
    //       // let id = this.getIdFicha(artefacto);
    //       fichas.push(FichaService.mapearFicha(artefacto, "id"));
    //     });
    //   });
    // });

    respuestaApi._embedded.artefactos.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.minas.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.municiones.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.proyectiles.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.bombasAviacion.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.cohetes.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.misiles.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.granadas.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    respuestaApi._embedded.cohetes.forEach((p) => {
      let id = this.getIdFicha(p);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    return fichas;
  }
  static mapearFicha(fichaApi: any, id: String): Artefacto {
    let objeto = Object.create(ArtefactoImpl);
    // objeto = Object.create(ArtefactoImpl) .fichaApi
    Object.assign<Artefacto, Artefacto>(objeto, fichaApi);
    Object.defineProperty(objeto, "id", {
      value: null,
      writable: true,
      enumerable: true,
      configurable: true,
    });
    objeto.id = id;
    return objeto;
  }

  getIdFicha(p: any): String {
    let url = p._links.self.href;
    let trozos = url.split("/");
    // console.log(`trozos: ${ trozos }`);
    return trozos[trozos.length - 1];
  }

  getFichasFiltradas(searchCriteria: SearchCriteria): Observable<any> {
    let objetoApiFichas = this.http.get<any>(
      this.urlEndPoint +
        "/search/filtrar?" +
        this.construirParametros(searchCriteria)
    );
    return objetoApiFichas;
  }

  construirParametros(searchCriteria: SearchCriteria): string {
    let parametros = "";
    Object.keys(searchCriteria).map((key) => {
      parametros += key + "=" + searchCriteria[key] + "&";
      // console.log(parametros);
    });
    return parametros.slice(0, parametros.length - 1);
  }
}
// function mapearFicha(fichaApi: any, id: String): any {
//   let objeto = {};
//   objeto.clave = "";

//   }
