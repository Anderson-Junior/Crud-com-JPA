package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Contato;
import classes.TipoEmail;

public class TipoEmailDao {
	public String salvar(TipoEmail tipoEmail) throws Exception {

		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(tipoEmail);
			em.getTransaction().commit();
			em.close();

			retorno = "TIPO EMAIL SALVO";

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
		return retorno;
	}

	public String deletar(TipoEmail tipoEmail) throws Exception {

		String resultado = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			TipoEmail tipoEmailDelete = em.find(TipoEmail.class, tipoEmail.getId());
			em.getTransaction().begin();
			em.remove(tipoEmailDelete);
			em.getTransaction().commit();
			em.close();

			resultado = "tipo email deletado com sucesso";

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<TipoEmail> listar() {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();

		Query consulta = em.createQuery("from TipoEmail tipoEmail");
		List<TipoEmail> tipoEmail = consulta.getResultList();

		em.getTransaction().commit();
		em.close();

		return tipoEmail;

	}

	public String alterar(TipoEmail tipoEmail) throws Exception {
		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(tipoEmail);
			em.getTransaction().commit();
			em.close();

			retorno = "tipo email alterado com sucesso";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("erro ao alterar tipo email" + e.getMessage());
		}
		return retorno;

	}

	public TipoEmail obterPorId(int id) {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		TipoEmail tipoEmail = em.find(TipoEmail.class, id);
		em.getTransaction().commit();
		em.close();

		return tipoEmail;
	}
}
