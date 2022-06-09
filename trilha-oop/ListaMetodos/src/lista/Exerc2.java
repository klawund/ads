package lista;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exerc2
{

	public static void main(String[] args)
	{
		double[] studentGrades = readStudentGrades();
		int gradingSystem = readGradingSystem();

		double finalGrade = 0.0;

		switch (gradingSystem)
		{
		case 1:
			finalGrade = calculateArithmeticAverage(studentGrades);
			break;
		case 2:
			double[] studentGradeWeights = readGradeWeights();
			finalGrade = calculateWeightedAverage(studentGrades, studentGradeWeights);
			break;
		}

		showStudentApproval(finalGrade);
	}

	public static double[] readStudentGrades()
	{
		double[] grades = new double[3];

		for (int i = 0; i < 3; i++)
		{
			do
			{
				grades[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª nota:"));

				if (grades[i] < 0 || grades[i] > 10)
				{
					JOptionPane.showMessageDialog(null, "Nota inválida! Insira novamente.", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			} while (grades[i] < 0 || grades[i] > 10);
		}

		return grades;
	}

	public static int readGradingSystem()
	{
		int option;

		do
		{
			option = Integer.parseInt(JOptionPane
					.showInputDialog("Insira o modo de geração da média:\n1 - Média aritmética\n2 - Média ponderada"));

			if (!Arrays.asList(1, 2).contains(option))
			{
				JOptionPane.showMessageDialog(null, "Opção inválida! Insira novamente", "Erro",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (!Arrays.asList(1, 2).contains(option));

		return option;
	}

	public static double[] readGradeWeights()
	{
		double[] weights = new double[3];
		double weightAggregate = 0.0;
		boolean validWeight;
		boolean validWeightAggregate;

		for (int i = 0; i < 3; i++)
		{
			do
			{
				weights[i] = Double.parseDouble(
						JOptionPane.showInputDialog("Insira o peso para a " + (i + 1) + "ª nota:\nExemplo: 30% = 0.3"));

				validWeight = weights[i] > 0 && weights[i] < 1;
				validWeightAggregate = weightAggregate + weights[i] <= 1;

				if (!validWeight)
				{
					JOptionPane.showMessageDialog(null, "Peso inválido!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
				if (!validWeightAggregate)
				{
					JOptionPane.showMessageDialog(null,
							"Com a soma desse peso o agregado é inválido!\nAgregado atual: " + weightAggregate
									+ "\nPeso máximo a ser recebido: " + (1 - weightAggregate),
							"Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (!validWeight || !validWeightAggregate);
			weightAggregate += weights[i];
		}

		return weights;
	}

	public static double calculateArithmeticAverage(double[] grades)
	{
		double gradesSum = 0.0;

		for (int i = 0; i < grades.length; i++)
		{
			gradesSum += grades[i];
		}
		return gradesSum / grades.length;
	}

	public static double calculateWeightedAverage(double[] grades, double[] weights)
	{
		double grade = 0.0;

		for (int i = 0; i < grades.length; i++)
		{
			grade += grades[i] * weights[i];
		}

		return grade;
	}

	public static void showStudentApproval(double finalGrade)
	{
		String message = "Você foi ";
		message += finalGrade >= 7 ? "aprovado." : "reprovado.";
		message += "\n";
		message += String.format("Média: %.2f", finalGrade);
		
		JOptionPane.showMessageDialog(null, message, "Resultado",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
