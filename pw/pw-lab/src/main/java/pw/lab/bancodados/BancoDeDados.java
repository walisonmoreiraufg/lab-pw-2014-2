package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class BancoDeDados {
	
	//Implementação de Singleton (instância única).
	private static BancoDeDados instance;
	public static BancoDeDados getInstance() {
		if (instance == null) {
			instance = new BancoDeDados();
		}
		return instance;
	}

	// Referência para uma conexão com o banco de dados.
	private Connection conexao;
	public Connection getConexao() {
		return conexao;
	}

	public void abrirConexao() {
		System.out.println("Abrindo conexão com o banco de dados...");
		// URL de conexão com o banco de dados Derby.
		String url = "jdbc:derby:banco-de-dados;create=true";
		// URL de conexão com o banco de dados Derby em memória.
		// String url = "jdbc:derby:memory:banco-de-dados;create=true";
		// URL equivalente em MySQL.
		// String url = "jdbc:mysql://localhost/banco-de-dados";
		try {
			// Abrir uma conexão com o banco de dados.
			conexao = DriverManager.getConnection(url);
		} catch (Exception e) {
			throw new RuntimeException( "Erro ao abrir uma conexão com o banco de dados.", e);
		}
	}

	public void criarTabelaDeUsuario() {
		System.out.println("Criando tabela de usuário...");
		String sql = "" + "create table usuario (" + "  id bigint not null,"
				+ "  nome varchar(50) not null,"
				+ "  identificacao varchar(50) not null,"
				+ "  senha varchar(50) not null,"
				+ "  constraint pk_usuario primary key (id) " + ")";
		try {
			// Criar a tabela de usuário.
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (Exception e) {
			if (e instanceof SQLSyntaxErrorException) {
				System.out.println("Opa! " + e.getMessage());
			} else {
				throw new RuntimeException("Erro ao criar tabela de usuário.", e);
			}
		}
	}

	public void mostrarUsuarios() {
		System.out.println("  Mostrando usuarios...");
		String sql = "select id, nome, identificacao from usuario";
		try {
			//Mostrar os usuários da tabela.
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String identificacao = rs.getString("identificacao");
				String nome = rs.getString("nome");
				System.out.println("    " +
						id + " - " +
						identificacao + " - " +
						nome);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao mostrar os usuários da tabela.", e);
		}
	}

	public void apagarUsuarios() {
		System.out.println("Apagando usuários...");
		String sql = "delete from usuario";
		try {
			// Apagar os usuários.
			Statement stmt = conexao.createStatement();
			int count = stmt.executeUpdate(sql);
			stmt.close();
			System.out.println(count + " registros apagados.");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao apagar os usuários.", e);
		}
	}

	public void apagarTabelaDeUsuario() {
		System.out.println("Apagando tabela de usuário...");
		String sql = "drop table usuario";
		try {
			// Apagar a tabela de usuário.
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (Exception e) {
			if (e instanceof SQLSyntaxErrorException) {
				System.out.println("Opa! " + e.getMessage());
			} else {
				throw new RuntimeException("Erro ao apagar tabela de usuário.", e);
			}
		}
	}

	public void fecharConexaoComOBancoDeDados() {
		System.out.println("Fechando conexão com o banco de dados...");
		try {
			// Fechar conexão com o banco de dados.
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar conexão com o banco de dados.", e);
		}
	}

}
