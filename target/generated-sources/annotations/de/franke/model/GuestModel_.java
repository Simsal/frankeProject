package de.franke.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GuestModel.class)
public abstract class GuestModel_ {

	public static volatile SingularAttribute<GuestModel, String> firstName;
	public static volatile SingularAttribute<GuestModel, String> lastName;
	public static volatile SingularAttribute<GuestModel, String> town;
	public static volatile SingularAttribute<GuestModel, String> street;
	public static volatile SingularAttribute<GuestModel, String> postalCode;
	public static volatile SingularAttribute<GuestModel, Boolean> invited;
	public static volatile SingularAttribute<GuestModel, Long> id;
	public static volatile SingularAttribute<GuestModel, String> marriageSide;
	public static volatile SingularAttribute<GuestModel, UserModel> user;
	public static volatile SingularAttribute<GuestModel, String> email;

}

