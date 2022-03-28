import javax.swing.JOptionPane;

public class EntradaSaida
{

	public static int solicitaOperacao()
	{
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("Escholha a opção desejada:\n" + "1 - Soma\n"
				+ "2 - Subtração\n" + "3 - Multiplicação\n" + "4 - Divisão"));

		return operacao;
	}

	public static double solicitaNumero(String ordem)
	{
		double num = Double.parseDouble(JOptionPane.showInputDialog("Informe o " + ordem + " número:"));

		return num;
	}

	public static void mostraResultado(double resultado, int operacao)
	{
		String op = "";

		switch (operacao)
		{
		case 1:
			op = "soma";
			break;
		case 2:
			op = "subtração";
			break;
		case 3:
			op = "multiplicação";
			break;
		default:
			op = "divisão";
			break;
		}

		JOptionPane.showMessageDialog(null, "O resultado da " + op + " é: " + resultado);
	}

}
