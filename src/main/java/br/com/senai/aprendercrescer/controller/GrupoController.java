/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.Grupo;
import java.util.ArrayList;

/**
 *
 * @author j0nas
 */
public class GrupoController {
    GrupoDao grupoDao;
    Grupo grupo;

    public GrupoController() {
        grupoDao = new GrupoDao();
    }

    public boolean insereGrupo(Grupo grupo) {
        if (grupo.getIdGrupo() != 0) {
            return grupoDao.updateGruposCadastrados(grupo);
        } else {
            return grupoDao.insereNovosGrupos(grupo);
        }
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.buscaGrupos();
    }

    public boolean deleteCadastro(int id) {
        return grupoDao.excluirGrupos(id);
    }
}
