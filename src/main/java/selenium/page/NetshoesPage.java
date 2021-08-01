package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class NetshoesPage {
	
	public void clicarMenuCategoria() {
		getDriver().findElement(By.xpath("//div[@class='navbar__hamburger--box']")).click();
	}

	public void clicarImagemDaCategoria(String categoria) {
		getDriver().findElement(By.xpath("//ul[@class='navbar__dropdown--thumb']//h6[.=' "+categoria+" ']/..")).click();
	}

	public void clicarNomeDaCategoria(String categoria) {
		getDriver().findElement(By.xpath("//ul[@class='navbar__dropdown--thumb']//h6[.=' "+categoria+" ']")).click();
	}

	public void clicarTipoSuplemento(String tipoSuplemento) {
		getDriver().findElement(By.xpath("//a[@title='"+tipoSuplemento+"']")).click();
	}

	public String obterNomeProdutoPesquisado() {
		return getDriver().findElement(By.xpath("//h1[@class='search-query']")).getText();
	}

	public void pesquisar(String texto) {
		getDriver().findElement(By.id("search-input")).sendKeys(texto);          // Escreve no campo pesquisa
		getDriver().findElement(By.xpath("//button[@title='Buscar']")).click();  // Clica na lupa "buscar"
	}

	public void clicar(String texto) {
		getDriver().findElement(By.xpath("//a[.=\""+texto+"\"]")).click();
	}

	public void clicarBotao(String botao) {
		getDriver().findElement(By.xpath("//button[.=\""+botao+"\"]")).click();
		
	}

	public String obterMensagemErroEmail() {
		return getDriver().findElement(By.xpath("//input[@id='username']/..//span")).getText();
	}

	public String obterMensagemErroSenha() {
		return getDriver().findElement(By.xpath("//input[@id='password']/..//span")).getText();
	}

}
