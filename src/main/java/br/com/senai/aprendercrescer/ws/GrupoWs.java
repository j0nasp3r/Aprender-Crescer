/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
@Path("/grupo")
public class GrupoWs {

    @GET
    @Path("/getGrupos")
    @Produces("application/json")
    public Response getAllGrupos() {
        try {
            GrupoController grupoController;
            grupoController = new GrupoController();

            ArrayList<Grupo> lista = grupoController.getGrupos();
            JSONObject retorno = new JSONObject();
            JSONObject jGrupo;
            for (int x = 0; x < lista.size(); x++) {
                Grupo grupo = lista.get(x);
                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdGrupo());
                jGrupo.put("tipoUsuario", grupo.getTipoUsuario());
                jGrupo.put("descricaoGrupo", grupo.getDescricao());
                retorno.put("grupos" + grupo.getIdGrupo(), jGrupo.toString());
            }
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            return Response.status(200).entity("{erro : \"" + ex + "\"}").build();
        }
    }

    @POST
    @Path("/setgrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setGrupo(InputStream dadosServ
    ) {
        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
            }

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());

            Grupo grupo = new Grupo();
            //grupo.setIdGrupo(resposta.getInt("idGrupo"));
            grupo.setTipoUsuario(resposta.getString("tipoUsuario").toCharArray()[0]);
            grupo.setDescricao(resposta.getString("descricaoGrupo"));

            new GrupoController().insereGrupo(grupo);

            Response.status(200).entity(requisicaoFinal.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }
        return null;
    }
}
