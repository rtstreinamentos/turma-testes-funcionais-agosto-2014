package rtstreinamento.turmaAgosto.steps;

import java.util.UUID;

import rtstreinamento.turmaAgosto.paginas.Newslatter;
import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarNewslatterSteps {
	Newslatter newslatter = new Newslatter();
	String email;
	@Dado("^que eu queira me cadastrar na newsletter$")
	public void que_eu_queira_me_cadastrar_na_newsletter() throws Throwable {
		newslatter = new Newslatter();
		newslatter.abrirSite();
	}

	@Dado("^que o e-mail não esteja cadastrado$")
	public void que_o_e_mail_não_esteja_cadastrado() throws Throwable {
		email = UUID.randomUUID().toString().substring(1,15)+ "@gmail.com";
	}

	@Quando("^cadastro esse e-mail$")
	public void cadastro_esse_mail() throws Throwable {
		cadastro_o_e_mail(email);
	}

	@Quando("^cadastro o e-mail \"([^\"]*)\"$")
	public void cadastro_o_e_mail(String email) throws Throwable {

		newslatter.preencherEmail(email);
		newslatter.clicarBotao();
	}

	@Então("^recebo uma mensagem de sucesso$")
	public void recebo_uma_mensagem_de_sucesso() throws Throwable {

		String mensagemEsperada = "Seu cadastro foi realizado com sucesso em nossa newsletter.";
		String mensagemAtual = newslatter.obterMensagem();

		Assert.assertEquals(mensagemEsperada, mensagemAtual);
	}

	@Dado("^que o e-mail \"([^\"]*)\" já tenha sido cadastrado$")
	public void que_o_e_mail_já_tenha_sido_cadastrado(String email)
			throws Throwable {

		newslatter.preencherEmail(email);
		newslatter.clicarBotao();
	}

	@Entao("^recebo mensagem de erro$")
	public void recebo_mensagem_de_erro() throws Throwable {

		String mensagemAtual = newslatter.obterMensagemErro();

		String mensagemEsperada = "O seu e-mail já consta em nossa newsletter.";
		Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));

	}
	
	@Entao("^recebo mensagem de erro invalido$")
	public void recebo_mensagem_de_erro_invalido() throws Throwable {
		String mensagemAtual = newslatter.obterClassCssError();

		String mensagemEsperada = "error";
		Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));
	}
}
