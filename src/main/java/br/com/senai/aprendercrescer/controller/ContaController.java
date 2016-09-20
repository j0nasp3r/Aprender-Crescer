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
        if (conta.getIdConta() != 0) {
            return contaDao.updateContasCadastrados(conta);
        } else {
            return contaDao.insereNovosContas(conta);
        }
    }

    public ArrayList<Conta> getContas() {
        return contaDao.buscaContas();
    }

    public boolean deleteCadastro(int id) {
        return contaDao.excluirContas(id);
    }
}
