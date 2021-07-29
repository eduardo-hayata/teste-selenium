package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.core.BaseTest;
import selenium.core.DriverFactory;
import selenium.page.HotmailPage;

public class HotmailTest extends BaseTest {
	
	private HotmailPage page = new HotmailPage();
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://login.live.com/");
	}
	
	@Test
	@Ignore // OBS: Ainda nao consegui resolver o teste
	public void loginComEmailFaltando() {
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Insira um endereço de email, número de telefone ou nome Skype válidos.", page.obterMensagemErroEmail());
	}

	@Test
	@Ignore // OBS: Ainda nao consegui resolver o teste
	public void loginComSenhaFaltando() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);      // espera Explícita até 30 segundos
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("passwd"))); // Diz explicitamente qual "campo" deve esperar
		
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Digite a senha da sua conta da Microsoft.", page.obterMensagemErroSenha());
	}
	
	@Test
	@Ignore // OBS: Ainda nao consegui resolver o teste
	public void loginComDadosInvalidos() {
		page.escreverEmail("teste@email.com");
		page.clicarBotaoProximo();
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);      // espera Explícita até 30 segundos
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("passwd"))); // Diz explicitamente qual "campo" deve esperar
		
		page.escreverSenha("12345");
		page.clicarBotaoProximo();
		
		Assert.assertEquals("Você tentou entrar várias vezes com uma conta ou uma senha incorreta.", page.obterMensagemErroSenha());
	}
	

}
