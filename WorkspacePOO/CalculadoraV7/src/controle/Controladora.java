package controle;

import javax.swing.JOptionPane;

import modelo.Divisao;
import modelo.Multiplicacao;
import modelo.Soma;
import modelo.Subtracao;
import visualizacao.EntradaSaida;

public class Controladora
{

	public void exibeMenu()
	{
		int continuar;
		double resultado = 0.0;

		do
		{
			double num1 = EntradaSaida.solicitaNumero("1º");
			double num2 = EntradaSaida.solicitaNumero("2º");
			int operacao = EntradaSaida.solicitaOperacao();

			switch (operacao)
			{
			case 1:
				Soma soma = new Soma();
				soma.setNum1(num1);
				soma.setNum2(num2);

				resultado = soma.calcula();
				break;
			case 2:
				Subtracao sub = new Subtracao();
				sub.setNum1(num1);
				sub.setNum2(num2);

				resultado = sub.calcula();
				break;
			case 3:
				Multiplicacao mult = new Multiplicacao();
				mult.setNum1(num1);
				mult.setNum2(num2);

				resultado = mult.calcula();
				break;
			case 4:
				while (num2 == 0)
				{
					num2 = EntradaSaida.solicitaNumero("2º");
				}
				Divisao divisao = new Divisao();
				divisao.setNum1(num1);
				divisao.setNum2(num2);

				resultado = divisao.calcula();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Operação inválida! A calculadora será encerrada!");
				System.exit(0);
			}

			EntradaSaida.mostraResultado(resultado, operacao);
			continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar calculando? 1 - Sim | 2 - Não"));

		} while (continuar == 1);
	}

}
