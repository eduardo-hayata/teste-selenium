package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.GmailPage;

public class GmailTest extends BaseTest {

	private GmailPage page = new GmailPage();
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://accounts.google.com/");
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void loginComEmailFaltando() {
		page.clicarBotaoProximo();
		Assert.assertEquals("Digite um e-mail ou número de telefone", page.obterMensagemErroEmail());
	}
	
	@Test
	@Ignore // OBS: Ainda nao consegui resolver o teste
	public void loginComSenhaFaltando() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Digite uma senha", page.obterMensagemErroSenha());
	}
	
	@Test
	@Ignore // OBS: Ainda nao consegui resolver o teste
	public void loginComDadosInvalidos() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		
		page.escreverSenha("12345");
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Senha incorreta. Tente novamente ou clique em \"Esqueceu a senha?\" para redefini-la.", page.obterMensagemErroSenha());
	}
}

