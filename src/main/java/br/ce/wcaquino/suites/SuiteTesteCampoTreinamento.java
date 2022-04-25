package br.ce.wcaquino.suites;

import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.test.TesteAlert;
import br.ce.wcaquino.test.TesteCadastro;
import br.ce.wcaquino.test.TesteCampoTreinamento;
import br.ce.wcaquino.test.TesteFramesEJanelas;
import br.ce.wcaquino.test.TesteRegrasCadastro;
import br.ce.wcaquino.test.TesteSincronismo;

@RunWith(Suite.class)
@SuiteClasses({
		TesteCadastro.class,
		TesteRegrasCadastro.class,
		TesteCampoTreinamento.class,
		TesteFramesEJanelas.class,
		TesteAlert.class,
		TesteCampoTreinamento.class,
		TesteSincronismo.class
})
public class SuiteTesteCampoTreinamento {

	@AfterClass
	public static void finalizaClasses() {
		killDriver();
	}

}