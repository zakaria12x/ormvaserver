package com.ws.DaoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ws.model.CommissionInventaire;

import DaoInter.IDaoAuth;

public class DaoImpAuth implements IDaoAuth{
	
	Configuration configuration = new Configuration().configure("com/ws/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();

	

	@Override
	public List<CommissionInventaire> getAllcom() {
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();				
			List<CommissionInventaire> listeCommissionInventaire = session.createQuery("from CommissionInventaire").list();					
			tx.commit();	
			session.close();
			return listeCommissionInventaire;							
		 	}
	        catch (HibernateException he)
	        {		        	
	        	return null;
	        }
	}

	@Override
	public CommissionInventaire getByIdcom(int id) {
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();				
			CommissionInventaire com = (CommissionInventaire)session.get("com.ws.model.CommissionInventaire", id);
			tx.commit();
			session.close();
			return com;							
		 	}
	        catch (HibernateException he)
	        {		        	
	        	return null;
	        }
	}

}