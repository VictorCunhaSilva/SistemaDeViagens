package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.PassagemAerea;

public class PassagemAereaDAO implements InPassagemAereaDAO {

	Connection conexao;
	
	public PassagemAereaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(PassagemAerea _objeto) throws SQLException {
		
		String SQL = "insert into passagemAerea (numero,idViagem,cpfComprador,horario,data) values (?,?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getNumero());
		ps.setInt(2, _objeto.getIdViagem());
		ps.setInt(3, _objeto.getCpfComprador());
		ps.setInt(4, _objeto.getHorario());
		ps.setInt(5, _objeto.getData());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PassagemAerea> listarTodos() throws SQLException {
		
		List<PassagemAerea> passagensAereas = new ArrayList<PassagemAerea>();
		ResultSet rs = null;
		
		String SQL = "select numero,idViagem,cpfComprador,horario,data from passagemAerea";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			PassagemAerea p = new PassagemAerea();
			
			p.setNumero(rs.getInt(1));
			p.setIdViagem(rs.getInt(2));
			p.setCpfComprador(rs.getInt(3));
			p.setHorario(rs.getInt(4));
			p.setData(rs.getInt(5));
			
			passagensAereas.add(p);
		}
		
		return passagensAereas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {

		String SQL = "delete from passagemAerea where numero = ?";
		
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
	public Boolean Atualizar(PassagemAerea _objeto) throws SQLException {
		String SQL = "update passagemAerea set idViagem=?,cpfComprador=?,horario=?,data=? where numero=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(5, _objeto.getNumero());
		ps.setInt(1, _objeto.getIdViagem());
		ps.setInt(2, _objeto.getCpfComprador());
		ps.setInt(3, _objeto.getHorario());
		ps.setInt(4, _objeto.getData());
		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public PassagemAerea buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select numero, idViagem,cpfComprador,horario,data where numero = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PassagemAerea p = null;
		if (rs.next()) {
			
			p = new PassagemAerea();
			
			p.setNumero(rs.getInt(1));
			p.setIdViagem(rs.getInt(2));
			p.setCpfComprador(rs.getInt(3));
			p.setHorario(rs.getInt(4));
			p.setData(rs.getInt(5));
		}
		
		return p;
	}

}
