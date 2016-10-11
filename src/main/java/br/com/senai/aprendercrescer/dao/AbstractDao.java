/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.AbstractModel;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;

/**
 *
 * @author j0nas
 */
public abstract class AbstractDao<T extends AbstractModel> {
    EntityManager em;
    
    public AbstractDao()
    {
        em = Conexao.getConexao();
    }
    
    public void gravar(T objeto){
        em.getTransaction().begin();//pega a transação e inicia
        if (objeto.isNew()){
            em.persist(objeto);
        }else {
            em.merge(objeto);
        }
        em.getTransaction().commit();
    }
    
    public void apagar(T objeto){
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
    public ArrayList<T> getAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(getClassDominio()));
        return (ArrayList<T>) em.createQuery(cq).getResultList();
    }
    
    public Class getClassDominio(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
}
