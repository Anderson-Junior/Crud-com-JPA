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

public class TipoContatoDao {
	public String salvar(TipoContato tipoContato) throws Exception {

		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(tipoContato);
			em.getTransaction().commit();
			em.close();

			retorno = "TIPO CONTATO SALVO";

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
		return retorno;
	}

	public String deletar(TipoContato tipoContato) throws Exception {

		String resultado;

		EntityManager em = Fabrica.getEntityManager();
		try {

			TipoContato tipoDelete = em.find(TipoContato.class, tipoContato.getId());
			em.getTransaction().begin();
			em.remove(tipoDelete);
			em.getTransaction().commit();
			

			resultado = "tipo contato deletado com sucesso";

		} catch (Exception e) {
			resultado = e.getMessage();
			System.out.println("ERRO AO DELETAR TIPO CONTATO" + e.getMessage());
		}
		finally {
			em.close();
		}
		return resultado;
	}


	@SuppressWarnings("unchecked")
	public List<TipoContato> listar() {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();

		Query consulta = em.createQuery("from TipoContato tipocontato");
		List<TipoContato> tipocontato = consulta.getResultList();

		em.getTransaction().commit();
		em.close();

		return tipocontato;

	}

	public String alterar(TipoContato tipoContato) throws Exception {
		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(tipoContato);
			em.getTransaction().commit();
			em.close();

			retorno = "tipo contato alterado com sucesso";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("erro ao alterar tipo contato" + e.getMessage());
		}
		return retorno;

	}
	public TipoContato obterPorId(int id) {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		TipoContato tipoContato = em.find(TipoContato.class, id);
		em.getTransaction().commit();
		em.close();

		return tipoContato;
	}
}
