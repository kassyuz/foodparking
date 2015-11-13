package listeners;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener {


	private EntityManagerFactory entityManagerFactory;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		entityManagerFactory.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce){
		entityManagerFactory = Persistence.createEntityManagerFactory("datasource");
	}
}