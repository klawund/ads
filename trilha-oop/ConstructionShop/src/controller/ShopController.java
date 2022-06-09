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

	private void createProduct()
	{
		String code = InputOutput.readProductCode(shop);
		String description = InputOutput.readInfo("Insira a descrição do produto:");
		double price = InputOutput.readProductPrice();

		shop.createProduct(new Product(code, description, price));
	}

	private void getStockReport()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}
		InputOutput.showMessage(shop.getStockReport(), "Estoque");
	}

	private void addToStock()
	{
		if (shop.getAllProducts().isEmpty())
		{
			InputOutput.showError("Você ainda não tem nenhum produto cadastrado!");
			return;
		}

		Product product = (Product) InputOutput.readOption(shop.getAllProducts().toArray(new Product[0]),
			"Escolha um produto", false);

		int quantity = InputOutput.readSafeInteger("Insira a quantidade:", 1, -1);

		product.setTransientQuantity(quantity);
		shop.addEntry(product);
		InputOutput.showMessage("Lançamento efetuado!", "Sucesso");
	}

	private void sellProduct()
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

	private void removeProduct()
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

	private void generateSaleLog()
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
