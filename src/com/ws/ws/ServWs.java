package com.ws.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.ws.metier.MetierServ;
import com.ws.model.Service;

@Path("/serv")
public class ServWs {
MetierServ metier = new MetierServ();
	
    @GET 
    @Path("/getserv")
    @Produces(MediaType.APPLICATION_JSON)  
    public String doLogin() {        
		String response = "";
			try {
				List<Service> liste = metier.getAllServ();
				if(liste!=null && liste.size() != 0 ){
					String chaine = "";
					for(int i = 0 ; i < liste.size(); i++){
						String ligne = liste.get(i).getIdService()+ "," + liste.get(i).getService() + ";";
						chaine = chaine + ligne;
					}

					response = constructJSON("immo",true,chaine);	
				}else{
					response = constructJSON("immo",false,"aucune service");
				}							
			} catch (Exception e) { 
				e.printStackTrace();
			}
		    
		
		  
    return response;        
    }
    
    
    
    public String constructJSON(String tag, boolean status, String liste) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("liste", liste);	
		} catch (JSONException e) {}
		return obj.toString();
	}
 
}
