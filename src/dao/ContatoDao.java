package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Contato;

public class ContatoDao {

	public String salvar(Contato contato) throws Exception {

		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(contato);
			em.getTransaction().commit();
			em.close();

			retorno = "CONTATO SALVO";

		} catch (Exception e) {
			throw new Exception("erro");

		}
		return retorno;
	}

	public String deletar(Contato contato) throws Exception {

		String resultado = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			Contato contatoDelete = em.find(Contato.class, contato.getId());
			em.getTransaction().begin();
			em.remove(contatoDelete);
			em.getTransaction().commit();
			em.close();

			resultado = "contato deletado com sucesso";

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Contato> listar( String nome, String pesquisa, String dataInicial, String dataFinal) {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Query consulta = null;
		String cWhere;
		
		
		if(nome.equals("")) {
			consulta = em.createQuery("select c from Contato c");
		}
		if(pesquisa.equals("consultar")) {
			consulta = em.createQuery("select c from Contato c where data between " + "" + dataInicial + "" + "and" + "" +"dataFinal" + 
										"" + "c.nome = :nome");
			consulta.setParameter("dataIncial", dataInicial);
			consulta.setParameter("dataFinal", dataFinal);
			consulta.setParameter("nome", nome.toUpperCase());
			
		}
		else {
			consulta = em.createQuery("select c from Contato c where nome like :nome");
			consulta.setParameter("nome", "%"+nome.toUpperCase()+"%");
		}
		/*
		if(pesquisa.equals("consultar")) {
			consulta = em.createQuery("select c from Contato c where data between "+ "'"+dataInicial+"'"+ " and "+ "'"+dataFinal+"' "+
					"and c.valor >= :inicio and c.valor <= :fim and c.nome = :nome");
					consulta.setParameter("inicio", inicio);
					consulta.setParameter("fim", fim);
					consulta.setParameter("nome", nome);
		}
		else {
			consulta = em.createQuery("select c from Contato c");
		}
		
		*/
		List<Contato> lista = consulta.getResultList();

		em.getTransaction().commit();
		em.close();

		return lista;

	}

	public String alterar(Contato contato) throws Exception {
		String retorno = null;

		try {

			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(contato);
			em.getTransaction().commit();
			em.close();

			retorno = "contato alterado com sucesso";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("erro ao alterar contato" + e.getMessage());
		}
		return retorno;

	}


	
	public Contato obterPorId(int id) {

		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Contato contato = em.find(Contato.class, id);
		em.getTransaction().commit();
		em.close();

		return contato;
	}

}
