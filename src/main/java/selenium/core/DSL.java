package selenium.core;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();  // limpa o campo, caso tenha algo escrito nele
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(String xpath, String texto) {
		escrever(By.xpath(xpath), texto);
	}
	
	/********* Botao ************/

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotao(String xpath) {
		clicar(By.xpath(xpath));
	}
	
	public void clicarForaCaixa(String xpath) {
		clicar(By.xpath(xpath));
	}
		

	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getAttribute("value");
	}

	public String obterTexto(String xpath) {
		 return obterTexto(By.xpath(xpath));
	}

	public String obterMsgErro(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterMensagemErro(String xpath) {
		return obterMsgErro(By.xpath(xpath));
	}
	
}
