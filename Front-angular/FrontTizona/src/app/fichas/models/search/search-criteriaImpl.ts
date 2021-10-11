export class SearchCriteriaImpl {
  
//de artefactos

  forma: string;
  color: string;
  fabricacion: string;
  // encontradoEn: string[],
  marcasFrio: string;
  marcasPintura: string;

// criterios especificos de Minas

  // para diametro
  diametroMax: number;
  diametroMin: number;
  // para fondo
  fondoMax: number;
  fondoMin: number;
  // para longitud
  longitudMax: number;
  longitudMin: number;
  // para altura
  alturaMax: number;
  alturaMin: number;

  materialEnvuelta: string;
  situacionEspoleta: string;

  // no se consideran criterios de busqueda
  //   tipoExplosivo;
  //   pesoExplosivo;
  asaTransporte: boolean;
  sistemaIniciacion: string;
  tipoMina: string;

// de Municiones

  // para calibre
  calibreMax: number;
  calibreMin: number;
  // longitud ya esta en mina
  proposito: string;
  aletas: boolean;

// de proyectil
  dibujoBajoBandaConduccion: string;

// de bombas de aviacion
  pinturaProteccionTermica: boolean;
  distanciaAnillasMax: number;
  distanciaAnillasMin: number;
  tipoEstabilizador: string;
  venterolEnEstabilizador: boolean;

// de Cohete
  colorBandaMotor: string;

// de Misil
  sistemaGuia: string;

// de Granada
  medioLanzamiento: string;

// de espoleta
  // diametro ya esta
  // altura ya esta
  tipoIniciacion: string;
  // para profundidad
  profundidadCavidadMax: number;
  profundidadCavidadMin: number;
  tipoEspoleta: string;

// de Otro
  // proposito ya esta;
}
