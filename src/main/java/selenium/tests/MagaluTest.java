package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.MagaluPage;

public class MagaluTest extends BaseTest {

	private MagaluPage page = new MagaluPage();
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://www.magazineluiza.com.br/");
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	@Test
	public void deveAcessarOfertasDoDia() {
		page.clicarPorTexto("Ofertas do dia");
		Assert.assertEquals("ofertas do dia", page.obterTituloDaPagina());
	}
	
	@Test
	public void deveAcessarCategoriaCelulares() {
		page.clicarPorTexto("Celulares");
		Assert.assertEquals("Celular e Smartphone", page.obterTituloDaPagina());
	}

	@Test
	public void deveAcessarCelularIphone12() {
		page.selecionar("Celulares");  // Passar o Mouse em cima, mas sem clicar
		page.clicarPorTexto("iPhone 12");
		Assert.assertEquals("iPhone 12", page.obterTituloDaPagina());
	}
	
	@Test
	public void deveAcessarCategoriaGames() {
		page.selecionarTodosOsDepartamentos();  // Passar o Mouse em cima, mas sem clicar
		page.clicarPorTexto("Games");
		Assert.assertEquals("Games", page.obterTituloDaPagina());
	}
	
	@Test
	public void devePesquisarProduto() {
		page.pesquisar("Monitor");
		Assert.assertTrue(page.obterTituloDaPagina().contains("Monitor"));
	}
	
	@Test
	public void deveTentarCriarContaSemPreencherCampos() {
		page.clicarPorTexto("Entre ou cadastre-se");
		page.clicarBotaoContinuarConta();
		
		Assert.assertEquals("O e-mail não foi digitado corretamente.", page.obterMsgErroConta());
	}
	
	@Test
	public void deveTentarFazerLoginSemPreencherCampos() {
		page.clicarPorTexto("Entre ou cadastre-se");
		page.clicarBotaoContinuarLogin();
		
		Assert.assertEquals("Insira um CPF, CNPJ ou E-mail válido.", page.obterMsgErroEmail());
		Assert.assertEquals("Insira a senha.", page.obterMsgErroSenha());
	}
	
	
}


