package testes;

import java.util.List;

import bo.TipoEmailBo;
import classes.TipoEmail;

public class TesteTipoEmail {

	public static void main(String[] args) {

		TipoEmail tipo = new TipoEmail();
		TipoEmailBo bo = new TipoEmailBo();

		TipoEmail tipoEmailListar = new TipoEmail();

		TipoEmail tipoAlterar = new TipoEmail();
		TipoEmail tipoDeletar = new TipoEmail();

		/*----------------------------------SALVAR TIPO EMAIL-------------------------------------*/

		/*
		 tipo.setNome("COMERCIAL");
		 
		 try { String deu = bo.salvar(tipo); System.out.println(deu); }
		 catch(Exception e ) { System.out.println(e.getMessage()); }
		 
		 */

		/*---------------------------------LISTAR TIPO EMAIL---------------------------------*/

		/*
		 * System.out.println("TESTE LISTAR TIPO EMIAL");
		 * 
		 * try { List<TipoEmail> lista = new TipoEmailBo().listar();
		 * 
		 * for(TipoEmail tipoEmail : lista) { tipoEmailListar = tipoEmail;
		 * System.out.println(tipoEmail); } } catch(Exception e) {
		 * System.out.println(e.getMessage()); }
		 */

		/*-------------------------------ALTERAR TIPO EMAIL----------------------------------------*/

		/*
		 * tipoAlterar.setId(1); tipoAlterar.setNome("PESSOAL");
		 * 
		 * try { String deu = new TipoEmailBo().alterar(tipoAlterar);
		 * System.out.println(deu); } catch(Exception e){
		 * System.out.println(e.getMessage()); }
		 */

		/*------------------------------------DELETEAR TIPO EMAIL-----------------------------*/

		/*
		try {
			
			tipoDeletar.setId(1);
			String deuboa = new TipoEmailBo().deletar(tipoDeletar);
			System.out.println(deuboa);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}

}
