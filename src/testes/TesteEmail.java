package testes;

import java.util.List;

import bo.EmailBo;
import classes.Contato;
import classes.Email;
import classes.TipoEmail;

public class TesteEmail {

	public static void main(String[] args) {
		
		Email email = new Email();
		EmailBo bo = new EmailBo();
		TipoEmail tipoE = new TipoEmail();
		Contato contato = new Contato();
		
		
		Email emailAlterar = new Email();
		Email emailDeletar = new Email();
		
/*----------------------------------------SALVAR EMAIL-----------------------------------*/
		
		System.out.println("TESTE SALVAR EMAIL");
		email.setEmail("teste@gmail.com");
		tipoE.setId(2);
		contato.setId(2);
		
		email.setTipo_email(tipoE);
		email.setId_contato(contato); 
	
		
		try {
			String opa = bo.salvar(email);
			System.out.println(opa);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
/*-------------------------------LISTAR EMAIL------------------------------------------------*/
		
		/*
		
		System.out.println("teste listar email");
		
		try {
			
			for(Email e : new EmailBo().listar()) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
/*-------------------------------------------ALTERAR-----------------------------------------------*/
		
		/*
		Contato contat = new Contato();
		contat.setId(1);
		
		TipoEmail tipoee = new TipoEmail();
		tipoee.setId(1);
		
		
		emailAlterar.setEmail("calanguinho@gmail.com");
		emailAlterar.setId(2);
		emailAlterar.setId_contato(contat);
		emailAlterar.setTipo_email(tipoee);
		
		
		try {
			String deuboa = new EmailBo().alterar(emailAlterar);
			System.out.println(deuboa);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	*/
		
/*---------------------------------------------------DELETAR-------------------------------*/
	
		/*
		try {
			emailDeletar.setId(1);
			String deuboa = new EmailBo().deletar(emailDeletar);
			System.out.println(deuboa);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}

}
