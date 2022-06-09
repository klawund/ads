package model;

public class Product
{
	private final String code;
	private final String description;
	private final double price;
	private int transientQuantity;

	public Product(String code, String description, double price)
	{
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public String getCode()
	{
		return code;
	}

	public String getDescription()
	{
		return description;
	}

	public double getPrice()
	{
		return price;
	}

	public int getTransientQuantity()
	{
		return transientQuantity;
	}

	public void setTransientQuantity(int transientQuantity)
	{
		this.transientQuantity = transientQuantity;
	}

	@Override
	public String toString()
	{
		return code + " | " + description + " | " + String.format("R$%.2f", price);
	}
}
