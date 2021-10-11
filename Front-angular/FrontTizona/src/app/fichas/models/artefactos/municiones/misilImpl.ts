import { Artefacto } from "../Artefacto";
import { Espoleta } from "../espoletas/espoleta";
import { Misil } from "./misil";

export class MisilImpl implements Misil {
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

  colorBandaMotor: string;
  calibre: number;
  longitud: number;
  cargaInterior: string;
  proposito: string;
  aletas: boolean;
  espoletasCompatibles: Espoleta[];
  bandasPintura: string[];
  subArtefactos: Artefacto[];
  
  sistemaGuia: string;
}
