import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { BuscadorComponent } from "./buscador/buscador.component";
import { FormularioFichaComponent } from "./formulario-ficha/formulario-ficha.component";
import { ListadofichasComponent } from "./listadofichas/listadofichas.component";

const routes: Routes = [
  {
    path: ``,
    children: [
      {
        path: `formulario`,
        component: FormularioFichaComponent,
      },
      {
         path: `fichas`,
         component: ListadofichasComponent,
      },
      {
         path: `buscador`,
         component: BuscadorComponent,
       },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FichasRoutingModule {}
