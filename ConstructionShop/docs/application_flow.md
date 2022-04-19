## 1 Menu
- array c/ opcões do menu
- ler opcao via método do InputOuput
- switch case para cada escolha (menos saída)
- a cada case do switch chamar o método interno do controller e dar um break, deixar a lógica toda no método separado

## 1.1 Criar produto
- ler descrição, código e preço via método do InputOutput com tratamento de exceções
- instanciar Product
- passar Product como parâmetro para sobrecarga de Shop
- em Shop passar Product como parâmetro para sobrecarga de Stock

## 1.2 Listar produtos
- método da Shop para gerar resumo que pega a lista via método do Stock
- método do InputOutput para mostrar mensagem com o buffer gerado

