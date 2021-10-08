
import { Espoleta } from "./espoleta";

export class EspoletaImpl implements Espoleta {
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
  altura: number;
  tipoIniciacion: string;
  tipoExplosivo: string;
  cantidadExplosivo: string;
  retardoSeguridad: string;
  profundidadCavidad: number;
  tipoEspoleta: string;
}
