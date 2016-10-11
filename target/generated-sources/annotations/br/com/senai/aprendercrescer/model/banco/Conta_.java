package br.com.senai.aprendercrescer.model.banco;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, String> tipoconta;
	public static volatile SingularAttribute<Conta, BigDecimal> valor;
	public static volatile SingularAttribute<Conta, Integer> idconta;
	public static volatile SingularAttribute<Conta, String> descricao;

}

