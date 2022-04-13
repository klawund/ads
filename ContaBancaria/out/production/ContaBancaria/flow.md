## Principal.java
-> Instanciar a Controladora
-> Chamar o método exibirMenu()

## Controladora.java
-> Exibir o menu e ler a opção que o usuário deseja, fazendo cada opção um caso de switch, cada caso chamando um método de leitura da EntradaSaida.java e um método de ação da Conta.java
-> Utilizar a EntradaSaida.java para pedir e mostrar os dados ao usuário

## Conta.java
-> Entidade que representa a conta bancária e suas infos e executa as ações de saque, depósito, extrato e gera as informações da conta
-> Gerar o saldo a partir da lista de movimentacoes dentro da classe. Ao sacar, alterar a lista e gerar o saque a partir da lista, mesma coisa para o depósito.
-> Saldo só pode ser alterado conforme a regra de negócio, então setter deve ser privado
-> Manter a responsabilidade da instanciação da Movimentacao por conta da controladora. Só receber Movimentacao como parametro nos metodos de mudança de saldo/extrato

## Movimentacao.java
-> Entidade que representa um lançamento no extrato da conta, representando o valor, data e tipo
-> Armazenar a data de que forma? Ler como String normal ou fazer parse para Date ou LocalDate/Instant?
