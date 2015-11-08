package br.com.kopzinski.kopnutri.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */

@Stateless
@Path("/ws")
@Produces("application/json")
public class HelloWorldResource {

//    @EJB
//    private NameStorageBean nameStorage;
    
    @GET
    @Path("/teste")
    public String opTest() {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }

///atletas/{id}/antropometrias
//GET - lista todas as antropometrias de um atleta
    @GET    
    @Path("/atletas/{id}/antropometrias")
    public String listaAntropometriasDoAtleta(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }    
//POST - adiciona uma antropometria para o atleta
    @POST
    @Path("/atletas/{id}/antropometrias")
    public String adicionaAntropometriaParaAtleta(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//DELETE - exclui todas as antropometrias do atleta
    @DELETE
    @Path("/atletas/{id}/antropometrias")
    public String excluiAntropometriaDoAtleta(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//
//
///atletas
//GET - lista todos atletas
    @GET
    @Path("/atletas")
    public String listaAtletas() {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//POST - insere um atleta novo
    @POST
    @Path("/atletas")
    public String insereAtleta() {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//
///atletas/{id}
//GET - obtem detalhes do atleta
    @GET
    @Path("/atletas/{id}")
    public String obtemDadosDoAtleta(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//PUT - atualiza os dados do atleta
    @PUT
    @Path("/atletas/{id}")
    public String atualizaDadosDoAtlata(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//DELETE - exclui um atleta
    @DELETE
    @Path("/atletas/{id}")
    public String excluiAtleta(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//
///antropometrias
//GET - lista todas as antropometrias
    @GET
    @Path("/antropometrias")
    public String listaAntropometrias() {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//POST - adiciona nova antropometria
    @POST
    @Path("/antropometrias")
    public String insereAntropometria() {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//
///antropometrias/{id}
//GET - obtem detalhes da antropometria
    @GET
    @Path("/antropometrias/{id}")
    public String obtemDadosDaAntropometria(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
//PUT - atualizar uma antropometria
    @PUT
    @Path("/antropometrias/{id}")
    public String atualizaDadosDaAntropometria(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }

//DELETE - excluir um registro de antropometria    
    @DELETE
    @Path("/antropometrias/{id}")
    public String excluiAntropometria(@PathParam("id") String id) {
        JSONObject ob = new JSONObject();
        ob.put("teste", "teste");
        return ob.toString();
    }
    
}
