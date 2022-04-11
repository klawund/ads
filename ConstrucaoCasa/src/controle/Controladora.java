package controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Abertura;
import modelo.Casa;
import modelo.Janela;
import modelo.Porta;
import visualizacao.EntradaSaida;

public class Controladora
{

	private Casa casa;

	public void exibeMenu()
	{
		int opcao;

		do
		{
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao)
			{
			case 0:
				this.casa = new Casa();
				
				String descricao = EntradaSaida.solicitaDescricao("casa", 0);
				String cor = EntradaSaida.solicitaCor();
				int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
				int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");
				
				List<Abertura> listaDePortas = new ArrayList<>();

				for (int i = 0; i < qtdePortas; i++)
				{
					Porta porta = new Porta();
					porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1)));
					porta.setEstado(EntradaSaida.solicitaEstado("porta"));
					listaDePortas.add(porta);
				}

				List<Abertura> listaDeJanelas = new ArrayList<>();

				for (int i = 0; i < qtdeJanelas; i++)
				{
					Janela janela = new Janela();
					janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i + 1)));
					janela.setEstado(EntradaSaida.solicitaEstado("janela"));
					listaDeJanelas.add(janela);
				}
				
				this.casa.constroiCasa(descricao, cor, listaDeJanelas, listaDePortas);
				break;
			case 1:
				
				if (this.casa == null)
				{
					EntradaSaida.exibeErroDeCasaNaoConstruida();
					break;
				}
				
				String tipoDeAbertura = EntradaSaida.solicitaTipoabertura();

				List<Abertura> listaDeAberturas = new ArrayList<>();

				if ("porta".equals(tipoDeAbertura))
				{
					listaDeAberturas = this.casa.getListaDePortas();
				}
				else
				{
					listaDeAberturas = this.casa.getListaDeJanelas();
				}

				int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
				int novoEstado = 0;

				if (posicao != -1)
				{
					novoEstado = EntradaSaida.solicitaEstado(tipoDeAbertura);
					Abertura abertura = this.casa.retornaAbertura(posicao, tipoDeAbertura);
					this.casa.moverAbertura(abertura, novoEstado);
				}
				else
				{
					EntradaSaida.exibeMsgAbertura();
				}
				break;
			case 2:
				if (this.casa == null)
				{
					EntradaSaida.exibeErroDeCasaNaoConstruida();
					break;
				}
				
				String informacoes = this.casa.geraInfoCasa();
				EntradaSaida.exibeInfoCasa(informacoes);
				break;
			}
		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}

}
