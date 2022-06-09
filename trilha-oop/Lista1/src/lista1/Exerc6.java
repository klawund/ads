package lista1;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exerc6
{

	public static void main(String[] args)
	{
		double startValue = 0;
		int operation = 0;
		double endValue = 0;
		double endResult = 0;
		String option = "";

		startValue = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro número do cálculo: "));
		do
		{
			do
			{
				operation = Integer.parseInt(JOptionPane.showInputDialog("Insira a operação desejada: " 
						+ "\n 1 - Soma"
						+ "\n 2 - Subtração" 
						+ "\n 3 - Multiplicação" 
						+ "\n 4 - Divisão"));
				
				if (!Arrays.asList(1, 2, 3, 4).contains(operation))
				{
					JOptionPane.showMessageDialog(null, "Insira uma operação válida!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
				
			} while (!Arrays.asList(1, 2, 3, 4).contains(operation));
			
			do
			{
				endValue = Double.parseDouble(JOptionPane.showInputDialog("Insira o número seguinte do cálculo: "));

				if (endValue == 0 && operation == 4)
				{
					JOptionPane.showMessageDialog(null, "Não é possível dividir um número por 0!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
				
			} while (endValue == 0 && operation == 4);

			switch (operation)
			{
			case 1:
				endResult = startValue + endValue;
				break;
			case 2:
				endResult = startValue - endValue;
				break;
			case 3:
				endResult = startValue * endValue;
				break;
			case 4:
				endResult = startValue / endValue;
				break;
			}

			startValue = endResult;

			option = JOptionPane
					.showInputDialog("Deseja continuar calculando?\n Se sim digite S, se não qualquer outro caractere");
			
		} while ("S".equalsIgnoreCase(option));

		JOptionPane.showMessageDialog(null, endResult, "Resultado final", JOptionPane.INFORMATION_MESSAGE);
	}

}
