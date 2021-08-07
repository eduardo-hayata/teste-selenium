package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class NetshoesPage {
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarMenuCategoria() {
		clicar(By.xpath("//div[@class='navbar__hamburger--box']"));
	}

	public void clicarImagemDaCategoria(String categoria) {
		clicar(By.xpath("//ul[@class='navbar__dropdown--thumb']//h6[.=' "+categoria+" ']/.."));
	}

	public void clicarNomeDaCategoria(String categoria) {
		clicar(By.xpath("//ul[@class='navbar__dropdown--thumb']//h6[.=' "+categoria+" ']"));
	}

	public void clicarTipoSuplemento(String tipoSuplemento) {
		clicar(By.xpath("//a[@title='"+tipoSuplemento+"']"));
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//a[.=\""+texto+"\"]"));
	}

	public void clicarBotao(String botao) {
		clicar(By.xpath("//button[.=\""+botao+"\"]"));
	}
	
	public void clicarComprar() throws InterruptedException {
		Thread.sleep(5000);  // espera 5 segundos
		clicar(By.xpath("//button[@id='buy-button-now']"));
	}
	
	public void clicarRemoverProdutoCarrinho() throws InterruptedException {
		Thread.sleep(5000);  // espera 5 segundos
		clicar(By.xpath("//i[@qa-auto='product-btn-remove']"));
	}
	
	public void clicarContinuar() throws InterruptedException {
		Thread.sleep(5000);  // espera 5 segundos
		clicar(By.xpath("//a[@qa-auto='cart-buy-button']"));
	}
	
	public void pesquisar(String texto) {
		getDriver().findElement(By.id("search-input")).sendKeys(texto);   // Escreve no campo pesquisa
		clicar(By.xpath("//button[@title='Buscar']"));  // Clica na lupa "buscar"
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterNomeProdutoPesquisado() {
		return obterTexto(By.xpath("//h1[@class='search-query']"));
	}

	public String obterMensagemErroEmail() {
		return obterTexto(By.xpath("//input[@id='username']/..//span"));
	}

	public String obterMensagemErroSenha() {
		return obterTexto(By.xpath("//input[@id='password']/..//span"));
	}
	
	public String obterMensagemCarrinhovazio() throws InterruptedException {
		Thread.sleep(5000);  // espera 5 segundos
		return obterTexto(By.xpath("//h1[@class='empty-page__title  ']"));
	}
	
	public void rolarTela() {
		WebElement element = getDriver().findElement(By.id("buy-button-now"));
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 200)", element.getLocation().y);  // Scroll pra baixo
		
		//window.scrollBy(X, Y);
		//Coordenadas positivas deslocarão para a direita e para baixo
		//Coordenadas negativas deslocarão para a esquerda e para cima
	}


}


