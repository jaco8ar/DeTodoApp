package main.java.classes;




import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory; 
    
    private static SessionFactory buildSessionFactory(TargetEnvironment environment) {
    	String url = environment.environmentLabel;
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
            configuration.setProperty("hibernate.connection.url", url);
            configuration.setProperty("hibernate.connection.username", "sa");
            configuration.setProperty("hibernate.connection.password", "");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new RuntimeException("Error building SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory(TargetEnvironment environment) {
    	if (sessionFactory == null) {
    		sessionFactory = buildSessionFactory(environment);
    	}
        return sessionFactory;
    }
}
