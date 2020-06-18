package bo;

import java.sql.SQLException;
import java.util.List;

import classes.Contato;
import classes.Email;
import dao.ContatoDao;
import dao.EmailDao;

public class EmailBo {
	
	public String salvar(Email email) throws Exception {

		VerificarDadosEmail(email);
		EmailDao dao = new EmailDao();
		try {

			return dao.salvar(email);// chama a dao para gravar apos verificar

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public String alterar(Email email) throws Exception {
		VerificarDadosEmail(email);
		EmailDao dao = new EmailDao();
		try {
			return dao.alterar(email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Email> listar() throws Exception {

		try {
			return new EmailDao().listar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Email email) throws Exception {
		try {
			return new EmailDao().deletar(email);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void VerificarDadosEmail(Email email) throws Exception {

		if (email.getId() < 0) {
			throw new Exception("ID NAO PODE SER NUMERO NEGATIVO");
		}
		if (email.getEmail().equals("")) {
			throw new Exception("EMAIL NAO PODE FICAR EM BRANCO");
		}
	}
}
