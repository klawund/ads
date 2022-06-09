package visualizacao;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Abertura;

public class EntradaSaida
{

	public static int solicitaOpcao()
	{
		String[] opcoes = {"Construir casa", "Movimentar portas ou janelas", "Ver informações da casa",
			"Sair do programa"};
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada",
			JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPrograma()
	{
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}

	public static String solicitaDescricao(String descricao, int ordem)
	{
		if (ordem == 0)
		{
			return JOptionPane.showInputDialog("Informe a descrição da " + descricao);
		}
		else
		{
			return JOptionPane.showInputDialog("Informe a descrição da " + ordem + "ª " + descricao);
		}
	}

	public static String solicitaCor()
	{
		return JOptionPane.showInputDialog("Informe a cor da casa");
	}

	public static int solicitaQtdeAberturas(String abertura)
	{
		int q = 0;

		do
		{
			q = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de " + abertura));

			if (q <= 0)
			{
				JOptionPane.showMessageDialog(null,
					"O número de " + abertura + " precisa ser maior que zero!", "Erro",
					JOptionPane.WARNING_MESSAGE);
			}
		}
		while (q <= 0);

		return q;
	}

	public static int solicitaEstado(String tipoDeAbertura)
	{
		String[] opcoes = {"Fechada", "Aberta"};

		return JOptionPane.showOptionDialog(null, "Informe o estado da " + tipoDeAbertura, "Estado",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
	}

	public static String solicitaTipoabertura()
	{
		String[] opcoes = {"Porta", "Janela"};

		int tipoAbertura = JOptionPane.showOptionDialog(null,
			"Informe qual tipo de abertura deseja mover", "Mover abertura", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

		if (tipoAbertura == 0)
		{
			return "porta";
		}

		return "janela";
	}

	public static int solicitaAberturaMover(List<Abertura> listaDeAberturas)
	{
		String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
		tipoAbertura = tipoAbertura.replaceAll("modelo.", "");
		int qtdeAberturas = listaDeAberturas.size();
		String[] descricoesAberturas = new String[qtdeAberturas];

		for (int i = 0; i < qtdeAberturas; i++)
		{
			descricoesAberturas[i] = listaDeAberturas.get(i).getDescricao();
		}

		String msg = "Escolha a " + tipoAbertura + " a ser movimentada";
		JComboBox exibicaoAberturas = new JComboBox(descricoesAberturas);
		int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoAberturas, msg,
			JOptionPane.OK_CANCEL_OPTION);

		if (confirmacao == 0)
		{
			return exibicaoAberturas.getSelectedIndex();
		}
		return -1;
	}

	public static void exibeMsgAbertura()
	{
		JOptionPane.showMessageDialog(null, "Nenhuma abertura será movimentada");
	}

	public static void exibeInfoCasa(String informacoes)
	{
		JOptionPane.showMessageDialog(null, informacoes, "Informações da casa",
			JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibeErroDeCasaNaoConstruida()
	{
		JOptionPane.showMessageDialog(null,
			"Não é possível acessar essa opção pois a casa ainda não foi construída!", "Erro",
			JOptionPane.WARNING_MESSAGE);
	}

}
