import { Mina } from "./mina";

export class MinaImpl implements Mina {
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
