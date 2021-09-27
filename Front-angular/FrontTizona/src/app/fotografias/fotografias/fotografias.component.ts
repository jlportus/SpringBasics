import { Component, OnInit } from '@angular/core';
import firebase from "firebase/app";
import 'firebase/storage';
import "firebase/analytics";
import "firebase/firestore";
import "firebase/database";
import "firebase/auth";
import { FotografiasService } from '../service/fotografias.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-fotografias',
  templateUrl: './fotografias.component.html',
  styles: []
})

export class FotografiasComponent implements OnInit {

  constructor(private fotografiasService: FotografiasService) { }

  ngOnInit() {
    // Initialize Firebase
    firebase.initializeApp(environment.firebaseConfig);
    //this.getImage();
    this.showImages();
  }

  //Seleccion de la imagen a subir a Firebase.
  selectImage(e): any {
    const file = e.target.files[0];
    console.log(file);

    const reader = new FileReader();
    reader.addEventListener('load', (event) => {
      let image = document.getElementById("preview")
      image.setAttribute('src', String(event.target));
    });

    reader.readAsDataURL(file);
    setTimeout(()=>{
      if (confirm("¿Desea subir esta imagen?" + file.name)) {
        this.fotografiasService.uploadImage(file);
      } else {
        console.log(file)
        alert(" La imagen " + file.name + " no se ha subido")
      }
    }, 500) 
  }

  //Para obtener las imagenes de la base de datos
  public showImages(): void {
    if (this.fotografiasService.userCredentials == undefined) {
      //Referencia a la carpeta de imagenes
      var imagenesFBRef = firebase.database().ref().child('imagenesFB');
      var result = "<div class='container'>";
      imagenesFBRef.on("value", function (snapshot) {
        //Capturar lo que hay en la BBDD (son pares clave valor)
        var data = snapshot.val();
        console.log("Obteniendo de BD", data);
        for (var key in data) {
          result += '<div class="col-2 mx-1"  style="display: inline-block;"><img src="' + data[key].url + '" style="width: 150px; displai"/> </div>';
        }
        result += '</div>'
       
        document.getElementById("fotos").innerHTML = result;
        result = ""
      })
    }
  }

}
