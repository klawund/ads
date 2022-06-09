package lista1;

import javax.swing.JOptionPane;

public class Exerc7
{
	public static void main(String[] args)
	{
		int[] numbers = new int[10];
		int search;
		int indexOf = 0;
		String message;

		for (int i = 0; i < 10; i++)
		{
			numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + (i + 1) + "º número:"));
		}

		search = Integer.parseInt(JOptionPane.showInputDialog("Insira o número a ser procurado no array: "));

		for (int i = 0; i < 10; i++)
		{
			if (numbers[i] == search)
			{
				indexOf = i;
				break;
			}
			indexOf = -1;
		}

		if (indexOf != -1)
		{
			message = "O número procurado está no índice" + indexOf + " do array";
		} else
		{
			message = "O número procurado não existe no array";
		}

		JOptionPane.showMessageDialog(null, message, "Resultado da busca", JOptionPane.INFORMATION_MESSAGE);
	}
}
