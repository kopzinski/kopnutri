package br.com.kopzinski.kopnutri.rest;

import br.com.kopzinski.kopnutri.controller.AntropometriaController;
import br.com.kopzinski.kopnutri.controller.AtletaController;
import br.com.kopzinski.kopnutri.converter.AntropometriaJsonConverter;
import br.com.kopzinski.kopnutri.entities.Antropometria;
import br.com.kopzinski.kopnutri.entities.Atleta;
import br.com.kopzinski.kopnutri.service.AntropometriaService;
import helloworld.NameStorageBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import org.json.JSONArray;
import org.json.JSONObject;

@Stateless
@Path("/ws")
@Produces("application/json")
public class KopNutriRestResource {

    private final AtletaController atletaController = new AtletaController();
    private final AntropometriaController antropometriaController = new AntropometriaController();
    private final AntropometriaService antropometriaService = new AntropometriaService();
    
///atletas/{id}/antropometrias
//GET - lista todas as antropometrias de um atleta
    @GET    
    @Path("/atletas/{id}/antropometrias")
    public String listaAntropometriasDoAtleta(@PathParam("id") String id) {
        List<Antropometria> antropometrias = antropometriaService.findAllByIdAtleta(Integer.parseInt(id));
        JSONObject novoOb = new JSONObject();
        novoOb.put("antropometrias", new JSONArray(antropometrias));
        return novoOb.toString();
    }    
//POST - adiciona uma antropometria para o atleta
    @POST
    @Path("/atletas/{id}/antropometrias")
    public String adicionaAntropometriaParaAtleta(@PathParam("id") String id, String contexto) {
        JSONObject ob = new JSONObject();
        Atleta atleta = atletaController.getObjetoService().findById(id);
        if(atleta == null) 
            return retornaErro("Atleta nao encontrado");
        
        JSONObject req = new JSONObject(contexto);
        JSONObject reqAnt = req.getJSONObject("Antropometria");
        
        Antropometria a = new Antropometria();
        a.setAtleta(atleta);
        a.setData(new Date());
        a.setPeso(reqAnt.getBigDecimal("peso"));
        
        antropometriaService.persist(a);
        
        ob.put("Antropometria", AntropometriaJsonConverter.toJson(a));
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
        List<Atleta> atletas = atletaController.getObjetos();
        ob.put("atletas", atletas);
//        for (Atleta atleta : atletas) {
//            ob.put(String.valueOf(atleta.getId()),atleta.getNome());
//        }
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
        List<Antropometria> antropometrias = antropometriaController.getObjetos();
        ob.put("aaa", antropometrias);
        for (Antropometria antropometria : antropometrias) {
//            ob.put(String.valueOf(antropometria.getId()), antropometria.getData());
            
        }
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
    public String atualizaDadosDaAntropometria(@PathParam("id") String id, String conteudo) {
        System.out.println("Kop! conteudo:"+conteudo);
        JSONObject ob = new JSONObject();
        ob.put("id", id);
//        ob.put("nome", conteudo);
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

    private String retornaErro(String msg) {
        JSONObject ob = new JSONObject();
        ob.put("ERRO", msg);
        return ob.toString();
    }
    
}
