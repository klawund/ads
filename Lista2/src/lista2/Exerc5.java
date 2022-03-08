package lista2;

import javax.swing.JOptionPane;

public class Exerc5
{

	public static void main(String[] args)
	{
		int count = 0;
		boolean stop = false;
		boolean invalidInput;
		
		String finalMessage;
		
		int[] ages = new int[100];
		int agesSum = 0;
		int averageAge;
		
		boolean[] isSmoker = new boolean[100];
		int isSmokerOrdinal;
		int smokersCount = 0;
		
		double[] netSalaries = new double[100];
		double netSalariesSum = 0.0;
		double averageNetSalary;
		
		int[] monthsAsMember = new int[100];
		int veteransCount = 0;
		float veteranPercentage;
		
		for (int i = 0; !stop; i++)
		{
			if (i > 100)
			{
				JOptionPane.showMessageDialog(null, "Capacidade máxima de usuários cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
				break;
			}
			
			do
			{
				ages[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do " + (i + 1) + "º usuário:"));
				invalidInput = ages[i] < 0;
				
				if (invalidInput)
				{
					JOptionPane.showMessageDialog(null, "A idade inserida precisa ser maior que 0!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (invalidInput);
			
			agesSum += ages[i];
			
			do
			{
				isSmokerOrdinal = Integer.parseInt(JOptionPane.showInputDialog("É fumante? \n1 - Sim \n2 - Não"));
				invalidInput = isSmokerOrdinal != 1 && isSmokerOrdinal != 2;
				
				if (invalidInput)
				{
					JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (invalidInput);
			
			isSmoker[i] = isSmokerOrdinal == 1;
			smokersCount = isSmoker[i] ? smokersCount + 1 : smokersCount;
			
			do
			{
				netSalaries[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira o salário do " + (i + 1) + "º usuário:"));
				invalidInput = netSalaries[i] < 0;
				
				if (invalidInput)
				{
					JOptionPane.showMessageDialog(null, "O salário líquido não pode ser negativo!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (invalidInput);
			
			netSalariesSum += netSalaries[i];
			
			do
			{ 
				monthsAsMember[i] = Integer.parseInt(JOptionPane.showInputDialog("Há quantos meses o usuário é membro?"));
				invalidInput = monthsAsMember[i] < 0 || monthsAsMember[i] > ages[i] * 12;
				
				if (invalidInput)
				{
					JOptionPane.showMessageDialog(null, "O número de meses inserido é inválido!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (invalidInput);
			
			veteransCount = monthsAsMember[i] > 3 ? veteransCount + 1 : veteransCount;
			System.out.println(veteransCount);
			count++;
			
			stop = "Encerrar".equalsIgnoreCase(JOptionPane.showInputDialog("Caso não deseje cadastrar mais nenhum usuário, digite \"Encerrar\""));
		}
		
		averageAge = agesSum / count;
		averageNetSalary = netSalariesSum / count;
		System.out.println(veteransCount + "/" + count);
		veteranPercentage = (veteransCount / count) * 100f;
		System.out.println(veteranPercentage);
		
		finalMessage = "Média de idade dos usuários: " + averageAge + "\n"
				+ String.format("Média salarial líquida dos usuários: R$%.2f\n", averageNetSalary)
				+ "Quantidade de fumantes: " + smokersCount + "\n"
				+ "Quantidade de não-fumantes: " + (count - smokersCount) + "\n"
				+ String.format("%% de veteranos (frequentam o clube há mais de 3 meses): %.2f%%", veteranPercentage);
		
		JOptionPane.showMessageDialog(null, finalMessage, "Dashboard", JOptionPane.INFORMATION_MESSAGE);

	}

}
