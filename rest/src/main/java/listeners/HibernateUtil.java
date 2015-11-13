package listeners;

import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
			Configuration configuration = new Configuration();
			Reflections reflections = new Reflections("com.food.parking.entity");
			Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Entity.class);

			for(Class<?> c : annotated){
				//annotationConfiguration.addAnnotatedClass(c);
				configuration.addAnnotatedClass(c);
			}
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}