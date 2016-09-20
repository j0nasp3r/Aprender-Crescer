/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author j0nas
 */
public class GrupoDao {

    Grupo grupo = new Grupo();
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO grupo("
            + " idGrupo, tipoUsuario, descricaoGrupo)"
            + "  VALUES ((SELECT COALESCE(max(idGrupo)+1,1) from grupo), ?, ?);";
    static String SELECTALL = "SELECT idGrupo, tipoUsuario, descricaoGrupo FROM grupo order by idGrupo";
    static String UPDATE = "UPDATE grupo SET idGrupo = ?, tipoUsuario = ?, descricaoGrupo = ?  WHERE idGrupo = ? ;";
    static String DELETE = "DELETE FROM grupo WHERE idGrupo = ?;";

    public boolean insereNovosGrupos(Grupo grupo) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            //preparedStatement.setInt(1, grupo.getIdGrupo());
            preparedStatement.setString(1, String.valueOf(grupo.getTipoUsuario()));
            preparedStatement.setString(2, grupo.getDescricao());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir grupo: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Grupo> buscaGrupos() {
        ArrayList<Grupo> lista = new ArrayList<Grupo>();
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setIdGrupo(rs.getInt("idGrupo"));
                grupo.setTipoUsuario(rs.getString("tipoUsuario").charAt(0));
                grupo.setDescricao(rs.getString("descricaoGrupo"));
                lista.add(grupo);
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar grupos : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateGruposCadastrados(Grupo grupo) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, grupo.getIdGrupo());
            preparedStatement.setString(2, String.valueOf(grupo.getTipoUsuario()));
            preparedStatement.setString(3, grupo.getDescricao());
            preparedStatement.setInt(4, grupo.getIdGrupo());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do grupo: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean excluirGrupos(int id) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao deletar o grupo: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
}
