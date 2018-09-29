package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Item;

public class ItemDAO implements InItemDAO {

	Connection conexao;
	
	public ItemDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Item _objeto) throws SQLException {
		
		String SQL = "insert into item (sequencial,descricao,valor,idPrestacao) values (?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getSequencial());
		ps.setString(2, _objeto.getDescricao());
		ps.setDouble(3, _objeto.getValor());
		ps.setInt(4, _objeto.getIdPrestacao());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item> listarTodos() throws SQLException {
		
		List<Item> itens = new ArrayList<Item>();
		ResultSet rs = null;
		
		String SQL = "select sequencial,descricao,valor,idPrestacao from item";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			Item p = new Item();
			
			p.setSequencial(rs.getInt(1));
			p.setDescricao(rs.getString(2));
			p.setValor(rs.getDouble(3));
			p.setIdPrestacao(rs.getInt(4));
			
			
			itens.add(p);
		}
		
		return itens;
	}

	@Override
	public Boolean Excluir(int _id, int _idPrest) throws SQLException {

		String SQL = "delete from item where sequencial = ? and idPrest = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		ps.setInt(2, _idPrest);
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Boolean Atualizar(Item _objeto) throws SQLException {
		String SQL = "update item set descricao=?,valor=? where sequencial=? and idPrestacao=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(3, _objeto.getSequencial());
		ps.setString(1, _objeto.getDescricao());
		ps.setDouble(2, _objeto.getValor());
		ps.setInt(4, _objeto.getIdPrestacao());
		
		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public Item buscarPorId(int _id, int _idPrest) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select sequencial,descricao,valor,idPrestacao from item where sequencial = ? and idPrestacao = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		ps.setInt(2, _idPrest);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Item p = null;
		if (rs.next()) {
			
			p = new Item();
			
			p.setSequencial(rs.getInt(1));
			p.setDescricao(rs.getString(2));
			p.setValor(rs.getDouble(3));
			p.setIdPrestacao(rs.getInt(4));
			
		}
		
		return p;
	}

}
