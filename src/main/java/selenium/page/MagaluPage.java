package selenium.page;

import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	public void clicarPorTitulo(String titulo) {
		clicar(By.xpath("//h3[@title='"+titulo+"']"));
	}

	public void clicarBotaoContinuarConta() {
		clicar(By.xpath("//span[@class='mobile-hidden']"));
	}
	
	public void clicarBotaoContinuarLogin() {
		clicar(By.xpath("//button[.='Continuar']"));
	}
	
	public void addProdutoNaSacola() {
		clicar(By.xpath("(//span[@class='button__text'])[1]"));
	}
	
	public void selecionarSemGarantia() {
		clicar(By.id("no-warranty"));
	}
	
	public void excluirProdutoSacola() {
		clicar(By.className("BasketItem-delete-label"));
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

	public String obterMensagemSacolaVazia() {
		//return obterTexto(By.className("EmptyBasket-title"));
		//return obterTexto(By.xpath("//*[@class='EmptyBasket-title']"));
		return obterTexto(By.xpath("//*[contains(text(),'vazia')]"));
		
		// TBD: Ainda não consegui pegar a MSG correta
	}
	
	public void rolarTela(int pos_x, int pos_y) {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy("+pos_x+", "+pos_y+")");  // Scroll 
		
		//window.scrollBy(X, Y);
		//Coordenadas positivas deslocarão para a direita e para baixo
		//Coordenadas negativas deslocarão para a esquerda e para cima
	}
	
	public void rolarTelaPraBaixo() {
		rolarTela(0, 500);
	}

	

}


