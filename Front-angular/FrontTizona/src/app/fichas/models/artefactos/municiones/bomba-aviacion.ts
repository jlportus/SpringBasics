
import { Municion } from "./municion";

export interface BombaAviacion extends Municion {
  pinturaProteccionTermica: boolean;
  distanciaAnillas: number;
  tipoEstabilizador: string;
  venterolEnEstabilizador: boolean;
}
