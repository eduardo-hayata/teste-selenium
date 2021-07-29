package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.GooglePage;

public class GoogleTest extends BaseTest {

	private GooglePage page = new GooglePage();

	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("http://www.google.com");
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void acessarGoogle() {
		Assert.assertEquals("Google", DriverFactory.getDriver().getTitle());
	}
	
	@Test
	public void fazerPesquisa() {
		page.pesquisar("Selenium");
		page.clicarForaCaixa();
		page.clicarBotao("Pesquisa Google");
		
		Assert.assertEquals("Selenium", page.obterTextoCampoPesquisa());
	}
	
	@Test
	public void fazerPesquisaEstouComSorte() {
		page.pesquisar("Selenium");
		page.clicarForaCaixa();
		page.clicarBotao("Estou com sorte");
		
		Assert.assertEquals("https://www.selenium.dev/", DriverFactory.getDriver().getCurrentUrl());
	}
	
}


