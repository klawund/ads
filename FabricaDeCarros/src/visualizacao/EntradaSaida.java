package visualizacao;

import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Carro;

public class EntradaSaida
{
	public static String lerAtributoCarro(String atributo)
	{
		return JOptionPane.showInputDialog("Insira " + atributo + " do carro:");
	}

	public static Carro lerCarroParaVender(Carro[] carros)
	{
		JComboBox selectCarros = new JComboBox(carros);

		JOptionPane.showConfirmDialog(null, selectCarros, "Selecione o carro a ser vendido",
			JOptionPane.OK_CANCEL_OPTION);

		return (Carro) selectCarros.getSelectedItem();
	}

	public static int lerQuantidadeDeCarros()
	{
		return Integer.parseInt(
			JOptionPane.showInputDialog("Insira a quantidade de carros a ser fabricada:"));
	}

	public static int lerOpcaoMenu()
	{
		int opcao;

		StringBuilder mensagem = new StringBuilder();

		mensagem.append("Selecione uma das opções:\n\n");
		mensagem.append("1 - Fabricar carros\n");
		mensagem.append("2 - Vender um carro\n");
		mensagem.append("3 - Sair");

		do
		{
			opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString()));

			if (!Arrays.asList(1, 2, 3).contains(opcao))
			{
				exibirMensagemDeErro("Opção inválida!");
			}
		}
		while (!Arrays.asList(1, 2, 3).contains(opcao));

		return opcao;
	}

	public static void exibirMensagemDeErro(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.WARNING_MESSAGE);
	}

	public static void exibirResumoCarros(String resumo)
	{
		JOptionPane.showMessageDialog(null, resumo, "Resumo de carros fabricados:", JOptionPane.INFORMATION_MESSAGE);
	}

}
