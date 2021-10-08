import { Artefacto } from "./Artefacto";

export class ArtefactoImpl implements Artefacto {
  id: number;
  nombre: String;
  descripcion: String;
  funcionamiento: String;
  forma: String;
  color: String;
  fabricacion: String;
  encontradoEn: String[];
  listadoImagenes: String[];
  marcasFrio: String;
  marcasPintura: String;

  // constructor(
  //   $nombre: String,
  //   $descripcion: String,
  //   $funcionamiento: String,
  //   $forma: String,
  //   $color: String,
  //   $fabricacion: String,
  //   $encontradoEn: String[],
  //   $listadoImagenes: String[],
  //   $marcasFrio: String,
  //   $marcasPintura: String
  // ) {
  //   this.nombre = $nombre;
  //   this.descripcion = $descripcion;
  //   this.funcionamiento = $funcionamiento;
  //   this.forma = $forma;
  //   this.color = $color;
  //   this.fabricacion = $fabricacion;
  //   this.encontradoEn = $encontradoEn;
  //   this.listadoImagenes = $listadoImagenes;
  //   this.marcasFrio = $marcasFrio;
  //   this.marcasPintura = $marcasPintura;
  // }
}
