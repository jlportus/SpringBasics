package es.mde.tizona.entidades.artefactos.municiones;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Municion.class)
public class Municion_ {
	
	public static volatile SingularAttribute<Municion, Integer> calibre;
	public static volatile SingularAttribute<Municion, Integer> longitud;
	public static volatile SingularAttribute<Municion, String> proposito;
	public static volatile SingularAttribute<Municion, Boolean> aletas;

}
