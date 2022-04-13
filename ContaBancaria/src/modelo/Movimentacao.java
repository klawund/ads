package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimentacao
{
	// 1 - Saque | 2 - Deposito
	private int tipo;
	private double valor;
	private Date data;

	public Movimentacao(double valor)
	{
		this.tipo = valor > 0 ? 2 : 1;
		this.valor = valor;
		this.data = new Date();
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%s | %s | R$%.2f", sdf.format(data), tipo == 1 ? "Saque    " : "Depósito",
			valor);
	}
}
