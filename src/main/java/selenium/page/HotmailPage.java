package selenium.page;

import selenium.core.BasePage;

public class HotmailPage extends BasePage {

	public void escreverEmail(String email) {
		dsl.escrever("//input[@name='loginfmt']", email);
	}
	
	public void escreverSenha(String senha) {
		dsl.escrever("//input[@name='passwd']", senha);
	}
	
	public void clicarBotaoProximo() {
		dsl.clicarBotao("//input[@type='submit']");
	}

	public String obterMensagemErroEmail() {
		return dsl.obterMensagemErro("//div[@class='col-md-24 error ext-error']");
	}
	
	public String obterMensagemErroSenha() {
		return dsl.obterMensagemErro("//div[@id='passwordError'");
	}




	

}
