import { Injectable } from '@angular/core';
import firebase from "firebase/app";
import 'firebase/storage';
import "firebase/analytics";
import "firebase/firestore";
import "firebase/database";
import "firebase/auth";
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Archivo } from '../models/archivo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class FotografiasService {

  private endpoint = environment.urlAPI + "/archivoArtefactos"
  url: string;

  userCredentials: any;

  constructor(private http: HttpClient) { }

  uploadImage(file: any): string{
    
    //Subir imagen a Firebase storage
    // var storageRef = firebase.storage().ref().child(`imagenes/${file.name}`);
    // storageRef.put(file).then(function (snapshot) {
    //   console.log(snapshot)
    //   storageRef.getDownloadURL().then(function (url) {
    //     console.log(url)
    //     this.url = url;
    //   })
    // });
    alert('Subiendo fotografia');
    //Crear registo en Firebase Realtime Database con la URL de la imagen (necesita un delay para que primero se suba la foto a Storage)
    return this.url;
  }

  postArchivo(archivo: Archivo): Observable<any> {
    return this.http.post<any>(this.endpoint, archivo);
  }

  //Para obtener una imagen de Firebase Storge por su nombre (no usado)
  getImage(): void {
    var storageRef = firebase.storage().ref().child(`imagenes/Dermapen.jpg`);
    storageRef.getDownloadURL().then(function (url) {
      var src = document.getElementById('imagen').setAttribute('src', url);
    })
  }

  //Para obtener todas las imagenes de una carpeta de FIrebase Storage
  getImages(): any {
    var result = "";
    //Referencia a la carpeta de imagenes
    var imagenesFBRef = firebase.database().ref().child('imagenesFB');

    imagenesFBRef.on("value", function (snapshot) {
      //Capturar lo que hay en la BBDD (son pares clave valor)
      var data = snapshot.val();
      console.log("Obteniendo de BD", data);
      for (var key in data) {
        result += '<img src="' + data[key].url + '"/> <br>';
      }
      console.log(result)
    })
    return result;
  }
}
