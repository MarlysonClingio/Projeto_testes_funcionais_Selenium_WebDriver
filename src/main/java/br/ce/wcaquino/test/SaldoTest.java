package br.ce.wcaquino.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.HomePage;

public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage(); 

	@Test
	public void testSaldoConta() {
		assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
	
	@After
	public void sair() {
		homePage.clicarLink("Sair");
	}
}