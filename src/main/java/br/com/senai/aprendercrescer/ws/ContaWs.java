/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.ContaController;
import br.com.senai.aprendercrescer.model.Conta;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author j0nas
 */
@Path("/conta")
public class ContaWs {

    @GET
    @Path("/getContas")
    @Produces("application/json")
    public Response getAllContas() {

        try {
            ContaController contaController;
            contaController = new ContaController();
            ArrayList<Conta> lista = contaController.getContas();

            JSONObject jConta;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;

            for (Conta conta : lista) {
                if (controle) {
                    retorno.append(" , ");
                }
                jConta = new JSONObject();
                jConta.put("idConta", conta.getIdConta());
                jConta.put("descricao", conta.getDescricao());
                jConta.put("tipoConta", conta.getTipoConta());
                jConta.put("valor", conta.getValor());
                retorno.append(jConta.toString());;
                controle = true;
            }

            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            return Response.status(200).entity("{erro : \"" + ex + "\"}").build();
        }
    }

    @POST
    @Path("/setconta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setConta(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
            }

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());

            Conta conta = new Conta();
            //conta.setIdConta(resposta.getInt("idConta"));
            conta.setDescricao(resposta.getString("descricao"));
            conta.setTipoConta(resposta.getString("tipoConta"));
            conta.setValor(resposta.getDouble("valor"));

            if (new ContaController().insereConta(conta)) {
                return Response.status(200).entity("{\"result\" : \"Cadastrado com Sucesso\"}").build();
            } else {
                return Response.status(501).entity("{\"result\" : \"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
}
