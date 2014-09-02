package rtstreinamento.turmaAgosto.paginas;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.methods.Configurable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import rtstreinamento.turmaAgosto.Configuracoes;
import rtstreinamento.turmaAgosto.Navegador;

public class Pesquisar extends Navegador {

	public void abrirPagina() throws IOException {
		System.out.println("Abri o site ");
		String url = Configuracoes.lerConfiguracao("pagina-pesquisa");
		driver.get(url);
		
	}

	public void preencherBusca(String filme) {
		
		WebElement caixaDeBusca = driver.findElement(By.id("auto-complete"));
		caixaDeBusca.clear();
		caixaDeBusca.sendKeys(filme);
		
	}

	public void clicarBotao() {
		System.out.println("Clicar no botão de pesquisa");
		WebElement botao = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div/form/button"));
		botao.click();
	}

	public String resultadoDaPesquisa() {
		System.out.println("Resultado da pesquisa");
		WebElement resultadoPesquisa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/ul/li/ul/li/div/a"));
		return resultadoPesquisa.getAttribute("title");
	}

	public int quantidadeDeFilmesRetornadosPelaBusca() {
		
		List<WebElement> filmesRetornadosPelaBusca = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/ul/li/ul/li"));
		
		return filmesRetornadosPelaBusca.size();
	}

	public String obterMensagemNenhumFilmeCadastrado() {
		System.out.println("Resultado da pesquisa filme nao cadastrado");
		WebElement resultadoPesquisa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/h1"));
		return resultadoPesquisa.getText();
	}

	public String obterTagFilmeIndisponivel() {
		System.out.println("Resultado da pesquisa filme indisponivel");
		WebElement resultadoPesquisa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/ul/li/ul/li/div/div[3]/span"));		
		return resultadoPesquisa.getText();
	}

}
