package pw.lab.bancodados;

public class TesteDeBancoDeDadosApagarUsuarios {

	private BancoDeDados bancoDeDados = BancoDeDados.getInstance();

	public static void main(String[] args) {
		System.out.println("Início");
		TesteDeBancoDeDadosApagarUsuarios teste = new TesteDeBancoDeDadosApagarUsuarios();
		teste.bancoDeDados.abrirConexao();
		teste.bancoDeDados.apagarUsuarios();
		teste.bancoDeDados.fecharConexaoComOBancoDeDados();
		System.out.println("Fim");
	}
}
