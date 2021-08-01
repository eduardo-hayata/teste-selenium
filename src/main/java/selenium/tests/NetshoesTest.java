package selenium.tests;

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
		DriverFactory.getDriver().get("https://www.netshoes.com.br/");
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	@Test
	public void deveAcessarCategoriaSuplementos() {
		page.clicarMenuCategoria();
		page.clicarImagemDaCategoria("Suplementos");
		
		// Verifica se a URL contém a palavra "suplementos", pra ver se está na página certa
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("suplementos"));
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
		page.clicarImagemDaCategoria("Calçados");
		
		// Verifica se a URL contém a palavra "calcados", pra ver se está na página certa
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("calcados"));
	}
	
	@Test
	public void devePesquisarProduto() {
		page.pesquisar("Camisetas");
		
		Assert.assertEquals("Resultados de busca para \"Camisetas\"".toUpperCase(), page.obterNomeProdutoPesquisado());
	}
	
	@Test
	public void deveClicarEmEntrar() {
		page.clicar("Entrar");
		page.clicar("Login");
		
		// Verifica se a URL contém a palavra "login", pra ver se está na página certa
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
	}
	
	@Test
	public void deveTentarFazerLoginSemPreencherCampos() {
		page.clicar("Entrar");
		page.clicar("Login");
		page.clicarBotao("Acessar conta");
		
		Assert.assertEquals("O campo E-mail, CPF ou CNPJ é obrigatório.", page.obterMensagemErroEmail());
		Assert.assertEquals("O campo Senha é obrigatório.", page.obterMensagemErroSenha());
	}
	
	
}
