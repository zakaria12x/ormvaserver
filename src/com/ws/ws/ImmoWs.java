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

@Path("/immo")
public class ImmoWs {
	MetierImmo metier = new MetierImmo();
	
    @GET 
    @Path("/getimmo")
    @Produces(MediaType.APPLICATION_JSON)  
    public String getImo(@QueryParam("idbureau") int id_bureau) {        
		String response = "";
			try {
				List<Immobilisation> liste = metier.getByIdBureau(id_bureau);
				if(liste!=null && liste.size() != 0 ){
					String chaine = "";
					String commentaire = "";
					for(int i = 0 ; i < liste.size(); i++){
						if(liste.get(i).getCommentaire() == null){
							commentaire = "vide";
						}else{
							commentaire = liste.get(i).getCommentaire();
						}
						String ligne = liste.get(i).getIdImmobilisation()+ "," + liste.get(i).getDesignation() 
									+ "," + liste.get(i).getCodeABarre()+ "," + liste.get(i).getDateAcquisition()+","
								+ liste.get(i).getDateMiseEnService()+ "," +commentaire+";";
						chaine = chaine + ligne;
					}

					response = constructJSON("immo",true,chaine);	
				}else{
					response = constructJSON("immo",false,"aucune immobilisation");
				}							
			} catch (Exception e) { 
				e.printStackTrace();
			}	  
    return response;        
    }
    
    
    @GET 
    @Path("/commenter")
    @Produces(MediaType.APPLICATION_JSON)  
    public String commenter(@QueryParam("id_immo") int id_immobilisation,@QueryParam("comment") String commentaire) {        
		String response = "";
			try {
				if(metier.modifier(id_immobilisation, commentaire)){
					response = constructJSON("immo",true,"ok");	
				}else{
					response = constructJSON("immo",false,"ko");
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
