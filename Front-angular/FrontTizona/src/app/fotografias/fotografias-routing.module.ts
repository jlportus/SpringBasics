import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FotografiasComponent } from './fotografias/fotografias.component';


const routes: Routes = [
  {
    path: ``,
    component: FotografiasComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FotografiasRoutingModule { }
