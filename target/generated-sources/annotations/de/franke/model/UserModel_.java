package de.franke.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserModel.class)
public abstract class UserModel_ {

	public static volatile SingularAttribute<UserModel, String> firstName;
	public static volatile SingularAttribute<UserModel, String> lastName;
	public static volatile SingularAttribute<UserModel, String> password;
	public static volatile SingularAttribute<UserModel, String> futureLastName;
	public static volatile ListAttribute<UserModel, GuestModel> guests;
	public static volatile SingularAttribute<UserModel, Integer> id;
	public static volatile SingularAttribute<UserModel, String> userName;
	public static volatile SingularAttribute<UserModel, String> marriagePartner;
	public static volatile ListAttribute<UserModel, BudgetModel> budget;

}

