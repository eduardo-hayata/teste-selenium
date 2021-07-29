package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class GmailPage {

	public void escreverEmail(String email) {
		getDriver().findElement(By.xpath("//input[@name='identifier']")).clear();  // limpa o campo, caso tenha algo escrito nele
		getDriver().findElement(By.xpath("//input[@name='identifier']")).sendKeys(email);
	}
	
	public void escreverSenha(String senha) {
		getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(senha);
	}

	public void clicarBotaoProximo() {
		getDriver().findElement(By.xpath("//span[.='Próxima']")).click();
	}

	public String obterMensagemErroEmail() {
		return getDriver().findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	}

	public String obterMensagemErroSenha() {
		return getDriver().findElement(By.xpath("//div[@jsname='B34EJ']/span")).getText();
	}

}


