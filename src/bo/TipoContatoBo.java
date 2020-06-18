package bo;

import java.sql.SQLException;
import java.util.List;

import classes.Contato;
import classes.TipoContato;
import dao.ContatoDao;
import dao.EmailDao;
import dao.TipoContatoDao;

public class TipoContatoBo {
	
	public String salvar(TipoContato tipoContato) throws Exception {

		VerificarDadosTipoContato(tipoContato);
		TipoContatoDao dao = new TipoContatoDao();
		try {

			return dao.salvar(tipoContato);// chama a dao para gravar apos verificar

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public String alterar(TipoContato TipoContato) throws Exception {
		VerificarDadosTipoContato(TipoContato);
		TipoContatoDao dao = new TipoContatoDao();
		try {
			return dao.alterar(TipoContato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<TipoContato> listar() throws Exception {

		try {
			return new TipoContatoDao().listar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(TipoContato tipoContato) throws Exception {
		try {
			return new TipoContatoDao().deletar(tipoContato);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void VerificarDadosTipoContato(TipoContato tipoContato) throws Exception {

		if (tipoContato.getId() < 0) {
			throw new Exception("ID NAO PODE SER NUMERO NEGATIVO");
		}
		if (tipoContato.getNome().equals("")) {
			throw new Exception("NOME TIPO CONTATO NAO PODE FICAR EM BRANCO");
		}
	}
}
