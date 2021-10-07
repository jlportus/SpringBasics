import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { Artefacto } from "../models/Artefacto";
import { ArtefactoImpl } from "../models/ArtefactoImpl";
import { FichaService } from "../services/ficha.service";

@Component({
  selector: "app-formulario-ficha",
  templateUrl: "./formulario-ficha.component.html",
  styles: [],
})
export class FormularioFichaComponent implements OnInit {
  id: number = 3;

  private artefacto: Artefacto = new ArtefactoImpl(
    "",
    "",
    "",
    "",
    "",
    "",
    [],
    [],
    "",
    ""
  );
  constructor(private fichaService: FichaService) {}

  ngOnInit() {}

  salvarArtefacto() {
    console.log(`Salvando artefacto: ${JSON.stringify(this.artefacto)}`);
    this.fichaService
      .postArtefacto(this.artefacto)
      .subscribe((response) => console.log(response));
  }
}
