package es.mde.tizona.entidades.artefactos.minas;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@StaticMetamodel(Mina.class)
public class Mina_ {

	public static volatile SingularAttribute<Mina, Integer> diametro;
	public static volatile SingularAttribute<Mina, Integer> fondo;
	public static volatile SingularAttribute<Mina, Integer> longitud;
	public static volatile SingularAttribute<Mina, Integer> altura;
	public static volatile SingularAttribute<Mina, String> materialEnvuelta;
	public static volatile SingularAttribute<Mina, String> situacionEspoleta;
	
	// No se consideran criterios de busqueda
//	public static volatile SingularAttribute<Mina, String> tipoExplosivo;
//	public static volatile SingularAttribute<Mina, Integer> pesoExplosivo;
	
	public static volatile SingularAttribute<Mina, Boolean> asaTransporte;
	public static volatile SingularAttribute<Mina, String> sistemaIniciacion;
	public static volatile SingularAttribute<Mina, String> tipoMina;
}
