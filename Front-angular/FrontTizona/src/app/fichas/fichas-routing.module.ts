import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { FichaCompletaComponent } from "./ficha-completa/ficha-completa.component";
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
        path: `ficha-completa`,
        component: FichaCompletaComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FichasRoutingModule {}
