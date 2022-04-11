package modelo;

import java.util.List;

public class Conta
{
	private String titularDaConta;
	private int tipo;
	private double saldo;
	private List<Movimentacao> listaDeMovimentacao;

	public String getTitularDaConta()
	{
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta)
	{
		this.titularDaConta = titularDaConta;
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public double getSaldo()
	{
		return saldo;
	}

	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}

	public List<Movimentacao> getListaDeMovimentacao()
	{
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(List<Movimentacao> listaDeMovimentacao)
	{
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public void depositar()
	{

	}

	public void sacar()
	{

	}

	public void gerarSaldo()
	{

	}

	public String gerarDadosDaConta()
	{
		return "";
	}

	public String gerarExtratoDepositos()
	{
		return "";
	}

	public String gerarExtratoSaques()
	{
		return "";
	}
}
