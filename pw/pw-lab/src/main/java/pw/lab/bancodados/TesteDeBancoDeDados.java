package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe para testes com um banco de dados.
 *
 * @author Walison
 */
public class TesteDeBancoDeDados {

	//Referência para uma conexão com o banco de dados.
	private Connection conexao;

	private BancoDeDados bancoDeDados = BancoDeDados.getInstance();

	public static void main(String[] args) {
		System.out.println("Início do teste de banco de dados.");
		TesteDeBancoDeDados testeDb = new TesteDeBancoDeDados();
		testeDb.bancoDeDados.abrirConexao();
		testeDb.bancoDeDados.apagarTabelaDeUsuario();
		testeDb.bancoDeDados.criarTabelaDeUsuario();
		testeDb.incluirUsuarios();
		testeDb.bancoDeDados.mostrarUsuarios();
		testeDb.alterarUsuarios();
		testeDb.bancoDeDados.mostrarUsuarios();
		testeDb.bancoDeDados.apagarUsuarios();
		testeDb.bancoDeDados.apagarTabelaDeUsuario();
		testeDb.bancoDeDados.fecharConexaoComOBancoDeDados();
		System.out.println("Fim do teste de banco de dados.");
	}

	private void incluirUsuarios() {
		System.out.println("  Incluindo usuários...");
		String sql = "insert into usuario "
				+ "(id, nome, identificacao, senha) "
				+ "values "
				+ "(1, 'Usuario 1', 'usuario1', '123')";
		try {
			//Incluir o Usuario 1.
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 1.", e);
		}

		sql = "insert into usuario "
				+ "(id, nome, identificacao, senha) "
				+ "values "
				+ "(2, 'Usuario 2', 'usuario2', '456')";
		try {
			//Incluir o Usuario 2.
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 2.", e);
		}
	}

	private void alterarUsuarios() {
		System.out.println("  Alterando usuários...");
		String sql = "update usuario set "
				+ "nome = 'José Maria', "
				+ "identificacao = 'jose' "
				+ "where "
				+ "id = 1";
		try {
			//Alterar o nome do Usuario 1.
			int count = conexao.createStatement().executeUpdate(sql);
			System.out.println("    " + count + " registros alterados.");
		} catch(Exception e) {
			throw new RuntimeException("Erro ao alterar o nome do Usuario 1.", e);
		}

		sql = "update usuario set nome = 'Maria José', identificacao = 'maria' where id = 2";
		try {
			//Alterar o nome do Usuario 2.
			int count = conexao.createStatement().executeUpdate(sql);
			System.out.println("    " + count + " registros alterados.");
		} catch(Exception e) {
			throw new RuntimeException("Erro ao alterar o nome do Usuario 2.", e);
		}
	}
}
