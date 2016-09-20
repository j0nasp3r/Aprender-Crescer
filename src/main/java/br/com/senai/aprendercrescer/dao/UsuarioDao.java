/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author j0nas
 */
public class UsuarioDao {

    Usuario usuario = new Usuario();
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO usuario("
            + " idUsuario, idGrupo, login, senhaUsuario, nomeUsuario, flagInativo)"
            + "  VALUES ((SELECT COALESCE(max(idUsuario)+1,1) from usuario) , ?, ?, ?, ?, ?);";

    static String SELECTALL = "SELECT idUsuario, idGrupo, login, senhaUsuario, nomeUsuario, dtAlteracao, "
            + "flagInativo FROM usuario order by idUsuario";
    static String UPDATE = "UPDATE usuario SET idUsuario = ?, idGrupo = ?, login = ?, senhaUsuario = ?, "
            + "nomeUsuario = ?, flagInativo = ?  WHERE idUsuario = ? ;";
    static String DELETE = "DELETE FROM usuario WHERE idUsuario = ?;";

    public boolean insereUsuarios(Usuario usuario) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
           // preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.setInt(1, usuario.getIdGrupo());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getNome());
            //preparedStatement.setString(6, usuario.getDtAlteracao().toString());
            preparedStatement.setString(5, (usuario.getFlagInativo()+""));
            //System.out.println("" + preparedStatement.toString());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Usuario> buscaUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setIdGrupo(rs.getInt("idGrupo"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senhaUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setDtAlteracao(rs.getDate("dtAlteracao"));
                usuario.setFlagInativo(rs.getString("flagInativo").charAt(0));
                lista.add(usuario);
            }

        } catch (Exception ex) {
            System.out.println("Problema ao carregar usuarios : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateUsuarios(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.setInt(2, usuario.getIdGrupo());
            preparedStatement.setString(3, usuario.getLogin());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getNome());
            //preparedStatement.setString(6, usuario.getDtAlteracao().toString());
            preparedStatement.setString(6, (usuario.getFlagInativo()) + "");
            preparedStatement.setInt(7, usuario.getIdUsuario());
            System.out.println(preparedStatement.toString());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;
    }

    public boolean excluirUsuarios(int id) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao deletar o usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;
    }
}
