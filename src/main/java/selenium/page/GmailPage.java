package selenium.page;

import selenium.core.BasePage;

public class GmailPage extends BasePage {

	public void escreverEmail(String email) {
		dsl.escrever("//input[@name='identifier']", email);
	}
	
	public void escreverSenha(String senha) {
		dsl.escrever("//input[@name='password']", senha);
	}

	public void clicarBotaoProximo() {
		dsl.clicarBotao("//span[.='Próxima']");
	}

	public String obterMensagemErroEmail() {
		return dsl.obterMensagemErro("//div[@class='o6cuMc']");
	}

	public String obterMensagemErroSenha() {
		return dsl.obterMensagemErro("//div[@jsname='B34EJ']/span");
	}

	
	

}
