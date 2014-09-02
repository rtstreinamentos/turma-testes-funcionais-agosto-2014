package rtstreinamento.turmaAgosto.steps;

import junit.framework.Assert;
import rtstreinamento.turmaAgosto.paginas.Pesquisar;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarFilmesSteps {

	Pesquisar pesquisar = new Pesquisar();
	private String filme;

	@Dado("^Que o filme \"([^\"]*)\" esteja cadastrado$")
	public void Que_o_filme_esteja_cadastrado(String filme) throws Throwable {
		this.filme = filme;

	}

	@Quando("^Pesquiso o nome completo do filme$")
	public void Pesquiso_o_nome_completo_do_filme() throws Throwable {
		pesquisar.abrirPagina();
		pesquisar.preencherBusca(filme);
		pesquisar.clicarBotao();
	}

	@Então("^Aparece o produto$")
	public void Aparece_o_produto() throws Throwable {
		String resultadoEsperado = "Bluray - Senhor dos Anéis -  As Duas Torres";
		String filmeAtual = pesquisar.resultadoDaPesquisa();

		Assert.assertEquals(resultadoEsperado, filmeAtual);
	}

	@Dado("^Que o filme \"([^\"]*)\" e \"([^\"]*)\"estejam cadastrados$")
	public void Que_o_filme_e_estejam_cadastrados(String arg1, String arg2)
			throws Throwable {
		pesquisar.abrirPagina();

	}

	@Quando("^Pesquiso por \"([^\"]*)\"$")
	public void Pesquiso_por(String flimePesquisado) throws Throwable {

		pesquisar.preencherBusca(flimePesquisado);
		pesquisar.clicarBotao();
	}

	@Então("^Aparecem dois filmes$")
	public void Aparecem_dois_filmes() throws Throwable {
		int quantidadeEsperada = 2;
		Assert.assertEquals(quantidadeEsperada,
				pesquisar.quantidadeDeFilmesRetornadosPelaBusca());
	}

	@Dado("^Que o filme \"([^\"]*)\" não esteja cadastrado$")
	public void Que_o_filme_não_esteja_cadastrado(String filmeNaoCadastrado)
			throws Throwable {
		pesquisar.abrirPagina();
		this.filme = filmeNaoCadastrado;
	}

	@Quando("^Pesquiso por esse filme$")
	public void Pesquiso_por_esse_filme() throws Throwable {
		pesquisar.preencherBusca(filme);
		pesquisar.clicarBotao();
	}

	@Então("^Não exibe nenhum resultado na busca$")
	public void Não_exibe_nenhum_resultado_na_busca() throws Throwable {
		String resultadoEsperado = "Sua busca por: \"Homem Aranha\" não encontrou nenhum resultado";

		String resultadoAtual = pesquisar.obterMensagemNenhumFilmeCadastrado();
		;
		Assert.assertEquals(resultadoEsperado, resultadoAtual);
	}

	@Dado("^Que o filme \"([^\"]*)\" esteja indisponível$")
	public void Que_o_filme_esteja_indisponivel(String filmeIndisponivel)
			throws Throwable {
		pesquisar.abrirPagina();
		this.filme = filmeIndisponivel;
	}

	@Então("^Visualizo que o filme está indisponível$")
	public void Visualizo_que_o_filme_está_indisponível() throws Throwable {

		String resultadoEsperado = "INDISPONÍVEL";

		String resultadoAtual = pesquisar.obterTagFilmeIndisponivel();
	
		Assert.assertEquals(resultadoEsperado, resultadoAtual);
	}

}
