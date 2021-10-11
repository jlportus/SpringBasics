import { Artefacto } from "../Artefacto";

export interface Mina extends Artefacto {
  diametro: number;
  fondo: number;
  longitud: number;
  altura: number;
  materialEnvuelta: string;
  situacionEspoleta: string;
  tipoExplosivo: string;
  pesoExplosivo: number;
  asaTransporte: boolean;
  sistemaIniciacion: string;
  tipoMina: string;
}
