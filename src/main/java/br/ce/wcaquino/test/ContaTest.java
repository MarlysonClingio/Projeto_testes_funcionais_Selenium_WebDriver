package br.ce.wcaquino.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.ContasPage;
import br.ce.wcaquino.page.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contaPage.setName("Conta para teste");
		contaPage.salvar();
		assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemSucesso());
	}
	

	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contaPage.clicarAlterarConta("Conta para alterar");
		
		contaPage.setName("Conta alterada");
		contaPage.salvar();
		assertEquals("Conta alterada com sucesso!", contaPage.obterMensagemSucesso());
	}

	
	@Test
	public void testInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contaPage.setName("Conta mesmo nome");
		contaPage.salvar();
		assertEquals("Já existe uma conta com esse nome!", contaPage.obterMensagemErro());
	}
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contaPage.clicarExcluirConta("Conta com movimentacao");
		assertEquals("Conta em uso na movimentações", contaPage.obterMensagemErro());
	}
	
	@After
	public void sair() {
		contaPage.clicarLink("Home");
		contaPage.clicarLink("reset");
		contaPage.clicarLink("Sair");
	}
}