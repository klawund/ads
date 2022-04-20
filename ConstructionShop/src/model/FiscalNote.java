package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FiscalNote
{
	private final Date saleDate;
	private final String productDescription;
	private final int quantity;
	private final double totalPrice;

	public FiscalNote(Product product)
	{
		this.saleDate = new Date();
		this.productDescription = product.getDescription();
		this.quantity = product.getTransientQuantity();
		this.totalPrice = quantity * product.getPrice();
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(saleDate) + " | " + quantity + "x | " + productDescription + " | " + String.format(
			"R$%.2f", totalPrice);
	}
}
