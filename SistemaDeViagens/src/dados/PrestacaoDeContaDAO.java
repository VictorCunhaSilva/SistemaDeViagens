package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.PrestacaoDeConta;

public class PrestacaoDeContaDAO implements InPrestacaoDeContaDAO {

	Connection conexao;
	
	public PrestacaoDeContaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(PrestacaoDeConta _objeto) throws SQLException {
		
		String SQL = "insert into prestacaoDeConta (idViagem,idUsuario,idPrestacao) values (?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getIdViagem());
		ps.setInt(2, _objeto.getIdUsuario());
		ps.setInt(3, _objeto.getIdPrestacao());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PrestacaoDeConta> listarTodos() throws SQLException {
		
		List<PrestacaoDeConta> prestacoesDeContas = new ArrayList<PrestacaoDeConta>();
		ResultSet rs = null;
		
		String SQL = "select idViagem,idUsuario,idPrestacao from prestacaoDeConta";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			PrestacaoDeConta p = new PrestacaoDeConta();
			
			p.setIdViagem(rs.getInt(1));
			p.setIdUsuario(rs.getInt(2));
			p.setIdPrestacao(rs.getInt(3));
			
			prestacoesDeContas.add(p);
		}
		
		return prestacoesDeContas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {

		String SQL = "delete from prestacaoDeConta where idPrestacao = ?";
		
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
	public Boolean Atualizar(PrestacaoDeConta _objeto) throws SQLException {
		String SQL = "update prestacaoDeConta set idViagem=?,idUsuario=? where idPrestacao=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getIdViagem());
		ps.setInt(2, _objeto.getIdUsuario());
		ps.setInt(3, _objeto.getIdPrestacao());
		

		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public PrestacaoDeConta buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select idViagem,idUsuario,idPrestacao from prestacaoDeConta where idPrestacao = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PrestacaoDeConta p = null;
		if (rs.next()) {
			
			p = new PrestacaoDeConta();
			
			p.setIdViagem(rs.getInt(1));
			p.setIdUsuario(rs.getInt(2));
			p.setIdUsuario(rs.getInt(3));
		}
		
		return p;
	}

}
