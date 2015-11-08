/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopzinski.kopnutri.converter;

import br.com.kopzinski.kopnutri.entities.Atleta;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author kopzinski
 */
public class AtletaJsonConverter {
 
    public static JSONObject toJson(Atleta obj) {
        JSONObject json = new JSONObject();
        json.put("id",obj.getId());
        json.put("nome",obj.getNome());
        json.put("nascimento",obj.getNascimento());
        return json;
    }
    
    public static Atleta toObject(JSONObject json) throws ParseException {
        Atleta obj = new Atleta();
        obj.setId(json.getInt("id"));
        obj.setNome(json.getString("nome"));
        DateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        
        obj.setNascimento(format.parse(json.getString("nascimento")));
        return obj;
    }
}
