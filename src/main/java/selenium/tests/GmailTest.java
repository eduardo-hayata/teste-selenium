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
		DriverFactory.getDriver().get("https://accounts.google.com/signin/v2/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=pt-BR&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	
	@Test
	public void loginComEmailFaltando() {
		page.clicarBotaoProximo();
		Assert.assertEquals("Digite um e-mail ou número de telefone", page.obterMensagemErroEmail());
	}
	
	@Test
	@Ignore
	public void loginComSenhaFaltando() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Digite uma senha", page.obterMensagemErroSenha());
		
		// OBS: Não foi possivel fazer o teste. Aparece a seguinte mensagem:
		// "Não foi possivel fazer o login. Este navegador ou app pode não ser seguro..."
	}
	
	@Test
	@Ignore
	public void loginComDadosInvalidos() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		
		page.escreverSenha("12345");
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Senha incorreta. Tente novamente ou clique em \"Esqueceu a senha?\" para redefini-la.", page.obterMensagemErroSenha());
		
		// OBS: Não foi possivel fazer o teste. Aparece a seguinte mensagem:
		// "Não foi possivel fazer o login. Este navegador ou app pode não ser seguro..."
	}
}

