import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { Artefacto } from "../models/Artefacto";
import { ArtefactoImpl } from "../models/ArtefactoImpl";

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
    respuestaApi._embedded.artefactos.forEach((p) => {
      // console.log(`persona: ${ p }`);
      let urlP = p._links.self.href;
      // console.log(`url: ${ urlP }`);
      let id = this.getIdFicha(urlP);
      // console.log(`idp: ${ id }`);
      fichas.push(FichaService.mapearFicha(p, id));
    });
    return fichas;
  }
  static mapearFicha(fichaApi: any, id: String): ArtefactoImpl {
    return new ArtefactoImpl(
      id,
      fichaApi.nombre,
      fichaApi.funcionamiento,
      fichaApi.forma,
      fichaApi.color,
      fichaApi.fabricacion,
      fichaApi.encontradoEn,
      fichaApi.listadoImagenes,
      fichaApi.marcasFrio,
      fichaApi.marcasPintura
    );
  }

  getIdFicha(url: String): String {
    let trozos = url.split("/");
    // console.log(`trozos: ${ trozos }`);
    return trozos[trozos.length - 1];
  }
}
