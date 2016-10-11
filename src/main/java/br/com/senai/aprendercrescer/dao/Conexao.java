/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author j0nas
 */
public class Conexao {
    static EntityManager em;
    static EntityManagerFactory emf;
    
    public static EntityManager getConexao(){
        if (em == null){
            emf = Persistence.createEntityManagerFactory("AprenderCrescer");
            em = emf.createEntityManager();
        }
        return em;
    }
}
