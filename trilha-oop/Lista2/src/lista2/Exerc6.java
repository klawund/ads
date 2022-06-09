package lista2;

import javax.swing.JOptionPane;

public class Exerc6
{

	public static void main(String[] args)
	{
		double[] yearlySales = new double[12];
		double maxSale = 0.0;
		int maxSaleMonth = 0;
		
		double minSale;
		int minSaleMonth = 0;
		
		double yearlyAverage;
		double yearlySum = 0.0;
		
		double pairMonthsAverage = 0.0;
		double pairMonthsSum = 0.0;
		
		double secondSemesterAverage = 0.0;
		double secondSemesterSum = 0.0;
		
		for (int i = 0; i < yearlySales.length; i++)
		{
			yearlySales[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira a venda do " + (i + 1) + "º mês:"));
		}
		
		minSale = yearlySales[0];
		maxSale = minSale;
		
		for (int i = 0; i < yearlySales.length; i++)
		{
			 if (minSale > yearlySales[i])
			 {
				 minSale = yearlySales[i];
				 minSaleMonth = i;
			 }
			 
			 if (maxSale < yearlySales[i])
			 {
				 maxSale = yearlySales[i];
				 maxSaleMonth = i;
			 }
			 
			 
			 secondSemesterSum = (i + 1) > 6 ? secondSemesterSum + yearlySales[i] : secondSemesterSum;
			 pairMonthsSum = (i + 1) % 2 == 0 ? pairMonthsSum  + yearlySales[i] : pairMonthsSum;
			 yearlySum += yearlySales[i];
		}
		
		yearlyAverage = yearlySum / 12;
		secondSemesterAverage = secondSemesterSum / 6;
		pairMonthsAverage = pairMonthsSum / 6;
		
		String message = "O " + (minSaleMonth + 1) + "º foi o mês com menos vendas no ano\n"
				+ "O " + (maxSaleMonth + 1) + "ª foi o mês com mais vendas no ano\n"
				+ String.format("A média de vendas no ano foi de R$%.2f por mês\n", yearlyAverage)
				+ String.format("A média de vendas dos meses pares foi R$%.2f por mês\n", pairMonthsAverage)
				+ String.format("A média de vendas do segundo semestre foi de R$%.2f por mês\n", secondSemesterAverage);
		
		JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);

	}

}
