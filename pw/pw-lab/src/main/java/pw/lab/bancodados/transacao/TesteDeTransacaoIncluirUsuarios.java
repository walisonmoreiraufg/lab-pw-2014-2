package pw.lab.bancodados.transacao;

import pw.lab.bancodados.BancoDeDados;

public class TesteDeTransacaoIncluirUsuarios {
	
	private BancoDeDados bancoDeDados = BancoDeDados.getInstance();

	public static void main(String[] args) {
		System.out.println("Início");
		TesteDeTransacaoIncluirUsuarios teste = new TesteDeTransacaoIncluirUsuarios();
		teste.bancoDeDados.abrirConexao();

		teste.incluirUsuarios();

		teste.bancoDeDados.fecharConexaoComOBancoDeDados();
		System.out.println("Fim");
	}

	private void incluirUsuarios() {
		try {
		
			//Iniciar transação.
			bancoDeDados.getConexao().setAutoCommit(false);
			
			try {
				incluirUsuario1();
				if (true) { //Apenar para "enganar" o compilador.
					throw new RuntimeException("Acabou a energia"); //Simula um problema inesperado.
				}
				incluirUsuario2();
	
				//Efetivar alterações no banco de dados.
				bancoDeDados.getConexao().commit();
			} catch (Exception e) {
				//Desfazer alterações no banco de dados.
				bancoDeDados.getConexao().rollback();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void incluirUsuario1() {
		System.out.println("  Incluindo usuário 1...");
		String sql = "insert into usuario "
				+ "(id, nome, identificacao, senha) "
				+ "values "
				+ "(1, 'Usuario 1', 'usuario1', '123')";
		try {
			bancoDeDados.getConexao().createStatement().execute(sql);
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
			bancoDeDados.getConexao().createStatement().execute(sql);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao incluir o Usuario 2.", e);
		}
	}
}
