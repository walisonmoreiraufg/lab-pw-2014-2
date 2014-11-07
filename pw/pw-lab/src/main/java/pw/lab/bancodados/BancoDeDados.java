package pw.lab.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

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
			conexao.createStatement().execute(sql);
		} catch (Exception e) {
			System.out.println("Opa! Deu erro. O programa vai continuar mas olha aí pra você ver o que pode ter sido.");
			e.printStackTrace(System.out);
		}
	}

	public void mostrarUsuarios() {
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

	public void apagarUsuarios() {
		System.out.println("Apagando usuários...");
		String sql = "delete from usuario";
		try {
			// Apagar os usuários.
			int count = conexao.createStatement().executeUpdate(sql);
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
			conexao.createStatement().execute(sql);
		} catch (Exception e) {
			System.out.println("Opa! Deu erro. O programa vai continuar mas olha aí pra você ver o que pode ter sido.");
			e.printStackTrace(System.out);
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
