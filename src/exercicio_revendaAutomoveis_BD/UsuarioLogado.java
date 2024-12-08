package exercicio_revendaAutomoveis_BD;

public class UsuarioLogado {
	private static String nomeUsuario;

	public static String getNomeUsuario() {
		return nomeUsuario;
	}

	public static void setNomeUsuario(String nomeUsuario) {
		UsuarioLogado.nomeUsuario = nomeUsuario;
	}
}
