package es.mde.tizona.entidades.artefactos;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ArtefactoImpl.class)
public class ArtefactoImpl_ {

	public static volatile SingularAttribute<ArtefactoImpl, String> forma;
	public static volatile SingularAttribute<ArtefactoImpl, String> color;
	public static volatile SingularAttribute<ArtefactoImpl, String> fabricacion;
	public static volatile ListAttribute<ArtefactoImpl, String> encontradoEn;
	public static volatile SingularAttribute<ArtefactoImpl, String> marcasFrio;
	public static volatile SingularAttribute<ArtefactoImpl, String> marcasPintura;



}
