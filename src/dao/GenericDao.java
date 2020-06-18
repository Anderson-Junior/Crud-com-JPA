package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.EntityBase;

public class GenericDao<T extends EntityBase>{
private static EntityManager em = Fabrica.getEntityManager();
	
	public void saveOrUpdate(T obj) throws Exception{
		try {
			em.getTransaction().begin();
			if(obj.getId() == 0) {
				em.persist(obj);
			}
			else {
				em.merge(obj);			
			}
			em.getTransaction().commit();
		}
		catch(Exception e) {
			throw new Exception("ERRO GRAVANDO \n" +e.getMessage());
		}
	}
	
	public void remove(Class<T> classe, int id) throws Exception{
		
		T t = findById(classe, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().getRollbackOnly();
			throw new Exception("ERRO DELETANTO \n" + e.getMessage());
		}
		
	}
	
	public T findById(Class<T> classe, int id) {
		return em.find(classe, id);
	}
	
	public List<T> list(Class<T> classe){
		
		Query q = em.createQuery("from " + classe.getSimpleName().toString());
		return q.getResultList();
	}
}
