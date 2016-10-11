/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.ContaDao;
import br.com.senai.aprendercrescer.model.Conta;
import java.util.ArrayList;

/**
 *
 * @author j0nas
 */
public class ContaController {

    ContaDao contaDao;
    Conta conta;

    public ContaController() {
        contaDao = new ContaDao();
    }

    public boolean insereConta(Conta conta) {
        contaDao.gravar(conta);
        return true;
    }

    public ArrayList<Conta> getContas() {
        return contaDao.getAll();
    }

    public boolean deleteCadastro(int id) {
        Conta us = new Conta(id);
        contaDao.apagar(us);
        return true;
    }
}
