package rtstreinamento.turmaAgosto;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features",
		tags = { "@exceção","~@execução-manual" },
		format = "json:target/cucumber-excecao.json"
		)
public class ExcecaoRunnerTest {
	@BeforeClass
	public static void antesDoTeste(){
		Navegador.abrirFireFox();
		//Navegador.abrirChrome();
	}
	
	@AfterClass
	public static void depoisDoTeste() {
		Navegador.fechar();
	}
}
