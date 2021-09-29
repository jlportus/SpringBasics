package es.mde.tizona.entidades.artefactos;

import javax.persistence.Column;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ArtefactoImpl.class)
public class ArtefactoImpl_ {

	private static volatile SingularAttribute<ArtefactoImpl, String> forma;
	private static volatile SingularAttribute<ArtefactoImpl, String> color;
	private static volatile SingularAttribute<ArtefactoImpl, String> fabricacion;
	private static volatile ListAttribute<ArtefactoImpl, String> encontradoEn;
	private static volatile SingularAttribute<ArtefactoImpl, String> marcasFrio;
	private static volatile SingularAttribute<ArtefactoImpl, String> marcasPintura;

}
