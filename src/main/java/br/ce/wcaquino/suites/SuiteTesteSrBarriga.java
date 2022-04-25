package br.ce.wcaquino.suites;

import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.test.ContaTest;
import br.ce.wcaquino.test.MovimentacaoTest;
import br.ce.wcaquino.test.ResumoTest;
import br.ce.wcaquino.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	ContaTest.class, 
	MovimentacaoTest.class,
	SaldoTest.class,
	ResumoTest.class	
})
public class SuiteTesteSrBarriga {

	@AfterClass
	public static void finalizaClasses() {
		killDriver();
	}
}