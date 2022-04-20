package controller;

import model.Product;
import model.Shop;
import view.InputOutput;

public class ShopController
{
	private final Shop shop = new Shop();

	public void showMenu()
	{
		String[] menuOptions = {"Criar produto", "Ver relatório de estoque", "Lançar entrada",
			"Lançar venda", "Remover produto", "Ver relatório de vendas", "Ver resultado de vendas",
			"Sair"};

		int menuOption;

		do
		{
			menuOption = ((int) InputOutput.readOption(menuOptions, "Menu", true)) + 1;

			switch (menuOption)
			{
				case 1:
					createProduct();
					break;
				case 2:
					getStockReport();
					break;
				case 3:
					addToStock();
					break;
				case 4:
					sellProduct();
					break;
				case 5:
					removeProduct();
					break;
				case 6:
					generateSaleLog();
					break;
				case 7:
					getSaleResult();
					break;
				default:
			}
		}
		while (menuOption != 8);
	}

	public void createProduct()
	{
		String code = readProductCode();
		String description = InputOutput.readInfo("Insira a descrição do produto:");
		double price = readProductPrice();

		shop.createProduct(new Product(code, description, price));
	}

	private double readProductPrice()
	{
		String priceStr;
		double price = 0.0;

		boolean wentWrong = false;
		do
		{
			priceStr = InputOutput.readInfo("Insira o valor do produto (R$00.00):");

			try
			{
				price = Double.parseDouble(priceStr);
			}
			catch (Exception e)
			{
				InputOutput.showError("Dado inválido!");
				wentWrong = true;
			}
		}
		while (wentWrong);
		return price;
	}

	private String readProductCode()
	{
		String code;
		do
		{
			code = InputOutput.readInfo("Insira o código do produto:");

			if (shop.hasProduct(code))
			{
				InputOutput.showError("Já existe um produto cadastrado com esse código!");
			}
		}
		while (shop.hasProduct(code));
		return code;
	}

	public void getStockReport()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}
		InputOutput.showMessage(shop.getStockReport(), "Estoque");
	}

	public void addToStock()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}

		String code = InputOutput.readInfo("Insira o código do produto:");
		if (!shop.hasProduct(code))
		{
			InputOutput.showError("Não há nenhum produto com esse código cadastrado!");
			return;
		}

		int quantity = readProductQuantity();

		Product product = shop.getProductByCode(code);
		product.setTransientQuantity(quantity);
		shop.addEntry(product);
		InputOutput.showMessage("Lançamento efetuado!", "Sucesso");
	}

	public int readProductQuantity()
	{
		String quantityStr;
		boolean wentWrong = false;
		int quantity = 0;

		do
		{
			quantityStr = InputOutput.readInfo("Insira a quantidade:");

			try
			{
				quantity = Integer.parseInt(quantityStr);
			}
			catch (Exception e)
			{
				wentWrong = true;
			}

			wentWrong = wentWrong || quantity <= 0;

			if (wentWrong)
			{
				InputOutput.showError("Valor inválido");
			}
		}
		while (wentWrong);
		return quantity;
	}

	public void sellProduct()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}
		else if (shop.getProductsInStock().isEmpty())
		{
			InputOutput.showError("Não há nenhum produto com estoque positivo!");
			return;
		}

		Product product = (Product) InputOutput.readOption(
			shop.getProductsInStock().toArray(new Product[0]), "Escolha o produto a ser vendido", false);

		int quantity = InputOutput.readSafeInteger("Insira a quantidade a ser vendida:", 1,
			shop.getProductStockQuantity(product));

		product.setTransientQuantity(quantity * -1);
		shop.addEntry(product);

		InputOutput.showMessage("Produto vendido com sucesso!", "Venda");
	}

	public void removeProduct()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}

		Product product = (Product) InputOutput.readOption(shop.getAllProducts().toArray(new Product[0]),
			"Escolha o produto a ser remvoido do estoque", false);

		shop.removeProduct(product);
		InputOutput.showMessage("Produto removido com sucesso!", "Remover produto");
	}

	public void generateSaleLog()
	{
		if (shop.hasSales())
		{
			InputOutput.showError("Ainda não foi feita nenhuma venda!");
			return;
		}
		InputOutput.showMessage(shop.getSaleLogReport(), "Resumo de vendas");
	}

	private void getSaleResult()
	{
		InputOutput.showMessage("Total: " + shop.getSaleResult(), "Total de vendas");
	}
}
