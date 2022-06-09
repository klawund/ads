package lista1;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Exerc3
{

	public static void main(String[] args)
	{
		Set<Double> numbers = new HashSet<>();
		double currentNumber;

		while (numbers.size() < 3)
		{
			currentNumber = Double.parseDouble(JOptionPane.showInputDialog("Insira um número:"));

			while (numbers.contains(currentNumber))
			{
				JOptionPane.showMessageDialog(null, "Você não pode inserir números iguais!", "Erro",
						JOptionPane.ERROR_MESSAGE);

				currentNumber = Double.parseDouble(JOptionPane.showInputDialog("Insira um número:"));
			}
			numbers.add(currentNumber);
		}

		double smallestNumber = numbers.stream().min(Double::compare).get();

		JOptionPane.showMessageDialog(null, "O menor númeor inserido foi: " + smallestNumber, "Menor número inserido",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
