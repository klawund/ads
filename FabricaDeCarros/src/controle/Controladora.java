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
				default:
					System.exit(0);
			}
		}
	}
}
