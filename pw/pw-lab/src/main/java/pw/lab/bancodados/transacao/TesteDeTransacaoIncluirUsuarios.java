package pw.lab.bancodados.transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Atenção! Essa classe depende da classe 
 * @author Walison
 *
 */
public class TesteDeTransacaoIncluirUsuarios {
	
	private Connection conexao;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Início.");
		TesteDeTransacaoIncluirUsuarios testeDb = new TesteDeTransacaoIncluirUsuarios();
		testeDb.obterConexaoComOBancoDeDados();
		
		//Iniciar transação.
		testeDb.conexao.setAutoCommit(false);
		
		try {
			testeDb.incluirUsuario1();
			if (true) { //Apenar para "enganar" o compilador.
				throw new RuntimeException("Acabou a energia"); //Simula um problema inesperado.
			}
			testeDb.incluirUsuario2();

			//Efetivar alterações no banco de dados.
			testeDb.conexao.commit();
		} catch (Exception e) {
			//Desfazer alterações no banco de dados.
			testeDb.conexao.rollback();
		}

		testeDb.fecharConexaoComOBancoDeDados();
		System.out.println("Fim");
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

	private void incluirUsuario1() {
		System.out.println("  Incluindo usuário 1...");
		String sql = "insert into usuario "
				+ "(id, nome, identificacao, senha) "
				+ "values "
				+ "(1, 'Usuario 1', 'usuario1', '123')";
		try {
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 1.", e);
		}
	}

	private void incluirUsuario2() {
		System.out.println("  Incluindo usuário 1...");
		String sql = "insert into usuario "
				+ "(id, nome, identificacao, senha) "
				+ "values "
				+ "(2, 'Usuario 2', 'usuario2', '456')";
		try {
			conexao.createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 2.", e);
		}
	}

	private void mostrarUsuarios() {
		System.out.println("  Mostrando usuarios...");
		String sql = "select id, nome, identificacao from usuario";
		try {
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
		} catch(Exception e) {
			throw new RuntimeException("Erro ao mostrar os usuários da tabela.", e);
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
