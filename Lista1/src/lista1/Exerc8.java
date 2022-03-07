package lista1;

import javax.swing.JOptionPane;

public class Exerc8
{
	public static void main(String[] args)
	{
		int months = 6;
		int weeks = 4;
		
		double[][] semesterSales = new double[months][weeks];
		double[] monthlyResults = new double[months];
		
		double semesterResult = 0;
		
		for (int i = 0; i < months; i++)
		{
			double monthlyResult = 0;
			
			for (int j = 0; j < weeks; j++)
			{
				semesterSales[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Insira o resultado da " + (j + 1) + "ª semana do " + (i + 1) + "º mês: "));
				monthlyResult += semesterSales[i][j];
			}
			monthlyResults[i] = monthlyResult;
			semesterResult += monthlyResult;
		}
		
		String monthlyResultsDescription = "";
		String semesterResultDescription = String.format("O resultado do semestre foi: R$%.2f", semesterResult);
		
		for (int i = 0; i < monthlyResults.length; i++)
		{
			monthlyResultsDescription += String.format("%dº mês do semestre: R$%.2f\n", (i+1), monthlyResults[i]);
		}
		
		JOptionPane.showMessageDialog(null, monthlyResultsDescription, "Resultados mensais", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, semesterResultDescription, "Resultado do semestre", JOptionPane.INFORMATION_MESSAGE);
	}

}
