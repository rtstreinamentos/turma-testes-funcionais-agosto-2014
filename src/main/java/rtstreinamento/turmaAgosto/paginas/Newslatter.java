package rtstreinamento.turmaAgosto.paginas;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import rtstreinamento.turmaAgosto.Navegador;

public class Newslatter extends Navegador{
	public void preencherEmail(String email) {
		System.out.println("Preenchi o email " + email);
		WebElement caixaDeEmail = driver.findElement(By.name("email"));
		caixaDeEmail.clear();
		caixaDeEmail.sendKeys(email);
	}

	public void clicarBotao() {
		System.out.println("Cliquei no botão ");
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div[1]/div[3]/div/div/div/div/div[1]/button"));
		botao.click();
	}

	public void abrirSite() {
		System.out.println("Abri o site ");
		driver.get("http://tghcastro.lojaintegrada.com.br/");
	}

	public String obterMensagem() throws InterruptedException {
		System.out.println("Obtive Mensagem ");
		Thread.sleep(5000);
		WebElement mensagem = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[3]/div/div/div/div/div[2]/span"));
		return mensagem.getText();
	}

	public String obterMensagemErro() throws InterruptedException {
		
		System.out.println("Obtive Mensagem Erro");
		Thread.sleep(5000);
		WebElement mensagem = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[3]/div/div/div/div/p[2]"));
		return mensagem.getText();
	}

	public String obterClassCssError() throws InterruptedException {
	
		System.out.println("Obtive Class Erro");
		Thread.sleep(5000);
		WebElement classeCss = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[3]/div/div/div/div/div[1]"));
		System.out.println(classeCss.getAttribute("class"));
		return classeCss.getAttribute("class");
		
	}

}
