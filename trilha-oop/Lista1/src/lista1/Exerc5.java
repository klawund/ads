package lista1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Exerc5
{

	public static void main(String[] args)
	{
		List<Integer> values = new ArrayList<>();

		while (values.size() < 10)
		{
			int value = 0;

			do
			{
				value = Integer.parseInt(JOptionPane.showInputDialog("Valor nº" + (values.size() + 1) + ": "));
			} while (value < 0);

			values.add(value);
		}

		List<Integer> pairValues = values.stream().filter(n1 -> n1 % 2 == 0).collect(Collectors.toList());
		List<Integer> oddValues = new ArrayList<>(values);

		oddValues.removeAll(pairValues);

		JOptionPane.showMessageDialog(null,
				"Número de valores par: " + pairValues.size() + "\n Soma dos valores par: "
						+ pairValues.stream().reduce((n1, n2) -> n1 + n2).get() + "\n Número de valores ímpar: "
						+ oddValues.size() + "\n Soma dos valores ímpar: "
						+ oddValues.stream().reduce((n1, n2) -> n1 + n2).get(),
				"Menu", JOptionPane.INFORMATION_MESSAGE);
	}
}
