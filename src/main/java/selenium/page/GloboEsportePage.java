package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GloboEsportePage {

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarMenu() {
		clicar(By.xpath("(//div[@class='menu-button'])[1]"));
	}
	
	public void clicarSubMenuBrasileirao() {
		clicar(By.id("menu-1-brasileirao"));
	}
	
	public void clicarSubMenuF1() {
		clicar(By.id("menu-1-formula-1"));
	}
	
	public String obterTitulo(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTituloDaPaginaCampBrasileiro() {
		return obterTitulo(By.xpath("(//a[.='brasileirão série a'])[1]"));
	}

	public String obterTituloDaPaginaF1() {
		return obterTitulo(By.xpath("(//a[.='fórmula 1'])[1]"));
	}

	public void clicarMenuEscudo() {
		clicar(By.xpath("(//div[@class='icons-escudo-header'])[1]"));
	}

	public void clicarTexto(String string) {
		clicar(By.xpath("(//div[@id='Europa'])[1]//label"));
	}

	public void clicarTimeBarcelona() {
		clicar(By.xpath("(//a[@title='Barcelona'])[1]"));
	}

	public String obterTituloDaPaginaBarcelona() {
		return obterTitulo(By.xpath("(//a[.='barcelona'])[1]"));
	}

	public void clicarG1() {
		clicar(By.xpath("//a[.='g1']"));
	}

	public String obterTituloDaPaginaG1() {
		return obterTitulo(By.xpath("(//h1[@class='logo'])[1]"));
	}

	public void pesquisar(String texto) {
		getDriver().findElement(By.id("busca-campo")).sendKeys(texto);
		getDriver().findElement(By.id("busca-campo")).sendKeys(Keys.ENTER);
	}

	public String obterTextoCampoPesquisa() {
		return getDriver().findElement(By.xpath("//input[@placeholder='BUSCAR']")).getAttribute("value");
	}
	
}


