import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FichasRoutingModule } from './fichas-routing.module';
import { FormularioFichaComponent } from './formulario-ficha/formulario-ficha.component';
import { FichaArtificioComponent } from './ficha-artificio/ficha-artificio.component';


@NgModule({
  declarations: [FormularioFichaComponent, FichaArtificioComponent],
  imports: [
    CommonModule,
    FichasRoutingModule
  ]
})
export class FichasModule { }
