package bo;

import java.util.List;


import classes.Contato;
import dao.ContatoDao;

public class ContatoBo {

	public String salvar(Contato contato) throws Exception {

		VerificarDadosContato(contato);
		ContatoDao dao = new ContatoDao();
		try {

			return dao.salvar(contato);// chama a dao para gravar apos verificar

		} catch (Exception e) {
			throw new Exception("erro ao salvar contato" + e.getMessage());
		}

	}

	public String alterar(Contato contato) throws Exception {
		VerificarDadosContato(contato);
		ContatoDao dao = new ContatoDao();
		try {
			return dao.alterar(contato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Contato> listar(String nome, String consultar, String dataIncial, String dataFinal) throws Exception {

		try {
			return new ContatoDao().listar(nome,consultar, dataIncial, dataFinal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Contato contato) throws Exception {
		try {
			return new ContatoDao().deletar(contato);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void VerificarDadosContato(Contato contato) throws Exception {

		if (contato.getId() < 0) {
			throw new Exception("ID NAO PODE SER NUMERO NEGATIVO");
		}
		if (contato.getNome().equals("")) {
			throw new Exception("NOME NAO PODE FIcAR EM BRANCO");
		}
		
		
	}
}
