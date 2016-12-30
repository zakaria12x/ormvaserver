package com.ws.metier;

import java.util.List;

import com.ws.DaoImp.DaoImpImmo;
import com.ws.model.Immobilisation;

public class MetierImmo {
	DaoImpImmo DaoImmo = new DaoImpImmo();
	
	public List<Immobilisation> getByIdBureau(int idBureau){
		List<Immobilisation> listeImmob = null;
		try{
			listeImmob = DaoImmo.getByIdBureau(idBureau);
			}catch(Exception e){
				e.printStackTrace();
			}
			return listeImmob;

		}
	
	public Immobilisation getbyBCode(String code){
		Immobilisation immob1 = new Immobilisation();
		try{
			immob1 = DaoImmo.getbyBCode(code);
			}catch(Exception e){
				e.printStackTrace();
			}
			return immob1;
		}
	
	public boolean modifier(int id, String commentaire){
		boolean ok = false;
		Immobilisation oldImmob =  DaoImmo.getById(id);
		if(oldImmob != null){
			oldImmob.setCommentaire(commentaire);
			ok = true;
			try{
				DaoImmo.modifier(oldImmob);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return ok;
	}
}
