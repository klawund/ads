package introducaoJava;

import javax.swing.JOptionPane;

public class Main
{

	public static void main(String[] args)
	{
		int[] valores = new int[10];

		for (int i = 0; i < 10; i++)
		{
			int valor = 0;
			do
			{
				valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i + 1) + "º valor:"));
			} while (valor <= 0);
			valores[i] = valor;
		}

		String repetir;

		do
		{
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja ver?"
					+ "\n 1 - Todos os valores" + "\n 2 - Somente o primeiro " + "\n 3 - Somente o último valor"
					+ "\n 4 - Ver os valores pares" + "\n 5 - Ver o maior valor no vetor"));

			switch (opcao)
			{
			case 1:
				for (int i = 0; i < 10; i++)
				{
					JOptionPane.showMessageDialog(null, valores[i], "Valor nº" + (i + 1),
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null, valores[0], "Primeiro valor", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, valores[9], "Último valor", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				String valoresPares = "";

				for (int i = 0; i < 10; i++)
				{
					if (valores[i] % 2 == 0)
					{
						if (valoresPares != "")
						{
							valoresPares += ", ";
						}
						valoresPares += valores[i];
					}
				}
				JOptionPane.showMessageDialog(null, valoresPares, "Valores pares", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 5:
				int maiorValor = 0;

				for (int i = 0; i < 10; i++)
				{
					maiorValor = valores[i] > maiorValor ? valores[i] : maiorValor;
				}

				JOptionPane.showMessageDialog(null, maiorValor, "Maior valor", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.WARNING_MESSAGE);
				break;
			}

			repetir = JOptionPane
					.showInputDialog("Deseja voltar ao menu?" + "\n Digite S para sim ou outro caractere para não");
		} while ("S".equalsIgnoreCase(repetir));
	}

}
