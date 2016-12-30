package com.ws.DaoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ws.model.Bureau;

import DaoInter.IDaoBureau;

public class DaoImpBur implements IDaoBureau {
	Configuration configuration = new Configuration().configure("com/ws/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();

	@Override
	public List<Bureau> getAllbureauByIdService(int idService) {
		List<Bureau> liste = null;
		try{
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();;
			String req2 = "select b from Bureau as b where b.service.idService='"+idService+"'";
			liste = session.createQuery(req2).list();
			tx.commit();
			session.close();	
		}
		catch (HibernateException he)
        {	
			
    		he.printStackTrace();
        }
		return liste;
		
	}
	}
