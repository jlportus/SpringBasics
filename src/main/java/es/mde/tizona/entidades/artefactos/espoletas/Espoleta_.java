package es.mde.tizona.entidades.artefactos.espoletas;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Espoleta.class)
public class Espoleta_ {

	public static volatile SingularAttribute<Espoleta, Integer> diametro;
	public static volatile SingularAttribute<Espoleta, Integer> altura;
	public static volatile SingularAttribute<Espoleta, String> tipoIniciacion;
	
	// No se consideran criterios de busqueda
//	public static volatile SingularAttribute<Espoleta, String> tipoExplosivo;
//	public static volatile SingularAttribute<Espoleta, Integer> cantidadExplosivo;
//	public static volatile SingularAttribute<Espoleta, String> retardoSeguridad;
	
	public static volatile SingularAttribute<Espoleta, Integer> profundidadCavidad;
	public static volatile SingularAttribute<Espoleta, String> tipoEspoleta;

}
