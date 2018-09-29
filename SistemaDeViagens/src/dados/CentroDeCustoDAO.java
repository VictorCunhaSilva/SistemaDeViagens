package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.CentroDeCusto;

public class CentroDeCustoDAO implements InCentroDeCustoDAO {

	Connection conexao;
	
	public CentroDeCustoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(CentroDeCusto _objeto) throws SQLException {
		
		String SQL = "insert into centroDeCusto (id,nome,valorAlocado,valorRestante) values (?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setDouble(3, _objeto.getValorAlocado());
		ps.setDouble(4, _objeto.getValorRestante());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CentroDeCusto> listarTodos() throws SQLException {
		
		List<CentroDeCusto> centrosDeCustos = new ArrayList<CentroDeCusto>();
		ResultSet rs = null;
		
		String SQL = "select id,nome,valorAlocado,valorRestante from centroDeCusto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			CentroDeCusto p = new CentroDeCusto();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setValorAlocado(rs.getDouble(3));
			p.setValorRestante(rs.getDouble(4));
			
			
			centrosDeCustos.add(p);
		}
		
		return centrosDeCustos;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {

		String SQL = "delete from centroDeCusto where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Boolean Atualizar(CentroDeCusto _objeto) throws SQLException {
		String SQL = "update centroDeCusto set nome=?,valorAlocado=?,valorRestante=? where id=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(5, _objeto.getId());
		ps.setString(1, _objeto.getNome());
		ps.setDouble(2, _objeto.getValorAlocado());
		ps.setDouble(3, _objeto.getValorRestante());
		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public CentroDeCusto buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select id,nome,valorAlocado,valorRestante from centroDeCusto where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		CentroDeCusto p = null;
		if (rs.next()) {
			
			p = new CentroDeCusto();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setValorAlocado(rs.getDouble(3));
			p.setValorRestante(rs.getDouble(4));
			
		}
		
		return p;
	}

}
