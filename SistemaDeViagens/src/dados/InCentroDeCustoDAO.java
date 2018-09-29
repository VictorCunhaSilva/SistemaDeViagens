package dados;

import java.sql.SQLException;
import java.util.List;

import modelo.CentroDeCusto;

public interface InCentroDeCustoDAO {

	void Inserir(CentroDeCusto _objeto) throws SQLException;
	
	List<CentroDeCusto> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(CentroDeCusto _objeto) throws SQLException;
	
	CentroDeCusto buscarPorId(int _id) throws SQLException;
}