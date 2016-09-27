/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("/usuario")
public class UsuarioWs {

    @GET
    @Path("/getusuario")
    @Produces("application/json")
    public Response getUsuario() {
        try {
            JSONObject retorno = new JSONObject();
            retorno.put("nome", "Jonas Pereira");
            retorno.put("idade", 22);
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(500).build();
    }

    @GET
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getAllUsuarios() {
        try {
            UsuarioController usuarioController;
            usuarioController = new UsuarioController();
            ArrayList<Usuario> lista = usuarioController.getUsuarios();

            JSONObject jUsuario;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;

            for (Usuario usuario : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jUsuario = new JSONObject();
                jUsuario.put("idUsuario", usuario.getIdUsuario());
                jUsuario.put("idGrupo", usuario.getIdGrupo());
                jUsuario.put("login", usuario.getLogin());
                jUsuario.put("senha", usuario.getSenha());
                jUsuario.put("nome", usuario.getNome());
                jUsuario.put("dtAlteracao", usuario.getDtAlteracao());
                jUsuario.put("flagInativo", usuario.getFlagInativo());
                retorno.append(jUsuario.toString());;
                controle = true;
            }
            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            return Response.status(200).entity("{erro : \"" + ex + "\"}").build();
        }
    }

    @POST
    @Path("/setusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setUsuario(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
            }
            //System.out.println(requisicaoFinal.toString());
            JSONObject resposta = new JSONObject(requisicaoFinal.toString());

            Usuario usuario = new Usuario();
            //usuario.setIdUsuario(resposta.getInt("idUsuario"));
            usuario.setIdGrupo(resposta.getInt("idGrupo"));
            usuario.setLogin(resposta.getString("login"));
            usuario.setSenha(resposta.getString("senha"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setDtAlteracao(new Date());
            usuario.setFlagInativo(resposta.getString("flagInativo").toCharArray()[0]);

            if (new UsuarioController().insereCadastro(usuario)) {
                Response.status(200).entity("{\"result\" : \"Cadastrado com Sucesso\"}").build();
            } else {
                Response.status(200).entity("{\"result\" : \"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }
        return null;
    }

}
