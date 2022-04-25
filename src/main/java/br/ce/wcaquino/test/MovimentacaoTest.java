package br.ce.wcaquino.test;

import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.MenuPage;
import br.ce.wcaquino.page.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private Date datafutura = obterDataComDiferencaDias(10);
	private Date data = new Date();
	
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(data));
		movimentacaoPage.setDataPagamento(obterDataFormatada(datafutura));
		movimentacaoPage.setDescricao("Movimentação para teste");
		movimentacaoPage.setInteressado("Marlyson Clingio Almeida Coutinho");
		movimentacaoPage.setValor("5000");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
	
	
	@Test
	public void testCamposObrigatoriosMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movimentacaoPage.salvar();
		List<String> erros = movimentacaoPage.obterErros();
	
		assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		assertEquals(6, erros.size());
	}
	
	
	@Test
	public void testInserirMovimentacaoDataFutura() {
		menuPage.acessarTelaInserirMovimentacao();
			
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(datafutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(data));
		movimentacaoPage.setDescricao("Movimentação para teste");
		movimentacaoPage.setInteressado("Marlyson Clingio Almeida Coutinho");
		movimentacaoPage.setValor("5000");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		
		assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		assertEquals(1, erros.size());
	}
	
	@After
	public void sair() {
		movimentacaoPage.clicarLink("Sair");
	}
	
}