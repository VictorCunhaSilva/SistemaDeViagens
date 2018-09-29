package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.Viagem;

public interface InViagemDAO {

	void Inserir(Viagem _objeto) throws SQLException;
	
	List<Viagem> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Viagem _objeto) throws SQLException;
	
	Viagem buscarPorId(int _id) throws SQLException;
}