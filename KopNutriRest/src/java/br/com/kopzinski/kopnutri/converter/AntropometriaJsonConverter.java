/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopzinski.kopnutri.converter;

import br.com.kopzinski.kopnutri.entities.Antropometria;
import br.com.kopzinski.kopnutri.entities.Atleta;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author kopzinski
 */
public class AntropometriaJsonConverter {
 
    public static JSONObject toJson(Antropometria obj) {
        JSONObject json = new JSONObject();
        json.put("id",obj.getId());
        json.put("peso",obj.getPeso());
        return json;
    }
    
    public static Antropometria toObject(JSONObject json) throws ParseException {
        Antropometria obj = new Antropometria();
        obj.setId(json.getInt("id"));
        obj.setPeso(json.getBigDecimal("peso"));
        return obj;
    }
}
