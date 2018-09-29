package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.PassagemAerea;

public interface InPassagemAereaDAO {

	void Inserir(PassagemAerea _objeto) throws SQLException;
	
	List<PassagemAerea> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(PassagemAerea _objeto) throws SQLException;
	
	PassagemAerea buscarPorId(int _id) throws SQLException;
}