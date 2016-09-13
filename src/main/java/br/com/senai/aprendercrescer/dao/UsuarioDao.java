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
            + " idUsuario, idGrupo, login, senhaUsuario, nomeUsuario, dtAlteracao, flagInativo)"
            + "  VALUES ((SELECT COALESCE(max(idUsuario)+1,1) from usuario) , ?, ?, ?, ?, ?, ?);";

    static String SELECTALL = "SELECT idUsuario, idGrupo, login, senhaUsuario, nomeUsuario, dtAlteracao, "
            + "flagInativo FROM usuario order by idUsuario";
    static String UPDATE = "UPDATE usuario SET idUsuario = ?, idGrupo = ?, login = ?, senhaUsuario = ?, "
            + "nomeUsuario = ?, dtAlteracao = ?, flagInativo = ?  WHERE idUsuario = ? ;";
    static String DELETE = "DELETE FROM usuario WHERE idUsuario = ?;";

    public boolean insereUsuario(Usuario usuario) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.setInt(2, usuario.getIdUsuario());
            preparedStatement.setString(3, usuario.getLogin());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getNome());
            preparedStatement.setString(6, (usuario.getDtAlteracao()).toString());
            preparedStatement.setString(7, String.valueOf(usuario.getFlagInativo()));
            
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
                conta.setDescricao(rs.getString("descricao"));
                conta.setIdConta(rs.getInt("idconta"));
                conta.setTipoConta(rs.getString("tipoconta").toCharArray()[0]);
                conta.setValor(rs.getDouble("valor"));
                lista.add(conta);

            }

        } catch (Exception ex) {
            System.out.println("Problema ao carregar usuarios : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateConta(Conta conta) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, conta.getIdConta());
            preparedStatement.setString(2, conta.getDescricao());
            preparedStatement.setString(3, conta.getTipoConta() + "");
            preparedStatement.setDouble(4, conta.getValor());
            preparedStatement.setInt(5, conta.getIdConta());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;
    }

    public boolean excluir(int id) {
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
}
