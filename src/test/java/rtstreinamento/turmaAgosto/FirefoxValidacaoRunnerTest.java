package rtstreinamento.turmaAgosto;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				"src/test/features/rtstreinamento/turmaAgosto/news/CadastrarNewslatter.feature",
				"src/test/features/rtstreinamento/turmaAgosto/pesquisar/PesquisarFilmes.feature"
		},
		tags = { "@validação","~@execução-manual" },
		format = "json:target/cucumber-validacao-firefox.json"
		)
		
public class FirefoxValidacaoRunnerTest {
	@BeforeClass
	public static void antesDoTeste() throws IOException{
		Navegador.executarTesteNo(NavegadorUtilizado.FIREFOX);
		Navegador.abrir();
	}
	
	@AfterClass
	public static void depoisDoTeste() {
		Navegador.fechar();
	}
}
