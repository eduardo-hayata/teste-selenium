package selenium.page;
import selenium.core.BasePage;

public class GooglePage extends BasePage {
	
	public void pesquisar(String texto) {
		dsl.escrever("//input[@title='Pesquisar']", texto);
	}

	public void clicarForaCaixa() {
		dsl.clicarForaCaixa("//div[@class='gb_pa gb_Zd gb_Va gb_Hc']");
	}
	
	public void clicarBotao(String botao) {
		dsl.clicarBotao("//div[@class='FPdoLc lJ9FBc']//input[@value='"+botao+"']");
	}
	
	public String obterTextoCampoPesquisa() {
		return dsl.obterTexto("//div[@jsname='aJyGR']/..//input");
	}



}
