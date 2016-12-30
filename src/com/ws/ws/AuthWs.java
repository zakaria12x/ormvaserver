package com.ws.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ws.metier.MetierAuth;
import com.ws.model.CommissionInventaire;

@Path("/login")
public class AuthWs {
	MetierAuth metier = new MetierAuth();
	
	    @GET 
	    @Path("/dologin")
	    @Produces(MediaType.APPLICATION_JSON)  
	    public String doLogin(@QueryParam("login") String login,@QueryParam("pwd") String pwd) {        
			String response = "";
				try {
					CommissionInventaire com = metier.findByLoginAndPass(login,pwd);
					if(com!=null){
						response = constructJSON("login",true,com.getIdCommInventaire());	
					}else{
						response = constructJSON("login",false,-1);
					}
								
				} catch (Exception e) { 
					e.printStackTrace();
				}
			    
			
			  
	    return response;        
	    }
	    
	    
	    
	    public String constructJSON(String tag, boolean status, int id) {
			JSONObject obj = new JSONObject();
			try {
				obj.put("tag", tag);
				obj.put("status", new Boolean(status));
				obj.put("id", id);	
			} catch (JSONException e) {}
			return obj.toString();
		}
	 

}
