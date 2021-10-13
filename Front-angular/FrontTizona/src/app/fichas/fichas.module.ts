import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { FichasRoutingModule } from "./fichas-routing.module";
import { FormularioFichaComponent } from "./formulario-ficha/formulario-ficha.component";
import { FormsModule } from "@angular/forms";
import { ListadofichasComponent } from "./listadofichas/listadofichas.component";
import { FotografiasModule } from "../fotografias/fotografias.module";
import { FichaCompletaComponent } from './ficha-completa/ficha-completa.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { FichaCardComponent } from './listadoFichas/ficha-card/ficha-card.component';

@NgModule({
  declarations: [
    FormularioFichaComponent,
    ListadofichasComponent,
    FichaCompletaComponent,
    BuscadorComponent,
    FichaCardComponent,
  ],
  imports: [
    CommonModule,
    FichasRoutingModule,
    FormsModule,
    FotografiasModule
  ],
})
export class FichasModule {}
