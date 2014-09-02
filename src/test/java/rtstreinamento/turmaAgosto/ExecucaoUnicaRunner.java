package rtstreinamento.turmaAgosto;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features",
		tags = { "@execucaoUnica" },
		format = "json:target/cucumber-validacao.json"
		)
		
public class ExecucaoUnicaRunner {
	@BeforeClass
	public static void antesDoTeste() throws IOException{
		Navegador.executarTesteNo(NavegadorUtilizado.CHROME);
		Navegador.abrir();
		
	}
	
	@AfterClass
	public static void depoisDoTeste() {
		Navegador.fechar();
	}

}
