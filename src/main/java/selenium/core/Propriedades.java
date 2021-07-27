package selenium.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;   // FALSE: Não vai fechar o Browser a cada execução de teste
    											   // TRUE: Vai fechar o Browser a cada execução de teste
	
	public static Browsers browser = Browsers.CHROME;  // Define o navegador padrão para executar o teste
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
