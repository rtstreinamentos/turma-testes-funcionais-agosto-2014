package rtstreinamento.turmaAgosto.app;

public class Login {

	public boolean autenticacao(String usuario, String senha) {
		if (senha.length() > 10 || senha.length() < 8) {
			return false;
		} else if (usuario.isEmpty()) {
			return false;
		} else if (!(usuario.equals("joao@gmail.com") && senha
				.equals("12345678"))) {
			return false;
		}

		return true;
	}

}
