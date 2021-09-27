import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AcercaRoutingModule } from './acerca-routing.module';
import { ContactoComponent } from './contacto/contacto.component';
import { InfoComponent } from './info/info.component';



@NgModule({
  declarations: [ContactoComponent, InfoComponent],
  imports: [
    CommonModule,
    AcercaRoutingModule
  ]
})
export class AcercaModule { }
