import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { EncabezadoComponent } from "./encabezado/encabezado.component";
import { CuerpoComponent } from "./cuerpo/cuerpo.component";
import { PieComponent } from "./pie/pie.component";
import { NoEncontradoComponent } from "./no-encontrado/no-encontrado.component";
import { EsqueletoComponent } from "./esqueleto.component";
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [
    EncabezadoComponent,
    CuerpoComponent,
    PieComponent,
    NoEncontradoComponent,
    EsqueletoComponent,
  ],
  imports: [CommonModule, RouterModule],
  exports: [EsqueletoComponent],
})
export class EsqueletoModule {}
