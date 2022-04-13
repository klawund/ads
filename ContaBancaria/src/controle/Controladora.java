package controle;

import modelo.Conta;
import modelo.Movimentacao;
import visualizacao.EntradaSaida;

public class Controladora
{
	public void exibirMenu()
	{
		int opcao;
		Conta conta = null;

		do
		{
			opcao = EntradaSaida.lerOpcaoMenu();

			switch (opcao)
			{
				case 1: // criar conta
					if (conta != null)
					{
						EntradaSaida.exibirErro("A conta já foi criada!");
						break;
					}

					conta = new Conta();
					conta.setTitularDaConta(EntradaSaida.solicitarTitularDaConta());
					conta.setTipo(EntradaSaida.solicitarTipoDaConta());
					break;
				case 2: // ver saldo
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					EntradaSaida.exibirSaldo(conta);
					break;
				case 3: // ver informações da conta
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					EntradaSaida.exibirDadosDaConta(conta);
					break;
				case 4: // depósito
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					Movimentacao deposito = new Movimentacao(EntradaSaida.solicitarInformacoesDeposito());
					conta.depositar(deposito);
					break;
				case 5: // saque
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					Movimentacao saque = new Movimentacao(EntradaSaida.solicitarInformacoesSaque(conta) * -1);
					conta.sacar(saque);
					break;
				case 6: // extrato completo
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					EntradaSaida.exibirExtratoCompleto(conta);
					break;
				case 7: // extrato saques
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					EntradaSaida.exibirExtratoDeSaques(conta);
					break;
				case 8: // extrato depósitos
					if (conta == null)
					{
						EntradaSaida.exibirErro("Ainda não há uma conta criada!");
						break;
					}

					EntradaSaida.exibirExtratoDeDepositos(conta);
					break;
				default: // sair
			}

		}
		while (opcao != 9);
	}
}
