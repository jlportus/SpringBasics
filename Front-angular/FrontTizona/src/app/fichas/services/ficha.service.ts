import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { Artefacto } from "../models/Artefacto";

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
}
