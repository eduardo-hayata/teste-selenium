package selenium.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;   // FALSE: N�o vai fechar o Browser a cada execu��o de teste
    											   // TRUE: Vai fechar o Browser a cada execu��o de teste
	
	public static Browsers browser = Browsers.CHROME;  // Define o navegador padr�o para executar o teste
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
