import { Artefacto } from "../Artefacto";
import { Espoleta } from "../espoletas/espoleta";
import { Granada } from "./granada";

export class Granadampl implements Granada {
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
  
  calibre: number;
  longitud: number;
  cargaInterior: string;
  proposito: string;
  aletas: boolean;
  espoletasCompatibles: Espoleta[];
  bandasPintura: string[];
  subArtefactos: Artefacto[];
  
  medioLanzamiento: string;
}
