package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
	
	@Test
	@Ignore
	public void deveRemoverProdutoDoCarrinho() throws InterruptedException {
		page.selecionar("Celulares");
		page.clicarPorTexto("iPhone 12");
		
		Thread.sleep(1000);  // espera x segundos
		page.rolarTelaPraBaixo();  // Scroll na Tela
		
		page.clicarPorTitulo("iPhone 12  Apple 64GB Preto 6,1” Câm. Dupla 12MP");  // Seleciona um produto específico
		page.rolarTelaPraBaixo();
		page.addProdutoNaSacola();
		
		Thread.sleep(1000);  // espera x segundos
		page.selecionarSemGarantia();
		
		page.rolarTelaPraBaixo();
		page.clicarPorTexto("continuar");
		
		Thread.sleep(2000);  // espera x segundos
		page.excluirProdutoSacola();

		//System.out.println(page.obterMensagemSacolaVazia());
		Assert.assertEquals("Sua sacola está vazia", page.obterMensagemSacolaVazia());  // TBD: Ainda não consegui pegar a MSG correta
	}
	
	
}


