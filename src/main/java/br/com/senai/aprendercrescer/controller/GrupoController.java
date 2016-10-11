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
        grupoDao.gravar(grupo);
        return true;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getAll();
    }

    public boolean deleteCadastro(int id) {
        Grupo gp = new Grupo(id);
        grupoDao.apagar(gp);
        return true;
    }
}
