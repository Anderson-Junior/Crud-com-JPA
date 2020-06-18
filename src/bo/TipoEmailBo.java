package bo;

import java.sql.SQLException;
import java.util.List;

import classes.Contato;
import classes.TipoContato;
import classes.TipoEmail;
import dao.ContatoDao;
import dao.TipoContatoDao;
import dao.TipoEmailDao;

public class TipoEmailBo {
	public String salvar(TipoEmail tipoEmail) throws Exception {

		VerificarDadosTipoEmail(tipoEmail);
		TipoEmailDao dao = new TipoEmailDao();
		try {

			return dao.salvar(tipoEmail);// chama a dao para gravar apos verificar

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public String alterar(TipoEmail tipoEmail) throws Exception {
		VerificarDadosTipoEmail(tipoEmail);
		TipoEmailDao dao = new TipoEmailDao();
		try {
			return dao.alterar(tipoEmail);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<TipoEmail> listar() throws Exception {

		try {
			return new TipoEmailDao().listar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(TipoEmail tipoEmail) throws Exception {
		try {
			return new TipoEmailDao().deletar(tipoEmail);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void VerificarDadosTipoEmail(TipoEmail tipoEmail) throws Exception {

		if (tipoEmail.getId() < 0) {
			throw new Exception("ID NAO PODE SER NUMERO NEGATIVO");
		}
		if (tipoEmail.getNome().equals("")) {
			throw new Exception("NOME NAO PODE FICAR EM BRANCO");
		}
	}
}
