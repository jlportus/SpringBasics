import { Injectable } from '@angular/core';
import firebase from "firebase/app";
import 'firebase/storage';
import "firebase/analytics";
import "firebase/firestore";
import "firebase/database";
import "firebase/auth";
import { Fotografia } from '../models/fotografia';
import { FotografiaImpl } from '../models/fotografiaImpl';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class FotografiasService {
  fotografia: Fotografia = new FotografiaImpl();
  fotografiasSecundarias: Fotografia[] = [];
  fotografiasCroquis: Fotografia[] = [];
  constructor() { }


  iniciarFirebase() {
    firebase.initializeApp(environment.firebaseConfig);
  }
  getFotografiaPrincipal(id: number): Observable<Fotografia> {
    //Recuperar de Firebase la imagen principal y mostrarla
    var imagenPrincipalRef = firebase.database().ref().child(`imagenesFB/${id}/principal`);
    imagenPrincipalRef.on("value", (snapshot) => {
      //Capturar lo que hay en la BBDD (son pares clave valor)
      let data = snapshot.val();
      console.log("Obteniendo fotografia de BD", data);
      for (var key in data) {
        this.fotografia.url = data[key].url;
        this.fotografia.nombre = data[key].nombre;
        this.fotografia.tipo = data[key].tipo;
      }
    })
    return of(this.fotografia);
  }

  getFotografiasSecundarias(id: number): Observable<Fotografia[]> {
    this.fotografiasSecundarias = [];
    var imagenesSecundariasRef = firebase.database().ref().child(`imagenesFB/${id}/secundaria`);
    imagenesSecundariasRef.on("value", (snapshot) => {
      let data = snapshot.val();
      console.log("Obteniendo SECUNDARIAS de BD", data);
      for (var key in data) {
        let fotografia = new FotografiaImpl();
        fotografia.url = data[key].url;
        fotografia.nombre = data[key].nombre;
        fotografia.tipo = data[key].tipo;
        this.fotografiasSecundarias.push(fotografia);
      }
    })
    console.log("secundarias del service", this.fotografiasSecundarias)
    return of(this.fotografiasSecundarias);
  }

  getFotografiasCroquis(id: number): Observable<Fotografia[]> {
    this.fotografiasCroquis = [];
    var imagenesCroquisRef = firebase.database().ref().child(`imagenesFB/${id}/croquis`);

    this.fotografiasCroquis = [];

    imagenesCroquisRef.on("value", (snapshot) => {
      let data = snapshot.val();
      console.log("Obteniendo CROQUIS de BD", data);

      for (var key in data) {
        let fotografia = new FotografiaImpl();
        fotografia.url = data[key].url;
        fotografia.nombre = data[key].nombre;
        fotografia.tipo = data[key].tipo;
        this.fotografiasCroquis.push(fotografia);
      }
    })

    return of(this.fotografiasCroquis);
  }

  uploadImage(file: any, id: number, tipoFotografia: string): void {
    var imagenesFBRef;
    //Subir imagen a Firebase storage
    var storageRef = firebase.storage().ref().child(`imagenes/${id}/${tipoFotografia}/${file.name}`);
    storageRef.put(file).then((data) => {
      //Crear registo en Firebase Realtime Database con la URL de la imagen
      if (tipoFotografia == "principal") {
        imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/principal`);
        imagenesFBRef.remove();
        console.log("entrando en ppal")
        let arrayNombre = file.name.split(".");
        imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/principal/${arrayNombre[0]}`);
      }
      if (tipoFotografia == "secundaria") {
        //imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/secundaria`);
        let arrayNombre = file.name.split(".");
        imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/secundaria/${arrayNombre[0]}`);
      }
      if (tipoFotografia == "croquis") {
        //imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/croquis`);
        let arrayNombre = file.name.split(".");
        imagenesFBRef = firebase.database().ref().child(`imagenesFB/${id}/croquis/${arrayNombre[0]}`);
      }

      storageRef.getDownloadURL().then((url) => {
        let fotografia = new FotografiaImpl();
        fotografia.url = url;
        fotografia.nombre = file.name;
        fotografia.tipo = tipoFotografia;
        imagenesFBRef.set({ nombre: fotografia.nombre, url: fotografia.url, tipo: fotografia.tipo })
      })

    });

    this.fotografiasSecundarias = [];
    this.fotografiasCroquis = [];
  }

  
  deleteImage(fotografia: Fotografia, id: number): void {
    let nombreSinPunto = fotografia.nombre.split(".")[0];
    let imagenRef = firebase.database().ref().child(`imagenesFB/${id}/${fotografia.tipo}/${nombreSinPunto}`);
    let imagenStorageRef = firebase.storage().ref().child(`imagenes/${id}/${fotografia.tipo}/${fotografia.nombre}`);
    imagenRef.remove();
    imagenStorageRef.delete();
    this.fotografiasSecundarias = [];
    this.fotografiasCroquis = [];
  }

  //Metodo para borrar un nodo dela base de datos de Firebase
  deleteNode(id: number): void {
    let nodeRef = firebase.database().ref().child(`imagenesFB/${id}/`);
    nodeRef.remove();
    //Borrado de la carpeta correspondiente en Storage
    this.deleteFolderContents(`imagenes/${id}/`)
  }

  //Metodo para borrar una carpeta entera del Strorage
  deleteFolderContents(path) {
    const ref = firebase.storage().ref(path);
    ref.listAll()
      .then(dir => {
        dir.items.forEach(fileRef => {
          this.deleteFile(ref.fullPath, fileRef.name);
        });
        dir.prefixes.forEach(folderRef => {
          this.deleteFolderContents(folderRef.fullPath);
        })
      })
      .catch(error => {
        console.log(error);
      });
  }
  deleteFile(pathToFile, fileName) {
    const ref = firebase.storage().ref(pathToFile);
    const childRef = ref.child(fileName);
    childRef.delete()
  }
}
