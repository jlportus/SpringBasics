import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./comunes/home/home/home.component";
import { NoEncontradoComponent } from "./esqueleto/no-encontrado/no-encontrado.component";
import { FotografiasComponent } from "./fotografias/fotografias/fotografias.component";

const routes: Routes = [
  {
    path: ``,
    component: HomeComponent,
  },
  {
    path: `acerca`,
    loadChildren: () =>
      import("src/app/comunes/acerca/acerca.module").then(
        (m) => m.AcercaModule
      ),
  },
  {
    path: `fotografias`,
    loadChildren: () =>
      import("src/app/fotografias/fotografias.module").then(
        (m) => m.FotografiasModule
      ),
  },
  
  {
    path: `**`,
    redirectTo: `not-found`,
  },
  {
    path: `not-found`,
    component: NoEncontradoComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
