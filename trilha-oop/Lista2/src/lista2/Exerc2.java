package lista2;

import javax.swing.JOptionPane;

public class Exerc2
{

	public static void main(String[] args)
	{
		int gradeQuantity = 4;
		double[] grades = new double[gradeQuantity];
		double gradesSum = 0;

		double finalGrade;
		String concept = "";

		for (int i = 0; i < 4; i++)
		{
			grades[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª nota do aluno:"));
			
			while (grades[i] < 0.0 || grades[i] > 10.0)
			{
				JOptionPane.showMessageDialog(null, "A nota inserida não pode ser menor que 0 nem maior que 10", "Nota inválida", JOptionPane.WARNING_MESSAGE);
				grades[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª nota do aluno:"));
			}
			gradesSum += grades[i];
		}

		finalGrade = gradesSum / gradeQuantity;

		if (finalGrade < 7.0)
		{
			concept = "Conceito D";
		}
		else if (finalGrade < 8.0)
		{
			concept = "Conceito C";
		}
		else if (finalGrade < 9)
		{
			concept = "Conceito B";
		}
		else if (finalGrade >= 9.0)
		{
			concept = "Conceito A";
		}

		JOptionPane.showMessageDialog(null,
				String.format("A média aritmética do aluno é %.2f e ele se enquadra no %s", finalGrade, concept),
				"Média final", JOptionPane.INFORMATION_MESSAGE);
	}

}
