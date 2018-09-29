package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioDAO implements InUsuarioDAO {

	Connection conexao;
	
	public UsuarioDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Usuario _objeto) throws SQLException {
		
		String SQL = "insert into usuario (id,username,senha,nome,cpf) values (?,?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getUsername());
		ps.setString(3, _objeto.getSenha());
		ps.setString(4, _objeto.getNome());
		ps.setInt(5, _objeto.getCpf());
		
		try {
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> listarTodos() throws SQLException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet rs = null;
		
		String SQL = "select id,username,senha,nome,cpf from usuario";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			
			Usuario p = new Usuario();
			
			p.setId(rs.getInt(1));
			p.setUsername(rs.getString(2));
			p.setSenha(rs.getString(3));
			p.setNome(rs.getString(4));
			p.setCpf(rs.getInt(5));
			
			usuarios.add(p);
		}
		
		return usuarios;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {

		String SQL = "delete from usuario where id = ?";
		
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
	public Boolean Atualizar(Usuario _objeto) throws SQLException {
		String SQL = "update usuario set username=?,senha=?,nome=?,cpf=? where id=?";
		Boolean ret = false;
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(5, _objeto.getId());
		ps.setString(1, _objeto.getUsername());
		ps.setString(2, _objeto.getSenha());
		ps.setString(3, _objeto.getNome());
		ps.setInt(4, _objeto.getCpf());
		
		try {
			ret = ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public Usuario buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select id, username,senha,nome,cpf from usuario where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Usuario p = null;
		if (rs.next()) {
			
			p = new Usuario();
			
			p.setId(rs.getInt(1));
			p.setUsername(rs.getString(2));
			p.setSenha(rs.getString(3));
			p.setNome(rs.getString(4));
			p.setCpf(rs.getInt(5));
		}
		
		return p;
	}

}
