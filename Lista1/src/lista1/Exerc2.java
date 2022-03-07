package lista1;

import javax.swing.JOptionPane;

public class Exerc2
{

	public static void main(String[] args)
	{
		int legalAge = Integer.parseInt(JOptionPane.showInputDialog("Insira a maioridade civil do seu estado/país:"));
		int userAge = Integer.parseInt(JOptionPane.showInputDialog("Insira a sua idade:"));

		String message = userAge >= legalAge ? "Você é maior de idade." : "Você é menor de idade.";

		JOptionPane.showMessageDialog(null, message, "Maioridade civil", JOptionPane.INFORMATION_MESSAGE);
	}

}
