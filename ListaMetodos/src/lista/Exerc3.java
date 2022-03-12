package lista;

import javax.swing.JOptionPane;

public class Exerc3
{

	public static void main(String[] args)
	{
		double purchaseValue = readPurchaseValue();
		
		showDiscountedPurchaseValue(purchaseValue);
	}

	public static double readPurchaseValue()
	{
		double value = 0.0;

		do
		{
			value = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor da compra: "));

			if (value < 0)
			{
				JOptionPane.showMessageDialog(null, "O valor não pode ser negativo!", "Erro",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (value < 0);

		return value;
	}

	public static void showDiscountedPurchaseValue(double value)
	{
		double discountedValue = value;

		if (value > 100 && value <= 200)
		{
			discountedValue = value * 0.8;
		} else if (value > 200)
		{
			discountedValue = value * 0.7;
		}

		String message = String.format("Valor inicial: R$%.2f\n", value);
		message += String.format("Valor com desconto: R$%.2f", discountedValue);

		JOptionPane.showMessageDialog(null, message, "Valor final", JOptionPane.INFORMATION_MESSAGE);
	}

}
