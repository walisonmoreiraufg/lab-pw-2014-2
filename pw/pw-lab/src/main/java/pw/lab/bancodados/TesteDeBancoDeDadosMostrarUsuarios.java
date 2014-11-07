package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Classe para testes com um banco de dados.
 *
 * @author Walison
 */
public class TesteDeBancoDeDadosMostrarUsuarios {
	
	//Referência para uma conexão com o banco de dados.
	private Connection conexao;
	
	public static void main(String[] args) {
		System.out.println("Início.");
		TesteDeBancoDeDadosMostrarUsuarios testeDb = new TesteDeBancoDeDadosMostrarUsuarios();
		testeDb.obterConexaoComOBancoDeDados();
		testeDb.mostrarUsuarios();
		testeDb.fecharConexaoComOBancoDeDados();
		System.out.println("Fim.");
	}

	private void obterConexaoComOBancoDeDados() {
		System.out.println("  Obtendo conexão com o banco de dados...");
		//URL de conexão com o banco de dados Derby.
		String url = "jdbc:derby:banco-de-dados;create=true";
		//URL de conexão com o banco de dados Derby em memória.
		//String url = "jdbc:derby:memory:banco-de-dados;create=true";
		//URL equivalente em MySQL.
		//String url = "jdbc:mysql://localhost/banco-de-dados";
		try {
			//Obter uma conexão com o banco de dados.
			conexao = DriverManager.getConnection(url);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao obter uma conexão com o banco de dados.", e);
		}
	}

	void mostrarUsuarios() {
		System.out.println("  Mostrando usuarios...");
		String sql = "select id, nome, identificacao from usuario";
		try {
			//Mostrar os usuários da tabela.
			ResultSet rs = conexao.createStatement().executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String identificacao = rs.getString("identificacao");
				String nome = rs.getString("nome");
				System.out.println("    " +
						id + " - " +
						identificacao + " - " +
						nome);
			}
			//...
		} catch(Exception e) {
			throw new RuntimeException("Erro ao mostrar os usuários da tabela.", e);
		}
	}
	
	private void fecharConexaoComOBancoDeDados() {
		System.out.println("  Fechando conexão com o banco de dados...");
		try {
			//Fechar conexão com o banco de dados.
			conexao.close();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao fechar conexão com o banco de dados.", e);
		}
	}
}
