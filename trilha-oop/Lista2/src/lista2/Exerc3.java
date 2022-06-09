package lista2;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exerc3
{

	public static void main(String[] args)
	{
		int number = Integer.parseInt(JOptionPane.showInputDialog("Insira um número inteiro:"));
		int option;
		boolean optionValidation;

		String menuDescription = "1 - Verificar se o número é múltiplo de algum outro número\n"
				+ "2 - Verificar se o número é par\n" 
				+ "3 - Verificar se o número está entre 0 e 1000\n" 
				+ "4 - Sair";

		do
		{
			do
			{
				option = Integer.parseInt(JOptionPane.showInputDialog(menuDescription));
				optionValidation = !Arrays.asList(1, 2, 3, 4).contains(option);

				if (optionValidation)
				{
					JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (optionValidation);

			switch (option)
			{
			case 1:
				int multiple = Integer.parseInt(JOptionPane.showInputDialog(String.format("Qual número você verificar se %d é múltiplo de?", number)));
				
				JOptionPane.showMessageDialog(null, String.format("O número %d %sé múltiplo de %d", number, number % multiple == 0 ? "" : "não ", multiple));
				break;
			case 2:
				JOptionPane.showMessageDialog(null,
						String.format("O número %d %sé par", number, number % 2 != 0 ? "não " : ""), "Par ou ímpar",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,
						String.format("O número %d %sestá entre 0 e 1000", number,
								number > 0 && number < 1000 ? "" : "não "),
						"Par ou ímpar", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				System.exit(0);
			}
		} while (option != 4);

	}

}
