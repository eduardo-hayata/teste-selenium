package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class HotmailPage {

	public void escreverEmail(String email) {
		getDriver().findElement(By.xpath("//input[@name='loginfmt']")).clear();  // limpa o campo, caso tenha algo escrito nele
		getDriver().findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(email);
	}
	
	public void escreverSenha(String senha) {
		getDriver().findElement(By.xpath("//input[@name='passwd']")).sendKeys(senha);
	}
	
	public void clicarBotaoProximo() {
		getDriver().findElement(By.xpath("//input[@type='submit']")).click();
	}

	public String obterMensagemErroEmail() {
		//return getDriver().findElement(By.xpath("//div[@class='col-md-24 error ext-error']")).getText();
		return getDriver().findElement(By.xpath("//div[@id='usernameError']")).getText();
	}
	
	public String obterMensagemErroSenha() {
		return getDriver().findElement(By.xpath("//div[@id='passwordError']")).getText();
	}
	
}


