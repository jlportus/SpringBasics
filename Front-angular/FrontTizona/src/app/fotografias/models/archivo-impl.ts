import { Archivo } from "./archivo";


export class ArchivoImpl implements Archivo{
    artefacto: string;
    nombreArchivo: string;
    uRLArchivo: string;
    constructor(){
        this.artefacto = "";
        this.nombreArchivo = "";
        this.uRLArchivo = "";
    }
}
