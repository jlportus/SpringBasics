import { Component, OnInit } from "@angular/core";
import { Artefacto } from "../models/Artefacto";
import { FichaService } from "../services/ficha.service";

@Component({
  selector: "app-listadofichas",
  templateUrl: "./listadofichas.component.html",
  styles: [],
})
export class ListadofichasComponent implements OnInit {
  observable$: any;
  fichas: Artefacto[] = [];

  constructor(private fichaService: FichaService) {}

  ngOnInit() {
    this.observable$ = this.fichaService
      .getFichas()
      .subscribe(
        (response) => (this.fichas = this.fichaService.extraerFicha(response))
      );
    this.fichas = Array.from(this.observable$);
  }
}
