package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladorGeneral {
	/**
	 * 
	 */
	protected static EntityManager buscarId() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");
		return entityManagerFactory.createEntityManager();
	}
}
