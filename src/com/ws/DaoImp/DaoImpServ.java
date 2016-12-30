package com.ws.DaoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ws.model.Service;

import DaoInter.IDaoService;

public class DaoImpServ implements IDaoService {
	
	Configuration configuration = new Configuration().configure("com/ws/util/hibernate.cfg.xml");
	SessionFactory sessionfactory = configuration.buildSessionFactory();

	@Override
	public List<Service> getAllServ() {
		List<Service> listeServ = null;
	try{
		Session session1 = sessionfactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		String req1 = "from Service";
		listeServ = session1.createQuery(req1).list();
		tx1.commit();
		session1.close();
	 	}
        catch (HibernateException he)
        {		        	
    		he.printStackTrace();
        }
		return listeServ;
		}
	
	}