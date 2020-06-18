package testes;

import java.sql.SQLException;
import java.util.List;

import bo.ContatoBo;
import bo.TipoContatoBo;
import classes.Contato;
import classes.TipoContato;
import dao.ContatoDao;
import dao.TipoContatoDao;

public class TesteTipoContato {

	public static void main(String[] args) throws SQLException {
		
		//PARA SALVAR
		TipoContato tipoContato = new TipoContato();
		
		//PARA DELETAR
		TipoContato tipoDelete = new TipoContato();
		
		//PARA ALTERAR
		TipoContato tipoAlterar = new TipoContato();
		
		//PARA LISTAR
		TipoContato tipoListar = new TipoContato();
		
		TipoContatoBo bo = new TipoContatoBo();
	
		
/* -----------------------SALVAR TIPO CONTATO----------------------------------------------*/
		/*
		System.out.println("TESTE 1 - SALVAR TIPO CONTATO");
		tipoContato.setNome("FAMILIAR"); 
		
		try {
			String bao = bo.salvar(tipoContato);
			System.out.println(bao);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		
/*------------------ALTERAR TIPO CONTATO------------------------------------------------------*/
		
		/*
		System.out.println("TESTE DE UPDATE");
		
		tipoAlterar.setNome("TESTANDO");
		tipoAlterar.setId(2);
		try {
			String deuBoa = new TipoContatoBo().alterar(tipoAlterar);
			System.out.println(deuBoa);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		
/*--------------------------------DELETAR TIPO CONTATO----------------------------------*/
		
		/*
		System.out.println("TESTE DELETE");
		
		try {
			tipoDelete.setId(1);
			String deuCerto = new TipoContatoBo().deletar(tipoDelete);
			System.out.println(deuCerto);
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		*/
		
		
/*-----------------------------LISTAR TIPO--------------------------------------------------------*/
		
		
		System.out.println("TESTE 2 - LISTAR TIPO CONTATO");
		
		try {	
			for(TipoContato tipo : new TipoContatoBo().listar()) {
				System.out.println(tipo);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
