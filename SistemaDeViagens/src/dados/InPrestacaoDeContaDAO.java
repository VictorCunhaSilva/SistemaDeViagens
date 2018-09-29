package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.PrestacaoDeConta;

public interface InPrestacaoDeContaDAO {

	void Inserir(PrestacaoDeConta _objeto) throws SQLException;
	
	List<PrestacaoDeConta> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(PrestacaoDeConta _objeto) throws SQLException;
	
	PrestacaoDeConta buscarPorId(int _id) throws SQLException;
}