package visualizacao;

import java.util.Arrays;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Conta;

public class EntradaSaida
{
	public static int lerOpcaoMenu()
	{
		String[] opcoes = {"Criar conta", "Ver saldo", "Ver informações da conta", "Fazer depósito",
			"Fazer saque", "Gerar extrato completo", "Gerar extrato de saques",
			"Gerar extrato de depósitos", "Sair"};

		JComboBox menu = new JComboBox(opcoes);
		int okCancel;
		do
		{
			okCancel = JOptionPane.showConfirmDialog(null, menu, "Escolha uma opção:",
				JOptionPane.OK_CANCEL_OPTION);
		}
		while (okCancel != 0);

		return menu.getSelectedIndex() + 1;
	}

	public static void exibirErro(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.WARNING_MESSAGE);
	}

	public static String solicitarTitularDaConta()
	{
		return JOptionPane.showInputDialog("Insira o nome do titular da conta: ");
	}

	public static int solicitarTipoDaConta()
	{
		String[] tipos = {"Poupança", "Corrente"};
		return JOptionPane.showOptionDialog(null, "Informe o tipo da conta:", "Tipo da conta",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[1]) + 1;
	}

	public static double solicitarInformacoesDeposito()
	{
		double valor;
		do
		{
			valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado:"));

			if (valor <= 0)
			{
				exibirErro("O valor precisa ser positivo!");
			}
		}
		while (valor <= 0);

		return valor;
	}

	public static double solicitarInformacoesSaque(Conta conta)
	{
		double valor;
		boolean ok;

		do
		{
			valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser sacado:"));

			if (valor < 0)
			{
				exibirErro("Não é possível sacar um valor negativo!");
			}
			else if (conta.getSaldo() - valor < -1000)
			{
				exibirErro("A sua conta não pode ficar mais de R$1.000,00 negativos!");
			}
		}
		while (valor < 0 || conta.getSaldo() - valor < -1000);

		return valor;
	}

	public static void exibirSaldo(Conta conta)
	{
		JOptionPane.showMessageDialog(null, "Seu saldo é:\n\n" + conta.gerarSaldo(), "Saldo",
			JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirDadosDaConta(Conta conta)
	{
		JOptionPane.showMessageDialog(null, "Dados da conta:\n\n" + conta.gerarDadosDaConta(), "Dados",
			JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirExtratoCompleto(Conta conta)
	{
		String mensagem =
			"Extrato completo:\n\n" + conta.gerarExtrato() + "--------------------------\nSaldo: "
				+ conta.gerarSaldo();
		JOptionPane.showMessageDialog(null, mensagem, "Extrato", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirExtratoDeDepositos(Conta conta)
	{
		JOptionPane.showMessageDialog(null, "Extrato de depósitos:\n\n" + conta.gerarExtratoDepositos(),
			"Extrato de depósitos", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirExtratoDeSaques(Conta conta)
	{
		JOptionPane.showMessageDialog(null, "Extrato de saques:\n\n" + conta.gerarExtratoSaques(),
			"Extrato de saques", JOptionPane.INFORMATION_MESSAGE);
	}
}
