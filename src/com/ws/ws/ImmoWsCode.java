package com.ws.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ws.metier.MetierImmo;
import com.ws.model.Immobilisation;

@Path("/immobar")
public class ImmoWsCode {
	MetierImmo metier = new MetierImmo();
	
    @GET 
    @Path("/getimmobar")
    @Produces(MediaType.APPLICATION_JSON)  
    public String getImo(@QueryParam("code") String code ) {        
		String response = "";
		try {
			Immobilisation imob = metier.getbyBCode(code);
			if(imob!=null){
				String chaine = "";
				String commentaire;
				if(imob.getCommentaire() == null){
					commentaire = "vide";
				}else{
					commentaire = imob.getCommentaire();
				}
				chaine = imob.getIdImmobilisation()+ "," + imob.getDesignation() 
								+ "," + imob.getCodeABarre()+ "," 
								+ imob.getDateAcquisition()+","+ imob.getDateMiseEnService()+ "," + commentaire;
				response = constructJSON("immo",true,chaine);	
			}else{
				response = constructJSON("immo",false,"aucune immobilisation");
			}							
		} catch (Exception e) { 
			e.printStackTrace();
		}	  
			return response;  
    	}      
    
    
    
    public String constructJSON(String tag, boolean status, String des) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("immobilisation", des);	
		} catch (JSONException e) {}
		return obj.toString();
	}
 

}
