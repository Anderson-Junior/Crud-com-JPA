package testes;


import java.util.List;

import bo.ContatoBo;
import classes.Contato;
import classes.TipoContato;

public class TesteContato {

	public static void main(String[] args) {
		
		ContatoBo bo = new ContatoBo();
		TipoContato tipo = new TipoContato();
		Contato contato = new Contato();
		
		Contato contatoListar = new Contato();
		
		Contato contatoDeletar = new Contato();
		Contato contatoAlterar = new Contato();
	
/*------------------------------SALVAR CONTATO-----------------------------------*/
		
		contato.setNome("teste");
		
		tipo.setId(1);
		
		contato.setTipo(tipo);
		
		try {
			
			String resultado = bo.salvar(contato);
			System.out.println(resultado);
			
		}
		catch(Exception e ) {
			System.out.println(e.getMessage() + "erro");  
		
		}
		
		
		
/*---------------------------------------LISTAR CONTATO------------------------------------------------*/		
	
		/*
		System.out.println("TESTE LISTAR CONTATOS");
		
		try {
			
			for(Contato cont : new ContatoBo().listar()) { 
				
				System.out.println(cont); 
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
/*----------------------------------------ALTERAR CONTATO-------------------------------------------------*/		
		
	/*	
		TipoContato cont = new TipoContato();
		cont.setId(1);
		
		contatoAlterar.setId(1);
		contatoAlterar.setNome("junior");
		contatoAlterar.setTipo(cont);
		
		
		try {
			String boa = new ContatoBo().alterar(contatoAlterar);
			System.out.println(boa);	
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		
		*/
		
		
/*------------------------------------ DELETAR CONTATO-----------------------------------------------------*/	
	/*	
		
		try {
			contatoDeletar.setId(1);
			String bao = new ContatoBo().deletar(contatoDeletar);
			System.out.println(bao);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	} 
}
