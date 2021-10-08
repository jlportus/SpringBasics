import { Artefacto } from "../Artefacto";

export interface Espoleta extends Artefacto {
  diametro: number;
  altura: number;
  tipoIniciacion: string;
  tipoExplosivo: string;
  cantidadExplosivo: string;
  retardoSeguridad: string;
  profundidadCavidad: number;
  tipoEspoleta: string;
}
