package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MagaluPage {

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarMenuTodosOsDepartamentos() {
		clicar(By.xpath("//i[@class='icon-hamburger']"));
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("(//a[.='"+texto+"'])[1]"));
	}

	public void clicarBotaoContinuarConta() {
		clicar(By.xpath("//span[@class='mobile-hidden']"));
	}
	
	public void clicarBotaoContinuarLogin() {
		clicar(By.xpath("//button[.='Continuar']"));
	}

	public void selecionar(String texto) {
		WebElement el = getDriver().findElement(By.xpath("(//a[.='"+texto+"'])[1]"));
		Actions action = new Actions(getDriver());
		action.moveToElement(el).perform();
	}
	
	public void selecionarTodosOsDepartamentos() {
		WebElement el = getDriver().findElement(By.xpath("//span[.='Todos os departamentos']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(el).perform();
	}

	public void pesquisar(String texto) {
		getDriver().findElement(By.id("inpHeaderSearch")).sendKeys(texto);
		clicar(By.xpath("//span[@id='btnHeaderSearch']/i"));
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTituloDaPagina() {
		return obterTexto(By.xpath("//h1[@itemprop='description']"));
	}
	
	public String obterMsgErroConta() {
		return obterTexto(By.xpath("//p[@class='FormGroup-errorMessage']"));
	}

	public String obterMsgErroEmail() {
		return obterTexto(By.xpath("//p[.='Insira um CPF, CNPJ ou E-mail válido.']"));
	}

	public String obterMsgErroSenha() {
		return obterTexto(By.xpath("//p[.='Insira a senha.']"));
	}
	
	

}


