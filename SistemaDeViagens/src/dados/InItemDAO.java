package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.Item;

public interface InItemDAO {

	void Inserir(Item _objeto) throws SQLException;
	
	List<Item> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id, int _idPrest) throws SQLException;
	
	Boolean Atualizar(Item _objeto) throws SQLException;
	
	Item buscarPorId(int _id, int _idPrest) throws SQLException;
}