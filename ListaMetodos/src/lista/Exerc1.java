package lista;

import javax.swing.JOptionPane;

public class Exerc1
{

	public static void main(String[] args)
	{
		int userBirthYear = readUserBirthYear();
		
		showUserAgeInCurrentYear(userBirthYear);

	}

	public static int readUserBirthYear()
	{
		int year;

		do
		{
			year = Integer.parseInt(JOptionPane.showInputDialog("Insira o seu ano de nascimento:"));

			if (year <= 0)
			{
				JOptionPane.showMessageDialog(null, "Idade inválida! Insira novamente.", "Erro",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (year <= 0);

		return year;
	}

	public static void showUserAgeInCurrentYear(int userBirthYear)
	{
		JOptionPane.showMessageDialog(null, "No final de 2022 você terá: " + (2022 - userBirthYear) + " anos de idade.",
				"Idade em 2022", JOptionPane.INFORMATION_MESSAGE);
	}

}
