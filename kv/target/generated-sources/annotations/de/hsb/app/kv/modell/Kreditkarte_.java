package de.hsb.app.kv.modell;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Kreditkarte.class)
public abstract class Kreditkarte_ {

	public static volatile SingularAttribute<Kreditkarte, Kreditkartentyp> typ;
	public static volatile SingularAttribute<Kreditkarte, Integer> id;
	public static volatile SingularAttribute<Kreditkarte, Date> gueltigBis;
	public static volatile SingularAttribute<Kreditkarte, String> inhaber;
	public static volatile SingularAttribute<Kreditkarte, String> nummer;

}

