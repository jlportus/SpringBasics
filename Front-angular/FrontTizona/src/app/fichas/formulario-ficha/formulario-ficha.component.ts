import { Component, EventEmitter, OnInit, Output, ViewChild } from "@angular/core";
import { FotografiasComponent } from "src/app/fotografias/fotografias/fotografias.component";
import { Artefacto } from "../models/Artefacto";
import { ArtefactoImpl } from "../models/ArtefactoImpl";
import { FichaService } from "../services/ficha.service";

@Component({
  selector: "app-formulario-ficha",
  templateUrl: "./formulario-ficha.component.html",
  styles: [],
})
export class FormularioFichaComponent implements OnInit {
  id: number;
  //ViewChild para poder acceder a los metodos del hijo
  @ViewChild(FotografiasComponent, {read: false, static:true}) hijo: FotografiasComponent;

  private artefacto: Artefacto = new ArtefactoImpl(
    "",
    "",
    "",
    "",
    "",
    "",
    [],
    [],
    "",
    ""
  );
  constructor(private fichaService: FichaService) {}

  ngOnInit() {}
  
 

  salvarArtefacto() {
    this.id = undefined;
    this.fichaService
      .postArtefacto(this.artefacto)
      .subscribe((response) => {
        let url = response._links.self.href
        for (let index = url.length-1; index > 0; index--) {
          if(url[index]!=="/"){
            if(this.id == undefined){
              this.id = url[index]
            }else{
              this.id = url[index] + this.id;
            }
          }else{
            break;
          } 
        }
        this.hijo.subirImagenes(this.id);
      });
  }
}
