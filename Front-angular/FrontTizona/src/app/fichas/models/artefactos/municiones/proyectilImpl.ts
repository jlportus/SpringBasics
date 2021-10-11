import { Artefacto } from "../Artefacto";
import { Espoleta } from "../espoletas/espoleta";
import { Proyectil } from "./proyectil";

export class ProyectilImpl implements Proyectil {
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

  dibujoBajoBandaConduccion: string;
}
