package controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Abertura;
import modelo.Casa;
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
			case 1:
				JOptionPane.showMessageDialog(null, "Movimentar portas ou janelas");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Ver informações da casa");
				break;
			}
		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}

}
