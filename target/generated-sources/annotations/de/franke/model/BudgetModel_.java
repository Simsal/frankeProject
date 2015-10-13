package de.franke.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BudgetModel.class)
public abstract class BudgetModel_ {

	public static volatile SingularAttribute<BudgetModel, String> description;
	public static volatile SingularAttribute<BudgetModel, Integer> id;
	public static volatile SingularAttribute<BudgetModel, UserModel> user;
	public static volatile SingularAttribute<BudgetModel, Float> value;

}

