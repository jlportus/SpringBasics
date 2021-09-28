import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { FichasRoutingModule } from "./fichas-routing.module";
import { FormularioFichaComponent } from "./formulario-ficha/formulario-ficha.component";
import { FormsModule } from "@angular/forms";
import { ListadofichasComponent } from "./listadofichas/listadofichas.component";
import { FichaComponent } from "./listadofichas/ficha/ficha.component";

@NgModule({
  declarations: [
    FormularioFichaComponent,
    ListadofichasComponent,
    FichaComponent,
  ],
  imports: [
    CommonModule,
    FichasRoutingModule,
    FormsModule
  ],
})
export class FichasModule {}
