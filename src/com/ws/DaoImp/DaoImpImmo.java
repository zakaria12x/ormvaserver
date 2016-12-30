package com.ws.DaoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ws.model.AffectationId;
import com.ws.model.Immobilisation;

import DaoInter.IDaoImmobilisation;

public class DaoImpImmo implements IDaoImmobilisation{
	
	Configuration configuration = new Configuration().configure("com/ws/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();


	@Override
	public Immobilisation getById(int id) {
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();				
			Immobilisation imm = (Immobilisation)session.get("com.ws.model.Immobilisation", id);
			tx.commit();
			session.close();
			return imm;							
		 	}
	        catch (HibernateException he)
	        {		        	
	        	return null;
	        }
	}
	 public void modifier(Immobilisation immobilisation){
		 try{
				Session session = sessionfactory.openSession();
				Transaction tx = session.beginTransaction();
				session.update(immobilisation);
				tx.commit();
				session.close();
										
			 	}
		        catch (HibernateException he)
		        {		        	
		        	he.printStackTrace();
		        }	
	 }
	
	@Override
	public List<Immobilisation> getByIdBureau(int idBureau){
		List<Immobilisation> liste = new ArrayList<Immobilisation> ();
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Immobilisation> listeImmob2 = getAllImmo();
			List<Immobilisation> liste2 = new ArrayList<Immobilisation>();
			for(Immobilisation i : listeImmob2){
				String req2 = "select af.immobilisation from Affectation as af "
						+ "where af.immobilisation.idImmobilisation= '"+i.getIdImmobilisation()+""
						+ "'and af.bureauByIdBureauDestination.idBureau= '"+idBureau+"'"
						+ "and af.id.dateAffectation in (select max(b.id.dateAffectation) from Affectation as b"
						+ " where b.immobilisation.idImmobilisation='"+i.getIdImmobilisation()+"')";
				liste2 = session.createQuery(req2).list();
				if(liste2.size() > 0){
					liste.add(liste2.get(0));
				}
			}
			tx.commit();
			session.close();
		}
		catch (HibernateException he)
        {	
			liste =  null;
    		he.printStackTrace();
        }
		return liste;
	}
	
	@Override
	public List<Immobilisation> getAllImmo() {
		List<Immobilisation> listeImmob1 = null;
		try{
			Session session1 = sessionfactory.openSession();
			Transaction tx1 = session1.beginTransaction();
			String req1 = "select distinct af.immobilisation from Affectation as af ";
			listeImmob1 = session1.createQuery(req1).list();
			tx1.commit();
			session1.close();
		 	}
	        catch (HibernateException he)
	        {		        	
	    		he.printStackTrace();
	        }
			return listeImmob1;
			}


	@Override
	public Immobilisation getbyBCode(String code) {
		Immobilisation immob = new Immobilisation();
		try{
			Session session1 = sessionfactory.openSession();
			Transaction tx1 = session1.beginTransaction();
			String req1 = "select af.immobilisation from Affectation as af "
					+ "where af.immobilisation.codeABarre= '"+code+"'";
			immob = (Immobilisation) session1.createQuery(req1).uniqueResult();
			tx1.commit();
			session1.close();
		 	}
	        catch (HibernateException he)
	        {		        	
	    		he.printStackTrace();
	        }
			return immob;
			}
		
}
