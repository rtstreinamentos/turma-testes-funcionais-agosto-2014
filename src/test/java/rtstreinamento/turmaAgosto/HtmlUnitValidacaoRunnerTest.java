package rtstreinamento.turmaAgosto;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features/rtstreinamento/turmaAgosto/pesquisar/PesquisarFilmes.feature",
		tags = { "@validação","~@execução-manual" },
		format = "json:target/cucumber-validacao-htmlunit.json"
		)
		
public class HtmlUnitValidacaoRunnerTest {
	@BeforeClass
	public static void antesDoTeste() throws IOException{
		Navegador.executarTesteNo(NavegadorUtilizado.HTMLUNIT);
		Navegador.abrir();
	}
	
	@AfterClass
	public static void depoisDoTeste() {
		Navegador.fechar();
	}
}
