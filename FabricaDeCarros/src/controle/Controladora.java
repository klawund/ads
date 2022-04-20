package controle;

import modelo.Fabrica;
import visualizacao.EntradaSaida;

public class Controladora
{
	private Fabrica fabrica = new Fabrica();

	public void exibirMenu()
	{
		int opcao;

		while (true)
		{
			opcao = EntradaSaida.lerOpcaoMenu();

			switch (opcao)
			{
				case 1:
					int qtdeCarros = EntradaSaida.lerQuantidadeDeCarros();

					for (int i = 0; i < qtdeCarros; i++)
					{
						fabrica.fabricarCarro();
					}
					EntradaSaida.exibirResumoCarros(fabrica.gerarResumoCarros());
					break;
				case 2:
					fabrica.venderCarro();
					break;
				case 3:
					if (fabrica.getCarros().isEmpty())
					{
						EntradaSaida.exibirMensagemDeErro("Ainda não há carros fabricados!");
						break;
					}
					EntradaSaida.exibirResumoCarros(fabrica.gerarResumoCarros());
					break;
				default:
					System.exit(0);
			}
		}
	}
}
