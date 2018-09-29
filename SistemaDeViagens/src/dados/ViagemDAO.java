package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Viagem;

public class ViagemDAO implements InViagemDAO {

	Connection conexao;
	
	public ViagemDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Viagem _objeto) throws SQLException {
		
		String SQL = "insert into viagem (id,destino,origem,horario,maxVagas,vagas,preco) values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getDestino());
		ps.setString(3, _objeto.getOrigem());
		ps.setInt(4, _objeto.getHorario());
		ps.setInt(5, _objeto.getMaxVagas());
		ps.setInt(6, _objeto.getVagas());
		ps.setDouble(7, _objeto.getPreco());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Viagem> listarTodos() throws SQLException {
		
		List<Viagem> viagens = new ArrayList<Viagem>();
		ResultSet rs = null;
		
		String SQL = "select id,destino,origem,horario,maxVagas,vagas,preco from viagem";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			Viagem p = new Viagem();
			
			p.setId(rs.getInt(1));
			p.setDestino(rs.getString(2));
			p.setOrigem(rs.getString(3));
			p.setHorario(rs.getInt(4));
			p.setMaxVagas(rs.getInt(5));
			p.setVagas(rs.getInt(6));
			p.setPreco(rs.getDouble(7));
			
			viagens.add(p);
		}
		
		return viagens;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {

		String SQL = "delete from viagem where id = ?";
		
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
	public Boolean Atualizar(Viagem _objeto) throws SQLException {
		String SQL = "update viagem set destino=?,origem=?,horario=?,maxVagas=?,vagas=?,preco=? where id=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(7, _objeto.getId());
		ps.setString(1, _objeto.getDestino());
		ps.setString(2, _objeto.getOrigem());
		ps.setInt(3, _objeto.getHorario());
		ps.setInt(4, _objeto.getMaxVagas());
		ps.setInt(5, _objeto.getVagas());
		ps.setDouble(6, _objeto.getPreco());
		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public Viagem buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select id, destino,origem,horario,maxVagas,vagas,preco from viagem where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Viagem p = null;
		if (rs.next()) {
			
			p = new Viagem();
			
			p.setId(rs.getInt(1));
			p.setDestino(rs.getString(2));
			p.setOrigem(rs.getString(3));
			p.setHorario(rs.getInt(4));
			p.setMaxVagas(rs.getInt(5));
			p.setVagas(rs.getInt(6));
			p.setPreco(rs.getDouble(7));
		}
		
		return p;
	}

}
