package dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			this.conexao = DriverManager.getConnection(
					"jdbc:postgresql://http://127.0.0.1:55099/web_em_camadas",
					"postgres",//usuario
					"123"//senha
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
		try {
			
			this.conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
