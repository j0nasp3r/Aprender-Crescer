/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.UsuarioDao;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;

/**
 * @author j0nas
 */
public class UsuarioController {

    UsuarioDao usuarioDao;
    Usuario usuario;

    public UsuarioController() {
        usuarioDao = new UsuarioDao();
    }

    public boolean insereCadastro(Usuario usuario) {
        usuarioDao.gravar(usuario);
        return true;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.getAll();
    }

    public boolean deleteCadastro(int id) {
        Usuario us = new Usuario(id);
        usuarioDao.apagar(us);
        return true;
    }
}
