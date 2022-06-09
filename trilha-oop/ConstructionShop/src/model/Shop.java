package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop
{
	private final List<FiscalNote> saleLog = new ArrayList<>();
	private final Map<Product, Integer> products = new HashMap<>();
	private double saleResult = 0.0;

	public void createProduct(Product product)
	{
		products.put(product, product.getTransientQuantity());
	}

	public void removeProduct(Product product)
	{
		products.remove(product);
	}

	public void addEntry(Product product)
	{
		int currentQuantity = products.get(product);
		products.put(product, currentQuantity + product.getTransientQuantity());

		if (product.getTransientQuantity() < 0)
		{
			product.setTransientQuantity(product.getTransientQuantity() * -1);
			addSaleLog(new FiscalNote(product));
		}
	}

	public String getStockReport()
	{
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Product, Integer> stockEntry : products.entrySet())
		{
			sb.append("Código: ").append(stockEntry.getKey().getCode()).append(" | ");
			sb.append("Descrição: ").append(stockEntry.getKey().getDescription()).append(" | ");
			sb.append("Qtd.: ").append(stockEntry.getValue()).append("\n");
		}
		return sb.toString();
	}

	public String getSaleLogReport()
	{
		StringBuilder sb = new StringBuilder();
		for (FiscalNote fiscalNote : saleLog)
		{
			sb.append(fiscalNote).append("\n");
		}
		sb.append("-------------------").append("\n");
		sb.append("Total: ").append(getSaleResult());

		return sb.toString();
	}

	public String getSaleResult()
	{
		return String.format("R$%.2f", saleResult);
	}

	public List<Product> getAllProducts()
	{
		return new ArrayList<>(products.keySet());
	}

	public List<Product> getProductsInStock()
	{
		return new ArrayList<>(products.keySet()).stream().filter(product -> products.get(product) > 0)
			.collect(Collectors.toList());
	}

	public boolean hasProduct(String productCode)
	{
		return products.keySet().stream().anyMatch(product -> productCode.equals(product.getCode()));
	}

	public int getProductStockQuantity(Product product)
	{
		return products.get(product);
	}

	public Product getProductByCode(String productCode)
	{
		return products.keySet().stream().filter(product -> productCode.equals(product.getCode()))
			.findFirst().get();
	}

	public void addSaleLog(FiscalNote fiscalNote)
	{
		saleLog.add(fiscalNote);
		saleResult += fiscalNote.getTotalPrice();
	}

	public boolean hasSales()
	{
		return saleLog.isEmpty();
	}
}
