package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Contato;
import classes.Email;
import classes.TipoContato;
import classes.TipoEmail;

public class EmailDao {
	public String salvar(Email email) throws Exception {

		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(email);
			em.getTransaction().commit();
			em.close();

			retorno = "EMAIL SALVO";

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
		return retorno;
	}

	public String deletar(Email email) throws Exception {

		String resultado = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			Email emailDelete = em.find(Email.class, email.getId());
			em.getTransaction().begin();
			em.remove(emailDelete);
			em.getTransaction().commit();
			em.close();

			resultado = "email deletado com sucesso";

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Email> listar() {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();

		Query consulta = em.createQuery("from Email email");
		List<Email> email = consulta.getResultList();

		em.getTransaction().commit();
		em.close();

		return email;

	}

	public String alterar(Email email) throws Exception {
		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(email);
			em.getTransaction().commit();
			em.close();

			retorno = "email alterado com sucesso";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("erro ao alterar email" + e.getMessage());
		}
		return retorno;

	}

	public Email obterPorId(int id) {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Email email = em.find(Email.class, id);
		em.getTransaction().commit();
		em.close();

		return email;
	}


}
