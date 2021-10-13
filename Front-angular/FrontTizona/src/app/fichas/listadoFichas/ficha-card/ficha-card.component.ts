import { Component, Input, OnInit } from "@angular/core";
import { Fotografia } from "src/app/fotografias/models/fotografia";
import { FotografiaImpl } from "src/app/fotografias/models/fotografiaImpl";
import { FotografiasService } from "src/app/fotografias/service/fotografias.service";
import { Artefacto } from "../../models/artefactos/Artefacto";

@Component({
  selector: "app-ficha-card",
  templateUrl: "./ficha-card.component.html",
  styles: [],
})
export class FichaCardComponent implements OnInit {
  @Input() ficha: Artefacto;
  imagenPrincipal: Fotografia = new FotografiaImpl();

  constructor(private fotografiasService: FotografiasService) {}

  ngOnInit() {
    this.fotografiasService.iniciarFirebase();

    this.fotografiasService
      .getFotografiaPrincipal(this.ficha.id)
      .subscribe((response) => {
        this.imagenPrincipal = response;
      });
  }
}
