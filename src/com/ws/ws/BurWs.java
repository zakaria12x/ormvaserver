package com.ws.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ws.metier.MetierBur;
import com.ws.metier.MetierImmo;
import com.ws.model.Bureau;

@Path("/bur")
public class BurWs {
	MetierBur metier = new MetierBur();
	 @GET 
	    @Path("/getbureaux")
	    @Produces(MediaType.APPLICATION_JSON)
	 public String getBur(@QueryParam("idservice") int id_service) {        
			String response = "";
				try {
					List<Bureau> liste = metier.getAllbureauByIdService(id_service);
					if(liste!=null && liste.size() != 0 ){
						String chaine = "";
						for(int i = 0 ; i < liste.size(); i++){
							String ligne = liste.get(i).getIdBureau()+ ";";
							chaine = chaine + ligne;
						}

						response = constructJSON("immo",true,chaine);	
					}else{
						response = constructJSON("immo",false,"aucune bureau");
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
