import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FotografiasRoutingModule } from './fotografias-routing.module';
import { FotografiasComponent } from './fotografias/fotografias.component';
import { FotografiaComponent } from './fotografias/fotografia/fotografia.component';



@NgModule({
  declarations: [FotografiasComponent, FotografiaComponent],
  imports: [
    CommonModule,
    FotografiasRoutingModule
  ],
  exports: [
    FotografiasComponent
  ]
})
export class FotografiasModule { }
