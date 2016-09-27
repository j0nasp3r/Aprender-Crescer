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
        if (usuario.getIdUsuario() != 0) {
            return usuarioDao.updateUsuarios(usuario);
        } else {
            return usuarioDao.insereUsuarios(usuario);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.buscaUsuarios();
    }

    public boolean deleteCadastro(int id) {
        return usuarioDao.excluirUsuarios(id);
    }
}
