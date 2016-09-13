/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
