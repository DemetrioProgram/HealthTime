package br.com.healthtime.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.healthtime.entity.Endereco;
import br.com.healthtime.entity.Usuario;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration config = new Configuration();
            config.configure();
            
            config.addAnnotatedClass(Usuario.class);
            config.addAnnotatedClass(Endereco.class);
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            
            return sessionFactory;
            
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
