package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;

public interface InUsuarioDAO {

	void Inserir(Usuario _objeto) throws SQLException;
	
	List<Usuario> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Usuario _objeto) throws SQLException;
	
	Usuario buscarPorId(int _id) throws SQLException;
}