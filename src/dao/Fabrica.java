package dao;

import javax.persistence.*;

public class Fabrica {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho");
	
	// getConnection
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}