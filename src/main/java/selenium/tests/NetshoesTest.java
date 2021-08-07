package selenium.tests;

import static selenium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.NetshoesPage;

public class NetshoesTest extends BaseTest {

	private NetshoesPage page = new NetshoesPage();
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.netshoes.com.br/");
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	@Test
	public void deveAcessarCategoriaSuplementos() {
		page.clicarMenuCategoria();
		page.clicarImagemDaCategoria("Suplementos");
		
		// Verifica se a URL cont�m a palavra "suplementos", pra ver se est� na p�gina certa
		Assert.assertTrue(getDriver().getCurrentUrl().contains("suplementos"));
	}
	
	@Test
	public void deveAcessarTipoSuplemento() {
		page.clicarMenuCategoria();
		page.clicarNomeDaCategoria("Suplementos");
		page.clicarTipoSuplemento("Whey Protein");
		
		Assert.assertEquals("Whey Protein".toUpperCase(), page.obterNomeProdutoPesquisado());
	}
	
	@Test
	public void deveAcessarCategoriaCalcados() {
		page.clicarMenuCategoria();
		page.clicarImagemDaCategoria("Cal�ados");
		
		// Verifica se a URL cont�m a palavra "calcados", pra ver se est� na p�gina certa
		Assert.assertTrue(getDriver().getCurrentUrl().contains("calcados"));
	}
	
	@Test
	public void devePesquisarProduto() {
		page.pesquisar("Camisetas");
		Assert.assertEquals("Resultados de busca para \"Camisetas\"".toUpperCase(), page.obterNomeProdutoPesquisado());
	}
	
	@Test
	public void deveClicarEmEntrar() {
		page.clicarPorTexto("Entrar");
		page.clicarPorTexto("Login");
		
		// Verifica se a URL cont�m a palavra "login", pra ver se est� na p�gina certa
		Assert.assertTrue(getDriver().getCurrentUrl().contains("login"));
	}
	
	@Test
	public void deveTentarFazerLoginSemPreencherCampos() {
		page.clicarPorTexto("Entrar");
		page.clicarPorTexto("Login");
		page.clicarBotao("Acessar conta");
		
		Assert.assertEquals("O campo E-mail, CPF ou CNPJ � obrigat�rio.", page.obterMensagemErroEmail());
		Assert.assertEquals("O campo Senha � obrigat�rio.", page.obterMensagemErroSenha());
	}
	
	@Test
	public void deveRemoverProdutoDoCarrinho() throws InterruptedException {
		// Vai pra Pag. espec�fica de um Produto
		getDriver().get("https://www.netshoes.com.br/best-whey-900g-atlhetica-nutrition-cookies+cream-097-9108-433");
		
		page.rolarTela();  // Scroll da Tela p/ fazer o Bot�o "Comprar" aparecer
		page.clicarComprar();
		page.clicarRemoverProdutoCarrinho();
		
		Assert.assertEquals("Seu carrinho est� vazio", page.obterMensagemCarrinhovazio());
	}
	
	@Test
	public void deveSimularCompraDeProduto() throws InterruptedException {
		// Vai pra Pag. espec�fica de um Produto
		getDriver().get("https://www.netshoes.com.br/best-whey-900g-atlhetica-nutrition-cookies+cream-097-9108-433");
		
		page.rolarTela();  // Scroll da Tela p/ fazer o Bot�o "Comprar" aparecer
		page.clicarComprar();
		page.clicarContinuar();
		
		// Como o usu�rio n�o estava logado, precisa logar antes, pra poder finalizar a compra...
		// Verifica se a URL cont�m a palavra "login", pra ver se est� na p�gina certa
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
	}
	
	
}
