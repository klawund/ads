package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Shop;

public class InputOutput
{
	public static final String DEFAULT_ERROR_MESSAGE_TITLE = "Erro";

	public static void showError(String message)
	{
		JOptionPane.showMessageDialog(null, message, DEFAULT_ERROR_MESSAGE_TITLE,
			JOptionPane.WARNING_MESSAGE);
	}

	public static void showMessage(String message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static String readInfo(String message)
	{
		return JOptionPane.showInputDialog(message);
	}

	public static <T> Object readOption(T[] options, String title, boolean getIndex)
	{
		JComboBox<T> menu = new JComboBox<>(options);
		int ok;

		do
		{
			ok = JOptionPane.showConfirmDialog(null, menu, title, JOptionPane.OK_CANCEL_OPTION);
		}
		while (ok != 0);

		if (getIndex)
		{
			return menu.getSelectedIndex();
		}
		return menu.getSelectedItem();
	}

	public static int readSafeInteger(String message, int min, int max)
	{
		int quantity = min;
		boolean ok = true;

		do
		{
			String quantityStr = readInfo(message);

			try
			{
				quantity = Integer.parseInt(quantityStr);
			}
			catch (Exception e)
			{
				ok = false;
			}

			if (min < 0)
			{
				ok = ok && quantity <= max;
			}
			else if (max < 0)
			{
				ok = ok && quantity >= min;
			}
			else
			{
				ok = ok && quantity >= min && quantity <= max;
			}

			if (ok)
			{
				break;
			}

			InputOutput.showError("Quantidade inválida!");
		}
		while (true);
		return quantity;
	}

	public static String readProductCode(Shop shop)
	{
		String code;
		do
		{
			code = InputOutput.readInfo("Insira o código do produto:");

			if (shop.hasProduct(code))
			{
				InputOutput.showError("Já existe um produto cadastrado com esse código!");
			}
		}
		while (shop.hasProduct(code));
		return code;
	}

	public static double readProductPrice()
	{
		String priceStr;
		double price = 0.0;

		boolean wentWrong = false;
		do
		{
			priceStr = InputOutput.readInfo("Insira o valor do produto (R$00.00):");

			try
			{
				price = Double.parseDouble(priceStr);
			}
			catch (Exception e)
			{
				InputOutput.showError("Dado inválido!");
				wentWrong = true;
			}
		}
		while (wentWrong);
		return price;
	}
}
