package modelo;

import java.util.ArrayList;
import java.util.List;
import visualizacao.EntradaSaida;

public class Fabrica
{
	private List<Carro> carros = new ArrayList<>();

	public void venderCarro()
	{
		if (carros.isEmpty())
		{
			EntradaSaida.exibirMensagemDeErro("Não há nenhum carro fabricado!");
		}
		else
		{
			Carro carro = EntradaSaida.lerCarroParaVender(carros.toArray(new Carro[0]));
			carros.remove(carro);
		}
	}

	public void fabricarCarro()
	{
		Carro carro = new Carro();
		carro.setModelo(EntradaSaida.lerAtributoCarro("o modelo"));
		carro.setCor(EntradaSaida.lerAtributoCarro("a cor"));

		carros.add(carro);
	}

	public String gerarResumoCarros()
	{
		StringBuilder resumo = new StringBuilder();
		for (Carro carro : carros)
		{
			resumo.append("Modelo: ").append(carro.getModelo()).append(" | ");
			resumo.append("Cor: ").append(carro.getCor()).append("\n");
		}
		return resumo.toString();
	}
}
