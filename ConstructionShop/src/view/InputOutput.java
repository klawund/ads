package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class InputOutput
{
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
}
