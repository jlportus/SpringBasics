import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Fotografia } from 'src/app/fotografias/models/fotografia';
import { FotografiasService } from 'src/app/fotografias/service/fotografias.service';
import { FichaService } from '../services/ficha.service';

@Component({
  selector: 'app-ficha-completa',
  templateUrl: './ficha-completa.component.html',
  styleUrls: ['./ficha-completa.component.css']
})
export class FichaCompletaComponent implements OnInit {
  id: number = this.activatedRoute.snapshot.params['id'];
  artefacto: any;
  imagenPrincipal: Fotografia;
  imagenesSecundarias: Fotografia[] = [];
  imagenesCroquis: Fotografia[] = [];
  atributos: string[][] = [];
  atributo: string[] = [];
  imagenModal: string;


  constructor(private fotografiasService: FotografiasService, private fichaService: FichaService, private activatedRoute: ActivatedRoute) {

  }
  ngOnInit() {

    this.fotografiasService.iniciarFirebase();

    this.getArtefacto();
  }

  //Obtener la URL de una imagen al hacer click
  getImagenURL(event): void {
    console.log(event.target.src);
    this.imagenModal = event.target.src;
  }
  
  getArtefacto(): void {
    // Obtener los datos del artefacto haciendo una llamada a la API.
    this.fichaService.getFicha(this.id).subscribe((response)=>{
      this.artefacto = response;
      this.pintarDatosArtefacto(this.artefacto);
    })

    // Obtener las imagenes del artefacto de Firebase.
    this.fotografiasService.getFotografiaPrincipal(this.id).subscribe((response) => {
      this.imagenPrincipal = response;
    })
    this.fotografiasService.getFotografiasSecundarias(this.id).subscribe((response) => {
      this.imagenesSecundarias = response;
    })
    this.fotografiasService.getFotografiasCroquis(this.id).subscribe((response) => {
      this.imagenesCroquis = response;
    })
  }

  pintarDatosArtefacto(artefacto: any): void {
    console.log(artefacto)
 //Recorrer los atributos del objeto como si fuesen pares clave-valor de un map.
 Object.keys(this.artefacto).map((key) => {

  // Recorrer el objeto artefacto cogiendo cada atributo y metiendolo en el array atributos. 
  //También cambio de los nombres de variable compuestos.
  if (key.toUpperCase() == "MARCASPINTURA") {
    this.atributo = ["MARCAS DE PINTURA", this.artefacto[key]];
  } 
  else if (key.toUpperCase() == "MARCASFRIO") {
    this.atributo = ["MARCAS EN FRIO", this.artefacto[key]];
  }
  else if (key.toUpperCase() == "_LINKS"){
    this.atributo = [null, null];
  }
  else {
    this.atributo = [key.toUpperCase(), this.artefacto[key]];
  }
  this.atributos.push(this.atributo);
})
  }
}
