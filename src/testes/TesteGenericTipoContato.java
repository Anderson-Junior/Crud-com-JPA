package testes;

import bo.TipoContatoBo;
import classes.TipoContato;
import dao.GenericDao;

public class TesteGenericTipoContato {

	public static void main(String[] args) {
		
		TipoContato tipo = new TipoContato();
		tipo.setNome("PESSOAL");		
		
		GenericDao<TipoContato> contDao = new GenericDao<TipoContato>();
		
		try {
			contDao.saveOrUpdate(tipo);
			System.out.println("tipo contato salvo");
		}
		catch(Exception e) {
			
		}

	}

}
