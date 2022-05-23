package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Curso;

public class ControladorCurso extends ControladorGeneral {
	/**
	 * 
	 */
	private static Curso obtencionDesdeSQL(String sql) {
		EntityManager em = buscarId();
		try {
			Query q = em.createNativeQuery(sql, Curso.class);

			Curso c = (Curso) q.getSingleResult();

			em.close();
			return c;
		} catch (NoResultException e) {
			return null;
		}
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

	/**
	 * 
	 */
	public static boolean creacion(Curso c) {
		EntityManager em = buscarId();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 */
	public static boolean modificacionEntidad(Curso c) {
		EntityManager em = buscarId();
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();

			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 */
	public static boolean eliminacion(Curso c) {
		EntityManager em = buscarId();
		try {
			em.getTransaction().begin();
			if (!em.contains(c)) {
				c = em.merge(c);
			}
			em.remove(c);
			em.getTransaction().commit();

			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
