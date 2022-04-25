package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;
import static br.ce.wcaquino.core.Propriedades.FECHAR_BROWSER;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcaquino.page.LoginPage;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	private static LoginPage loginPage = new LoginPage();
	
	@Before
	public void inicializa() {
		loginPage.acessarTelaInicial();
		loginPage.logar("marlysonalmeida@gmail.com", "Resident 5");
	}

	@After
	public void finaliza() throws IOException{
		TakesScreenshot image = (TakesScreenshot) getDriver();
		File arquivo = image.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshots" + File.separator + testName.getMethodName() + ".jpg"));
		
		if (FECHAR_BROWSER) {
			killDriver();
		}
	}	
}