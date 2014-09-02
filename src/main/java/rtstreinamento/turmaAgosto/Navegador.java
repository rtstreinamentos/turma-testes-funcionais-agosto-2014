package rtstreinamento.turmaAgosto;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Navegador {

	protected static WebDriver driver;
	private static NavegadorUtilizado navegadorUtilizado;

	public static void abrir() throws IOException {
		switch (navegadorUtilizado) {
		case FIREFOX:
			abrirFireFox();
			break;
		case CHROME:
			abrirChrome();
			break;
		case GHOST:
			abrirGhost();
			break;
		case HTMLUNIT:
			abrirHtmlUnit();
			break;
		default:
			break;
		}
	}
	
	
	private static void abrirGhost() throws IOException {
		System.out.println("Abrindo Navegador");
		String diretorioPhantomDriver=Configuracoes.lerConfiguracao("path-ghost-driver");
		System.setProperty("phantomjs.binary.path",diretorioPhantomDriver);
		driver = new PhantomJSDriver();
		driver.manage().window().maximize();
	}


	private static void abrirHtmlUnit() {
		System.out.println("Abrindo Navegador");
		driver = new HtmlUnitDriver();
	}


	public static void abrirFireFox() {
		System.out.println("Abrindo Navegador");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public static void abrirChrome() throws IOException {
		System.out.println("Abrindo Navegador");
		String diretorioChromeDriver=Configuracoes.lerConfiguracao("path-chrome-driver");
		System.setProperty("webdriver.chrome.driver",diretorioChromeDriver);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}

	public static void fechar() {
		System.out.println("Fechando Navegador");
		driver.quit();
		
	}

	public static void executarTesteNo(NavegadorUtilizado navagedaorUtilizado) {
		navegadorUtilizado = navagedaorUtilizado;
	}



}
