package pw.lab.bancodados;


public class TesteDeBancoDeDadosMostrarUsuarios {
	
	private BancoDeDados bancoDeDados = BancoDeDados.getInstance();

	public static void main(String[] args) {
		System.out.println("Início");
		TesteDeBancoDeDadosMostrarUsuarios teste = new TesteDeBancoDeDadosMostrarUsuarios();
		teste.bancoDeDados.abrirConexao();

		teste.bancoDeDados.mostrarUsuarios();

		teste.bancoDeDados.fecharConexaoComOBancoDeDados();
		System.out.println("Fim");
	}
}
