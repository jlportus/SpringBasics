import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ContactoComponent } from "./contacto/contacto.component";
import { InfoComponent } from "./info/info.component";

const routes: Routes = [
  {
    path: ``,
    children: [
      {
        path: `info`,
        component: InfoComponent,
      },
      {
        path: `contacto`,
        component: ContactoComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AcercaRoutingModule {}
