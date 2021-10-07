import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { FichasRoutingModule } from "./fichas-routing.module";
import { FormularioFichaComponent } from "./formulario-ficha/formulario-ficha.component";
import { FormsModule } from "@angular/forms";
import { ListadofichasComponent } from "./listadofichas/listadofichas.component";
import { FichaComponent } from "./listadofichas/ficha/ficha.component";
import { FotografiasModule } from "../fotografias/fotografias.module";
import { BuscadorComponent } from './buscador/buscador.component';

@NgModule({
  declarations: [
    FormularioFichaComponent,
    ListadofichasComponent,
    FichaComponent,
    BuscadorComponent,
  ],
  imports: [
    CommonModule,
    FichasRoutingModule,
    FormsModule,
    FotografiasModule
  ],
})
export class FichasModule {}
