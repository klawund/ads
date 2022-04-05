package modelo;

import java.util.ArrayList;
import java.util.List;

public class Casa
{

	private String descricao;
	private String cor;
	private List<Abertura> listaDePortas = new ArrayList<>();

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

}
