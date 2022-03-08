package lista1;

import javax.swing.JOptionPane;

public class Exerc1
{

	public static void main(String[] args)
	{
		int hours = Integer.parseInt(JOptionPane.showInputDialog("Insira uma quantidade em horas: "));
		int minutes = Integer.parseInt(JOptionPane.showInputDialog("Insira uma quantidade em minutos: "));
		int seconds = Integer.parseInt(JOptionPane.showInputDialog("Insira uma quantidade em horas: "));

		String time = hours + ":" + minutes + ":" + seconds;
		
		int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

		JOptionPane.showMessageDialog(null, "O horário " + time + " possui " + totalSeconds + " segundos",
				"Segundos no horário", JOptionPane.INFORMATION_MESSAGE);
	}

}
