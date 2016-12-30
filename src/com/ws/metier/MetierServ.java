package com.ws.metier;


import java.util.List;

import com.ws.DaoImp.DaoImpServ;
import com.ws.model.Service;

public class MetierServ {
	DaoImpServ daoUser = new DaoImpServ();
	
	
	public List<Service> getAllServ(){
		List<Service> listeImmob = null;
		try{
		listeImmob = daoUser.getAllServ();
		}catch(Exception e){
			e.printStackTrace();
		}
		return listeImmob;

	}
}
