import { Artefacto } from "../Artefacto";
import { Espoleta } from "../espoletas/espoleta";

export interface Municion extends Artefacto {
  calibre: number;
  longitud: number;
  cargaInterior: string;
  proposito: string;
  aletas: boolean;
  espoletasCompatibles: Espoleta[];
  bandasPintura: string[];
  subArtefactos: Artefacto[];
}
