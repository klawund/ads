package lista1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Exerc4
{

	public static void main(String[] args)
	{
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro número do range:"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo número do range:"));

		int smallestNumber;
		int biggestNumber;
		int sum;
		List<Integer> range = new ArrayList<>();

		if (n1 > n2)
		{
			smallestNumber = n2;
			biggestNumber = n1;
		} else
		{
			smallestNumber = n1;
			biggestNumber = n2;
		}

		for (int i = smallestNumber + 1; i < biggestNumber; i++)
		{
			range.add(i);
		}

		sum = range.stream().filter(n -> n % 2 == 0).reduce((n3, n4) -> n3 + n4).get();

		JOptionPane.showMessageDialog(null, "A soma dos números pares no range passado é " + sum, "Soma total",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
