import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FotografiasRoutingModule } from './fotografias-routing.module';
import { FotografiasComponent } from './fotografias/fotografias.component';
import { SubirFotografiasComponent } from './subir-fotografias/subir-fotografias.component';



@NgModule({
  declarations: [FotografiasComponent, SubirFotografiasComponent],
  imports: [
    CommonModule,
    FotografiasRoutingModule
  ],
  exports: [
    FotografiasComponent
  ]
})
export class FotografiasModule { }
