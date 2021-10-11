import { Component, Input, OnInit } from '@angular/core';
import { FotografiasService } from 'src/app/fotografias/service/fotografias.service';
import { ArtefactoImpl } from '../models/ArtefactoImpl';
import { FichaService } from '../services/ficha.service';

@Component({
  selector: 'app-ficha-completa',
  templateUrl: './ficha-completa.component.html',
  styleUrls: ['./ficha-completa.component.css' ]
})
export class FichaCompletaComponent implements OnInit {
  @Input() id: number;
  artefacto: any;
  urlImagenPrincipal: string = "../../../assets/trasera.jpg";
  urlImagenesSecundarias: string[] = ["../../../assets/despiece.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg"]
  urlImagenesCroquis: string[] = ["../../../assets/despiece.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg", "../../../assets/trasera.jpg"]
  atributos: string[][] = [];
  atributo: string[] = [];
  imagenModal: string;

  
  constructor(private fotografiasService: FotografiasService, private fichaService: FichaService) {
    this.artefacto = new ArtefactoImpl("PMN-2", "Es una mina contra-personal pdfowef fofnfenw fwojfoodkpq qewodfibf qd ojnqojdo doldfnqojhfqhw   qowjdoqwdoqjwd qpwdmj. ojfiwfi 9hdfqpdjn ihqweofd q0odf wefwef.", "Funciona gaciendo PUM dewfdgd dq2uig2vb 2dwidwugfd2 dqkdhugdqw dqigdufwqd diwghwqugsd qidbhuidwqv iohdw9g  iwqgufdwq  khuiqwfd owdqhuiwqg wqdihwqduf qdwqdf.", "cilindrica", "verde", "URSS", null, null, null, "letras en negro en cirílico");

   }
  ngOnInit() {
    Object.keys(this.artefacto).map((key)=>{

      // Recorrer el objeto artefacto cogiendo cada atributo y metiendolo en el array atributos. 
      //También cambio de los nombres de variable compuestos.
      if(key.toUpperCase()=="MARCASPINTURA"){
        this.atributo = ["MARCAS DE PINTURA", this.artefacto[key]];
      }else{
        this.atributo = [key.toUpperCase(), this.artefacto[key]];
      }
     this.atributos.push(this.atributo);
    })
  }
  //Obtener la URL de una imagen al hacer click
  getImagenURL(event): void {
    console.log(event.target.src)
    this.imagenModal = event.target.src;
  }
  getArtefacto(): void {
    // Obtener los datod del artefacto haciendo una llamada a la API.

    // Obtener las imagenes del artefacto de Firebase.

  }
}
