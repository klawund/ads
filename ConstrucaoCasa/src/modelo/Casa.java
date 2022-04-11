package modelo;

import java.util.ArrayList;
import java.util.List;

public class Casa
{

	private String descricao;
	private String cor;
	private List<Abertura> listaDePortas = new ArrayList<>();
	private List<Abertura> listaDeJanelas = new ArrayList<>();

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}

	public List<Abertura> getListaDePortas()
	{
		return listaDePortas;
	}

	public void setListaDePortas(List<Abertura> listaDePortas)
	{
		this.listaDePortas = listaDePortas;
	}

	public List<Abertura> getListaDeJanelas()
	{
		return listaDeJanelas;
	}

	public void setListaDeJanelas(List<Abertura> listaDeJanelas)
	{
		this.listaDeJanelas = listaDeJanelas;
	}

	public void constroiCasa(String descricao, String cor, List<Abertura> listaDeJanelas,
			List<Abertura> listaDePortas)
	{
		setDescricao(descricao);
		setCor(cor);
		setListaDeJanelas(listaDeJanelas);
		setListaDePortas(listaDePortas);
	}
	
	public Abertura retornaAbertura(int posicao, String tipoAbertura)
	{
		if ("porta".equals(tipoAbertura))
		{
			return this.listaDePortas.get(posicao);
		}
		return this.listaDeJanelas.get(posicao);
	}

	public void moverAbertura(Abertura abertura, int novoEstado)
	{
		abertura.setEstado(novoEstado);
	}
	
	public String geraInfoCasa()
	{
		String informacoes = "Descrição: " + this.descricao + "\nCor: " + this.cor + "\nLista de portas:\n";

		for (Abertura abertura : this.listaDePortas)
		{
			String estado = abertura.getEstado() == 0 ? "fechada" : "aberta";
			informacoes += abertura.getDescricao() + " | Estado: " + estado + "\n";
		}

		informacoes += "\nLista de janelas:\n";

		for (Abertura abertura : this.listaDeJanelas)
		{
			String estado = abertura.getEstado() == 0 ? "fechada" : "aberta";
			informacoes += abertura.getDescricao() + " | Estado: " + estado + "\n";
		}
		return informacoes;
	}

}
