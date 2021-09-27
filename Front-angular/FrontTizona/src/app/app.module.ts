import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FotografiasModule } from './fotografias/fotografias.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FotografiasModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
