/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.dao.Conexao;
import br.com.senai.aprendercrescer.model.Conta;
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
public class ContaDao {

    Conta conta = new Conta();
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO conta("
            + " idConta, descricao, tipoConta, valor)"
            + "  VALUES ((SELECT COALESCE(max(idConta)+1,1) from conta), ?, ?, ?);";
    static String SELECTALL = "SELECT idConta, descricao, tipoConta, valor FROM conta order by idConta";
    static String UPDATE = "UPDATE conta SET idConta = ?, descricao = ?, tipoConta = ?, valor = ?  WHERE idConta = ? ;";
    static String DELETE = "DELETE FROM conta WHERE idConta = ?;";

    public boolean insereNovosContas(Conta conta) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            //preparedStatement.setInt(1, conta.getIdConta());
            preparedStatement.setString(1, conta.getDescricao());
            preparedStatement.setString(2, conta.getTipoConta());
            preparedStatement.setDouble(3, conta.getValor());
            //System.out.println(preparedStatement.toString());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Conta> buscaContas() {
        ArrayList<Conta> lista = new ArrayList<Conta>();
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("idConta"));
                conta.setDescricao(rs.getString("descricao"));
                conta.setTipoConta(rs.getString("tipoConta"));
                conta.setValor(Double.parseDouble(rs.getString("valor")));
                lista.add(conta);
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar contas : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateContasCadastrados(Conta conta) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, conta.getIdConta());
            preparedStatement.setString(2, conta.getDescricao());
            preparedStatement.setString(3, conta.getTipoConta());
            preparedStatement.setDouble(4, conta.getValor());
            preparedStatement.setInt(5, conta.getIdConta());
            //System.out.println(preparedStatement.toString());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean excluirContas(int id) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao deletar o conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
}
