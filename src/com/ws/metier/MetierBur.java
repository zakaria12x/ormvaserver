package com.ws.metier;

import java.util.List;

import com.ws.DaoImp.DaoImpBur;
import com.ws.model.Bureau;
import com.ws.model.Service;

public class MetierBur {
	DaoImpBur daoUser = new DaoImpBur();
	
	public List<Bureau> getAllbureauByIdService(int idService){
		List<Bureau> listeBur = null;
		try{
		listeBur = daoUser.getAllbureauByIdService(idService);
		}catch(Exception e){
			e.printStackTrace();
		}
		return listeBur;

	}
}
