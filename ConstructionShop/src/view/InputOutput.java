package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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

			ok = ok && quantity >= min && quantity <= max;

			if (ok)
			{
				break;
			}

			InputOutput.showError("Quantidade inválida!");
		}
		while (!ok);
		return quantity;
	}
}
