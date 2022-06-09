package lista2;

import javax.swing.JOptionPane;

public class Exerc1
{

	public static void main(String[] args)
	{
		int arrSize = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do vetor: "));
		int[] values = new int[arrSize];
		int negatives = 0;

		for (int i = 0; i < arrSize; i++)
		{
			values[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o " + (i + 1) + "º do vetor:"));

			if (values[i] < 0)
			{
				negatives++;
			}
		}

		JOptionPane.showMessageDialog(null, "Existem " + negatives + " números negativos no vetor informado",
				"Quantidade de números negativos", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
