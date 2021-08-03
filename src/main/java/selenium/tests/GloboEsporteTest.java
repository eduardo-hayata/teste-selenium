package selenium.tests;

import static selenium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.GloboEsportePage;

public class GloboEsporteTest extends BaseTest {
	
	private GloboEsportePage page = new GloboEsportePage();
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://ge.globo.com/");
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	@Test
	public void deveAcessarClassifCampBrasileiro() {
		page.clicarMenu();
		page.clicarSubMenuBrasileirao();
		
		Assert.assertTrue(getDriver().getCurrentUrl().contains("brasileirao-serie-a"));
		Assert.assertEquals("BRASILEIRÃO SÉRIE A", page.obterTituloDaPaginaCampBrasileiro());
	}
	
	@Test
	public void deveAcessarFormula1() {
		page.clicarMenu();
		page.clicarSubMenuF1();
		
		Assert.assertTrue(getDriver().getCurrentUrl().contains("formula-1"));
		Assert.assertEquals("FÓRMULA 1", page.obterTituloDaPaginaF1());
	}
	
	@Test
	public void deveAcessarTimeBarcelona() {
		page.clicarMenuEscudo();
		page.clicarTexto("Europa");
		page.clicarTimeBarcelona();
		
		Assert.assertEquals("BARCELONA", page.obterTituloDaPaginaBarcelona());
	}
	
	@Test
	public void deveAcessarG1() {
		page.clicarG1();
		Assert.assertEquals("G1", page.obterTituloDaPaginaG1());
	}
	
	@Test
	public void deveFazerPesquisa() {
		page.pesquisar("olimpiadas");
		Assert.assertEquals("olimpiadas", page.obterTextoCampoPesquisa());
	}
	
	
}



