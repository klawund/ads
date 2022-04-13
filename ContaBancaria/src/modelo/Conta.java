package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Conta
{
	// 1 - Poupança | 2 - Corrente
	private int tipo;
	private String titularDaConta;
	private double saldo;
	private List<Movimentacao> listaDeMovimentacao = new ArrayList<>();

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

	private void setSaldo(double saldo)
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

	public void depositar(Movimentacao deposito)
	{
		listaDeMovimentacao.add(deposito);
		saldo += deposito.getValor();
	}

	public void sacar(Movimentacao saque)
	{
		listaDeMovimentacao.add(saque);
		saldo -= saque.getValor();
	}

	public String gerarSaldo()
	{
		return String.format("R$%.2f", saldo);
	}

	public String gerarDadosDaConta()
	{
		return "Titular: " + titularDaConta + "\n" + "Tipo: " + (tipo == 1 ? "Conta poupança"
			: "Conta corrente") + "\n" + "Saldo: " + String.format("R$%.2f", saldo);
	}

	public String gerarExtratoDepositos()
	{
		StringBuilder sb = new StringBuilder();
		List<Movimentacao> depositos = listaDeMovimentacao.stream().filter(m -> m.getTipo() == 2)
			.collect(Collectors.toList());

		for (Movimentacao deposito : depositos)
		{
			sb.append(deposito).append("\n");
		}

		return sb.toString();
	}

	public String gerarExtratoSaques()
	{
		StringBuilder sb = new StringBuilder();
		List<Movimentacao> saques = listaDeMovimentacao.stream().filter(m -> m.getTipo() == 1)
			.collect(Collectors.toList());

		for (Movimentacao saque : saques)
		{
			sb.append(saque).append("\n");
		}

		return sb.toString();
	}

	public String gerarExtrato()
	{
		StringBuilder sb = new StringBuilder();

		for (Movimentacao movimentacao : listaDeMovimentacao)
		{
			sb.append(movimentacao).append("\n");
		}

		return sb.toString();
	}
}
