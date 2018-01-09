package br.com.guilherme.lemes.core.utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static final Logger log = Logger.getLogger("simova.util");

    public static Session getSession() throws HibernateException {
        return getSessionfactory().openSession();
    }

    public static Statistics getStatistics() {
        return getSessionfactory().getStatistics();
    }

    public static SessionFactory getSessionfactory() {
      /*  if (sessionFactory == null) {
            try {
                // Le o arquivo de configuração do Hibernate
                Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
                sessionFactory = cfg.buildSessionFactory(builder.build());
            } catch (Throwable t) {
                log.error(t.getLocalizedMessage(), t);
                throw new ExceptionInInitializerError(t);
            }
        }*/
        return sessionFactory;
    }

    public static void setSessionfactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }
    /***
     *  Método criado para realizar rollback de uma transcation. Deve
     *  ser usado sempre que for iniciada uma transaction e 
     *  usado sempre dentro de um catch.
     *  
     *  @param se Session atual
     */
    public static void makeRollback(Session se){
    	try{
    		if(se.getTransaction() != null && se.getTransaction().isActive()){
    			se.getTransaction().rollback();
    		}
    	}catch(Exception e){
    		log.error(e.getLocalizedMessage(),e);
    	}
    }
    
    
}