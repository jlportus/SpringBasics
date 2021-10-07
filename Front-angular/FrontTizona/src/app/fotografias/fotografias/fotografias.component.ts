import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Fotografia } from '../models/fotografia';
import { FotografiaImpl } from '../models/fotografiaImpl';
import { FotografiasService } from '../service/fotografias.service';

@Component({
  selector: 'app-fotografias',
  templateUrl: './fotografias.component.html',
  styles: []
})

export class FotografiasComponent implements OnInit {
  //Variable para mostrar o no el componente Fotografias
  imagenesFBRef: any;
  @Input() id: number;

  //Fotografias reciidas de la base de datos de Firebase
  fotografiaPrincipal: Fotografia[] = [];
  fotografiasSecundarias: Fotografia[] = [];
  fotografiasCroquis: Fotografia[] = [];

  //Fotografias seleccionadas para subir
  fotografiaPrincipalASubir: File;
  fotografiasSecundariasASubir: File[] = [];
  fotografiasCroquisASubir: File[] = [];

  //Previsualización de imagenes a subir
  previewSecundarias: Fotografia[] = [];
  previewCroquis: Fotografia[] = [];

  @Output() enviarEvent = new EventEmitter<boolean>();

  constructor(private fotografiasService: FotografiasService) { }

  ngOnInit() {
    // Iniciar Firebase
    this.fotografiasService.iniciarFirebase();
  }

  //Seleccion de las imagenes a subir.
  seleccionarImagenes(e, tipoFotografia): any {
    console.log(e.target.files[0])

    console.log(e)
    for (let index = 0; index < e.target.files.length; index++) {
      let fotografia = new FotografiaImpl();
      fotografia.nombre = e.target.files[index].name;
      fotografia.url = URL.createObjectURL(e.target.files[index]);
      console.log(fotografia)
      fotografia.tipo = tipoFotografia;
      if (tipoFotografia == 'secundaria') {
        this.fotografiasSecundariasASubir.push(e.target.files[index]);
      } if (tipoFotografia == 'croquis') {
        this.fotografiasCroquisASubir.push(e.target.files[index]);
      } if (tipoFotografia == 'principal') {
        this.fotografiaPrincipal = [];
        this.fotografiaPrincipalASubir = e.target.files[index];
      }
    }
    console.log(this.fotografiasSecundariasASubir)
    this.previewImagenes(e, tipoFotografia);
  }

  previewImagenes(e, tipoFotografia): void {
    for (let index = 0; index < e.target.files.length; index++) {
      let fotografia = new FotografiaImpl();
      fotografia.nombre = e.target.files[index].name;
      fotografia.url = URL.createObjectURL(e.target.files[index]);
      console.log(fotografia)
      fotografia.tipo = tipoFotografia;
      if (tipoFotografia == 'secundaria') {
        //this.subirImagenes(this.fotografiasSecundariasASubir, id, tipoFotografia
        this.previewSecundarias.push(fotografia);
      } if (tipoFotografia == 'croquis') {
        //this.subirImagenes(this.fotografiasCroquisASubir, id, tipoFotografia)   
        this.previewCroquis.push(fotografia);
      } if (tipoFotografia == 'principal') {
        this.fotografiaPrincipal = [];
        this.fotografiaPrincipal.push(fotografia);
      }
    }
  }

  //Subida a Firebase de las imagenes
  subirImagenes(): void {
    //this.fotografiasService.deleteNode(this.id);
    ///////////////////////
    this.enviarEvent.emit(true);

    this.fotografiasService.uploadImage(this.fotografiaPrincipalASubir, this.id, "principal");

    this.fotografiasSecundariasASubir.forEach(element => {
      this.fotografiasService.uploadImage(element, this.id, "secundaria");
    });
    this.fotografiasCroquisASubir.forEach(element => {
      this.fotografiasService.uploadImage(element, this.id, "croquis");
    });

  }

  //Obtener las imagenes de la base de datos
  public mostrarImagenesSubidas(): void {
    this.fotografiaPrincipal = [];
    this.fotografiasSecundarias = [];
    this.fotografiasCroquis = [];

    this.fotografiasService.getFotografiaPrincipal(this.id).subscribe((fotografia) => {

      this.fotografiaPrincipal.push(fotografia);
    })
    //Recuperar de Firebase las imagenes secundarias y mostrarlas
    this.fotografiasService.getFotografiasSecundarias(this.id).subscribe((fotografias) => {
      this.fotografiasSecundarias = [];
      this.fotografiasSecundarias = fotografias;
    })
    this.fotografiasService.getFotografiasCroquis(this.id).subscribe((fotografias) => {
      this.fotografiasCroquis = [];
      this.fotografiasCroquis = fotografias;
    })

  }

  //Des-seleccionar una imagen desde el boton X del componente Fotografia (recibe una fotografia a traves del Output)

  deseleccionarImagen(fotografia: Fotografia): void {

    if (fotografia.tipo == "principal") {
      console.log(fotografia)
      this.fotografiaPrincipal = [];
    }
    if (fotografia.tipo == "secundaria") {
      let arrayCambio = [];
      this.previewSecundarias.forEach(element => {
        if (element.nombre !== fotografia.nombre) {
          arrayCambio.push(element)
        }
      });
      this.previewSecundarias = arrayCambio;
    }

    if (fotografia.tipo == "croquis") {
      let arrayCambio = [];
      this.previewCroquis.forEach(element => {
        if (element.nombre !== fotografia.nombre) {
          arrayCambio.push(element)
        }
      });
      this.previewCroquis = arrayCambio;
    }
  }

}
