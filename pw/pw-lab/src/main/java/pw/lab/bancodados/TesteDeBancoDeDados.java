package pw.lab.bancodados;

import java.sql.Connection;

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
		//URL de conexão com o banco de dados Derby em memória.
		String url = "jdbc:derby:memory:banco-de-dados;create=true";
		try {
			//TODO Implemente aqui o código para obter uma conexão com o banco de dados.
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
			//TODO Implemente aqui o código para criar a tabela de usuário.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao criar a tabela de usuário.", e);
		}
	}

	private void incluirUsuarios() {
		System.out.println("  Incluindo usuários...");
		String sql = "insert into usuario (id, nome, identificacao, senha) values (1, 'Usuario 1', 'usuario1', '123')";
		try {
			//TODO Implemente aqui o código para incluir o Usuario 1.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 1.", e);
		}

		sql = "insert into usuario (id, nome, identificacao, senha) values (2, 'Usuario 2', 'usuario2', '456')";
		try {
			//TODO Implemente aqui o código para incluir o Usuario 2.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 2.", e);
		}
	}

	private void mostrarUsuarios() {
		System.out.println("  Mostrando usuarios...");
		String sql = "select id, nome, identificacao from usuario";
		try {
			//TODO Implemente aqui o código para mostrar os usuários da tabela.
			//...
			//System.out.println("    " + id + " - " + identificacao + " - " + nome);
			//...
		} catch(Exception e) {
			throw new RuntimeException("Erro ao mostrar os usuários da tabela.", e);
		}
	}
	
	private void alterarUsuarios() {
		System.out.println("  Alterando usuários...");
		String sql = "update usuario set nome = 'José Maria', identificacao = 'jose' where id = 1";
		try {
			//TODO Implemente aqui o código para alterar o nome do Usuario 1.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao alterar o nome do Usuario 1.", e);
		}

		sql = "update usuario set nome = 'Maria José', identificacao = 'maria' where id = 2";
		try {
			//TODO Implemente aqui o código para alterar o nome do Usuario 2.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao alterar o nome do Usuario 2.", e);
		}
	}

	private void apagarUsuarios() {
		System.out.println("  Apagando usuários...");
		String sql = "delete from usuario";
		try {
			//TODO Implemente aqui o código para apagar os usuários.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao apagar os usuários.", e);
		}
	}

	private void apagarTabelaDeUsuario() {
		System.out.println("  Apagando tabela de usuário...");
		String sql = "drop table usuario";
		try {
			//TODO Implemente aqui o código para apagar a tabela de usuário.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao apagar a tabela de usuário.", e);
		}
	}

	private void fecharConexaoComOBancoDeDados() {
		System.out.println("  Fechando conexão com o banco de dados...");
		try {
			//TODO Implemente aqui o código para fechar conexão com o banco de dados.
		} catch(Exception e) {
			throw new RuntimeException("Erro ao fechar conexão com o banco de dados.", e);
		}
	}
}
