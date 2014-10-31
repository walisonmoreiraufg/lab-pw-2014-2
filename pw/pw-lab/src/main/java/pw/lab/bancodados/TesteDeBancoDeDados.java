package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Classe para testes com um banco de dados.
 *
 * @author Walison
 */
public class TesteDeBancoDeDados {
	
	//Referência para uma conexão com o banco de dados.
	private Connection conexao;
	
	public static void main(String[] args) {
		System.out.println("Início do teste de banco de dados.");
		TesteDeBancoDeDados testeDb = new TesteDeBancoDeDados();
		testeDb.obterConexaoComOBancoDeDados();
		testeDb.criarTabelaDeUsuario();
		testeDb.incluirUsuarios();
		testeDb.mostrarUsuarios();
		testeDb.alterarUsuarios();
		testeDb.mostrarUsuarios();
		testeDb.apagarUsuarios();
		testeDb.apagarTabelaDeUsuario();
		testeDb.fecharConexaoComOBancoDeDados();
		System.out.println("Fim do teste de banco de dados.");
	}

	private void obterConexaoComOBancoDeDados() {
		System.out.println("  Obtendo conexão com o banco de dados...");
		String url = "jdbc:derby:banco-de-dados;create=true";
		//URL de conexão com o banco de dados Derby em memória.
		//String url = "jdbc:derby:memory:banco-de-dados;create=true";
		//URL equivalente em MySQL.
		//String url = "jdbc:mysql://localhost/banco-de-dados";
		try {
			//Conexão com o banco de dados.
			conexao = DriverManager.getConnection(url);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao obter uma conexão com o banco de dados.", e);
		}
	}

	private void criarTabelaDeUsuario() {
		System.out.println("  Criando tabela de usuário...");
		String sql = "" +
		"create table usuario (" +
		"  id bigint not null," +
		"  nome varchar(50) not null," +
		"  identificacao varchar(50) not null," +
		"  senha varchar(50) not null," +
		"  constraint pk_usuario primary key (id) " +
		")";
		try {
			//Criar a tabela de usuário.
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao criar a tabela de usuário.", e);
		}
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

	private void mostrarUsuarios() {
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

	private void apagarUsuarios() {
		System.out.println("  Apagando usuários...");
		String sql = "delete from usuario";
		try {
			//Apagar os usuários.
			int count = conexao.createStatement().executeUpdate(sql);
			System.out.println("    " + count + " registros apagados.");
		} catch(Exception e) {
			throw new RuntimeException("Erro ao apagar os usuários.", e);
		}
	}

	private void apagarTabelaDeUsuario() {
		System.out.println("  Apagando tabela de usuário...");
		String sql = "drop table usuario";
		try {
			//Apagar a tabela de usuário.
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao apagar a tabela de usuário.", e);
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
