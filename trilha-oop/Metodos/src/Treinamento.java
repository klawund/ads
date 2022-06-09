import javax.swing.JOptionPane;

public class Treinamento
{

	public static void main(String[] args)
	{
		int peso = Integer.parseInt(JOptionPane.showInputDialog("Informe seu peso"));

		while (peso <= 0)
		{
			mostraErroPeso();
			peso = Integer.parseInt(JOptionPane.showInputDialog("Informe seu peso"));
		}

		double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe sua altura"));
		
		while (altura <= 0.0)
		{
			mostraErroAltura();
			altura = Double.parseDouble(JOptionPane.showInputDialog("Informe sua altura"));
		}
		
		double imc = calculaIndice(peso, altura);
		System.out.println(imc);
		verificaIndice(imc);

	}

	public static double calculaIndice(int peso, double altura)
	{
		return peso / (altura * altura);
	}

	public static void verificaIndice(double imc)
	{
		String mensagem = "";
		
		if (imc < 17)
		{
			mensagem = "Você está muito abaixo do peso! ";
		}
		else if (imc < 18.5)
		{
			mensagem = "Você está abaixo do peso! ";
		}
		else if (imc < 25)
		{
			mensagem = "Você está com o peso adequado! ";
		}
		else if (imc < 30)
		{
			mensagem = "Você está acima do peso! ";
		}
		else if (imc < 35)
		{
			mensagem = "Você está com obesidade tipo I! ";
		}
		else if (imc < 40)
		{
			mensagem = "Você está com obesidade tipo II ";
		}
		else if (imc >= 40)
		{
			mensagem = "Você está com obesidade tipo III! ";
		}
		
		mensagem += "Índice: ";
		
		JOptionPane.showMessageDialog(null, mensagem + imc);
	}

	public static void mostraErroPeso()
	{
		JOptionPane.showMessageDialog(null, "O peso digitado é inválido!");
	}

	public static void mostraErroAltura()
	{

		JOptionPane.showMessageDialog(null, "A altura digitada é inválida!");
	}

}
