package com.ws.metier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;

import com.ws.DaoImp.DaoImpAuth;
import com.ws.model.AffectationId;
import com.ws.model.CommissionInventaire;
import com.ws.model.Immobilisation;

public class MetierAuth {
	DaoImpAuth daoUser = new DaoImpAuth();

	public void setDaoUser(DaoImpAuth daoUser) {
		this.daoUser = daoUser;
	}
	
	public String getUser(int id){
		CommissionInventaire user = daoUser.getByIdcom(id);
		if(user != null)
			return user.getLogin();
		return "user n'existe pas";
		
	}
	 public CommissionInventaire findByLoginAndPass(String login,String pass){
		 List<CommissionInventaire> lcom = daoUser.getAllcom();
		 CommissionInventaire user=null;
		 for(CommissionInventaire auth: lcom){
			 if((auth.getLogin().equals(login))&&(auth.getPassword().equals(pass)))
			 user=auth;
		 }
		return user;
		 
	 }
}
