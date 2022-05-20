package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Curso;

public class ControladorCurso {
	/**
	 * 
	 */
	private static Curso obtencionDesdeSQL(String sql) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery(sql, Curso.class);
		Curso c = (Curso) q.getSingleResult();

		em.close();
		return c;
	}

	/**
	 * 
	 */
	public static Curso devolverPrimero() {
		return obtencionDesdeSQL("SELECT * FROM curso order by id limit 1");
	}

	/**
	 * 
	 */
	public static Curso devolverUltimo() {
		return obtencionDesdeSQL("SELECT * FROM curso order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Curso devolverSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 */
	public static Curso devolverAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id < " + idActual + " order by id desc limit 1");
	}
}
