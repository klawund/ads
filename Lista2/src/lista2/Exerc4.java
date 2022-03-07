package lista2;

import javax.swing.JOptionPane;

public class Exerc4
{

	public static void main(String[] args)
	{
		double brass = Double.parseDouble(JOptionPane.showInputDialog("Insira a quantidade de latão a ser forjado:"));
		
		double zinc = brass * 0.3;
		double copper = brass * 0.7;
		
		String message = String.format("Para fabricar %.2fkg de latão serão necessários:\n", brass)
				+ String.format("%.2fkg de zinco\n", zinc)
				+ String.format("%.2fkg de cobre", copper);

		JOptionPane.showMessageDialog(null, message, "Fabricação de latão", JOptionPane.INFORMATION_MESSAGE);
	}

}
