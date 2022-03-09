package lista2;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exerc7
{

	public static void main(String[] args)
	{
		String[] classes = { "Matemática", "Física", "Química" };
		double[][] grades = new double[4][3];
		
		int option;
		String menu;
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				String currentClass = classes[j];
				
				do
				{
					grades[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª nota de " + currentClass));
					
					if (grades[i][j] < 0.0 || grades[i][j] > 10.0)
					{
						JOptionPane.showMessageDialog(null, "Insira uma nota válida!", "Erro", JOptionPane.WARNING_MESSAGE);
					}
				} while (grades[i][j] < 0.0 || grades[i][j] > 10.0);
			}
		}
		
		do
		{
			menu = "Insira a opção desejada:\n";
			menu += "1 - Todas as notas de todas as disciplinas\n"
					+ "2 - Qual a maior nota e em qual disciplina foi\n"
					+ "3 - Média aritmética de uma disciplina\n"
					+ "4 - As notas de um dos bimestres\n"
					+ "5 - Encerrar";
			
			do
			{
				option = Integer.parseInt(JOptionPane.showInputDialog(menu));
				
				if (!Arrays.asList(1, 2, 3, 4, 5).contains(option))
				{
					JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} while (!Arrays.asList(1, 2, 3, 4, 5).contains(option));
			
			switch (option)
			{
				case 1:
					String print = "";
					
					for (int i = 0; i < 3; i++)
					{
						print += classes[i] + ": | ";
						for (int j = 0; j < 4; j++)
						{
							print += String.format("%.2f | ", grades [j][i]);
						}
						print += "\n";
					}
					
					JOptionPane.showMessageDialog(null, print, "Todas as notas:", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					
					double highestGrade = grades[0][0];
					int classIndex = 0;
					
					for (int i = 0; i < 4; i++)
					{
						for (int j = 0; j < 3; j++)
						{
							if (highestGrade < grades[i][j])
							{
								highestGrade = grades[i][j];
								classIndex = j;
							}
						}
					}
					
					JOptionPane.showMessageDialog(null, String.format("A nota mais alta é %.2f na matéria de %s", highestGrade, classes[classIndex]), "Nota mais alta", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3:
					int classToAverage;
					double classSum = 0.0;
					double classAverage = 0.0;
	
					do
					{
						classToAverage = Integer.parseInt(JOptionPane.showInputDialog("De qual classe você quer saber a média aritmética?\n1 - Matemática\n2 - Física\n3 - Química"));
						
						if (!Arrays.asList(1, 2, 3).contains(classToAverage))
						{
							JOptionPane.showMessageDialog(null, "Insira uma disciplina válida!", "Erro", JOptionPane.WARNING_MESSAGE);
						}
					} while (!Arrays.asList(1, 2, 3).contains(classToAverage));
					
					classToAverage--;
					
					for (int i = 0; i < 4; i++)
					{
						classSum += grades[i][classToAverage];
					}
					
					classAverage = classSum / 4;
					
					JOptionPane.showMessageDialog(null, String.format("A sua média de %s é %.2f", classes[classToAverage], classAverage), "Média de " + classes[classToAverage], JOptionPane.INFORMATION_MESSAGE);
					break;
				case 4:
					int bimester;
					
					do
					{
						bimester = Integer.parseInt(JOptionPane.showInputDialog("Insira qual bimestre você deseja ver as suas notas:\n1 - 1º Bimestre\n2 - 2º Bimestre"));
						if (!Arrays.asList(1, 2).contains(bimester))
						{
							JOptionPane.showMessageDialog(null, "Insira um bimestre válido!", "Erro", JOptionPane.WARNING_MESSAGE);
						}
					} while (!Arrays.asList(1, 2).contains(bimester));
					
					print = bimester + "º Bimestre";
					print += "\n";
					
					for (int i = 0; i < 3; i++)
					{
						print += classes[i] + ": | ";
						for (int j = bimester == 1 ? 0 : 2; j < (bimester == 1 ? 2 : 4); j++)
						{
							print += String.format("%.2f | ", grades[j][i]);
						}
						print += "\n";
					}
					
					JOptionPane.showMessageDialog(null, print, String.format("Notas do %dº Bimestre", bimester), JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		} while (option != 5);
	}

}
