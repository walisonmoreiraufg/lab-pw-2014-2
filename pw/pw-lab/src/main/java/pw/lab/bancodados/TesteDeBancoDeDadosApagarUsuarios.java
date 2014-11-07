package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteDeBancoDeDadosApagarUsuarios {
	
	//Referência para uma conexão com o banco de dados.
	private Connection conexao;
	
	public static void main(String[] args) {
		System.out.println("Início.");
		TesteDeBancoDeDadosApagarUsuarios testeDb = new TesteDeBancoDeDadosApagarUsuarios();
		testeDb.obterConexaoComOBancoDeDados();
		testeDb.apagarUsuarios();
		testeDb.fecharConexaoComOBancoDeDados();
		System.out.println("Fim.");
	}

	private void obterConexaoComOBancoDeDados() {
		System.out.println("  Obtendo conexão com o banco de dados...");
		String url = "jdbc:derby:banco-de-dados;create=true";
		try {
			conexao = DriverManager.getConnection(url);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao obter uma conexão com o banco de dados.", e);
		}
	}

	private void apagarUsuarios() {
		System.out.println("  Apagando usuários...");
		String sql = "delete from usuario";
		try {
			int count = conexao.createStatement().executeUpdate(sql);
			System.out.println("    " + count + " registros apagados.");
		} catch(Exception e) {
			throw new RuntimeException("Erro ao apagar os usuários.", e);
		}
	}
	
	private void fecharConexaoComOBancoDeDados() {
		System.out.println("  Fechando conexão com o banco de dados...");
		try {
			conexao.close();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao fechar conexão com o banco de dados.", e);
		}
	}
}
