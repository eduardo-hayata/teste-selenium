package selenium.page;
import static selenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class GooglePage {
	
	public void pesquisar(String texto) {
		getDriver().findElement(By.xpath("//input[@title='Pesquisar']")).clear();  // limpa o campo, caso tenha algo escrito nele
		getDriver().findElement(By.xpath("//input[@title='Pesquisar']")).sendKeys(texto);
	}

	public void clicarForaCaixa() {
		getDriver().findElement(By.xpath("//div[@class='gb_pa gb_Zd gb_Va gb_Hc']")).click();
	}
	
	public void clicarBotao(String botao) {
		getDriver().findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='"+botao+"']")).click();
	}
	
	public String obterTextoCampoPesquisa() {
		return getDriver().findElement(By.xpath("//div[@jsname='aJyGR']/..//input")).getAttribute("value");
	}


}
