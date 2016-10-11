package br.com.senai.aprendercrescer.model.banco;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senhausuario;
	public static volatile SingularAttribute<Usuario, String> login;
	public static volatile SingularAttribute<Usuario, Date> dtalteracao;
	public static volatile SingularAttribute<Usuario, String> flaginativo;
	public static volatile SingularAttribute<Usuario, Integer> idgrupo;
	public static volatile SingularAttribute<Usuario, String> nomeusuario;
	public static volatile SingularAttribute<Usuario, Integer> idusuario;

}

