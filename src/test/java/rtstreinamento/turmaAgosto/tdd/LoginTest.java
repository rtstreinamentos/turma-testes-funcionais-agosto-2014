package rtstreinamento.turmaAgosto.tdd;

import junit.framework.Assert;

import org.junit.Test;

import rtstreinamento.turmaAgosto.app.Login;

public class LoginTest {

	@Test
	public void logarComEmailSenhaValidos() {
		String usuario = "joao@gmail.com";
		String senha = "12345678";
		Login login = new Login();
		
		Assert.assertTrue(login.autenticacao(usuario, senha));
	}

	@Test
	public void naoLogarComSenhaMaiorQue10Caracteres() {
		String usuario = "joao@gmail.com";
		String senha = "12345678901";
		Login login = new Login();
		
		Assert.assertFalse(login.autenticacao(usuario, senha));
	}
	@Test
	public void naoLogarComSenhaMenorQue8Caracteres() {
		String usuario = "joao@gmail.com";
		String senha = "1234567";
		Login login = new Login();
		
		Assert.assertFalse(login.autenticacao(usuario, senha));
	}
	
	@Test
	public void naoLogarComLonginEmBranco() {
		String usuario = "";
		String senha = "12345678";
		Login login = new Login();
		
		Assert.assertFalse(login.autenticacao(usuario, senha));
	}
	
	@Test
	public void naoLogarComLonginInvalido() {
		String usuario = "renata@gmail.com";
		String senha = "12345678";
		Login login = new Login();
		
		Assert.assertFalse(login.autenticacao(usuario, senha));
	}
	
	@Test
	public void naoLogarComSenhaInvalido() {
		String usuario = "joao@gmail.com";
		String senha = "23456786";
		Login login = new Login();
		
		Assert.assertFalse(login.autenticacao(usuario, senha));
	}
}
