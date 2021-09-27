import { Injectable } from '@angular/core';
import 'firebase/storage';
import "firebase/analytics";
import "firebase/firestore";
import "firebase/database";
import "firebase/auth";
import { initializeApp } from '@firebase/app';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class FotografiasService {

  userCredentials: any;
  app: any =  initializeApp(environment.firebaseConfig);

  constructor() { }

  uploadImage(file: any):void {
    //Subir imagen a Firebase storage
    var storageRef = this.app.storage().ref().child(`imagenes/${file.name}`);
    storageRef.put(file);
    alert('Subiendo fotografia')

    //Crear registo en Firebase Realtime Database con la URL de la imagen (necesita un delay para que primero se suba la foto a Storage)
    setTimeout(() => {
      var imagenesFBRef = this.app.database().ref().child('imagenesFB');
      storageRef.getDownloadURL().then(function (url) {
        console.log(url)
        imagenesFBRef.push({ nombre: file.name, url: url });
      })
    }, 4000)
  }

    //Para obtener una imagen de Firebase Storge por su nombre (no usado)
  getImage(): void {
    var storageRef = this.app.storage().ref().child(`imagenes/Dermapen.jpg`);
    storageRef.getDownloadURL().then(function (url) {
      var src = document.getElementById('imagen').setAttribute('src', url);
    })
  }

  //Para obtener todas las imagenes de una carpeta de FIrebase Storage
  getImages(): any{
    var result = "";
    //Referencia a la carpeta de imagenes
    var imagenesFBRef = this.app.database().ref().child('imagenesFB');
    
   imagenesFBRef.on("value", function(snapshot){
      //Capturar lo que hay en la BBDD (son pares clave valor)
      var data = snapshot.val();
      console.log("Obteniendo de BD", data);
      for(var key in data){
        result += '<img src="' + data[key].url + '"/> <br>';
      }  
      console.log(result)
    })
    return result;
  }
}
