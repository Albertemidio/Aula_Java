package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projeto.Pizza.TamanhoPizza;

public class Pizzaria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {

            System.out.println();
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {

                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;

                case 2:
                    alterarPedido(scanner, listaPedidos);
                    break;

                case 3:
                    listaClientes.add(adicionarCliente(scanner));
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 4:
                    gerarRelatorio(listaPedidos);
                    break;

                case 5:
                    gerarListaClientes(listaClientes);
                    break;

                case 9:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        List<Pizza> pizzas = new ArrayList<>();

        System.out.println("Selecione um cliente: ");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNome());
        }

        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        boolean continuar = true;

        while (continuar) {

            System.out.println("Selecione o tamanho da pizza:");

            for (int i = 0; i < TamanhoPizza.values().length; i++) {
                System.out.println((i + 1) + " - " + TamanhoPizza.values()[i]);
            }

            int tamanho = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Quantidade de sabores (1-4): ");
            int quantiSabores = scanner.nextInt();
            scanner.nextLine();

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>(cardapio.getCardapio().keySet());
            List<String> saboresSelect = new ArrayList<>();

            for (int i = 0; i < saboresList.size(); i++) {
                System.out.println((i + 1) + " - " + saboresList.get(i));
            }

            for (int i = 0; i < quantiSabores; i++) {
                System.out.print("Escolha o sabor: ");
                int escolha = scanner.nextInt();
                scanner.nextLine();
                saboresSelect.add(saboresList.get(escolha - 1));
            }

            Pizza pizza = new Pizza(
                    saboresSelect,
                    cardapio.getPrecoJusto(saboresSelect),
                    TamanhoPizza.getByIndex(tamanho - 1)
            );

            pizzas.add(pizza);

            System.out.println("Deseja adicionar mais uma pizza?");
            System.out.println("1 - Sim / 2 - Não");
            int op = scanner.nextInt();
            scanner.nextLine();

            if (op != 1) continuar = false;
        }

        Pedido pedido = new Pedido(
                listaPedidos.size() + 1,
                listaClientes.get(clienteIndex),
                pizzas,
                somarPizzas(pizzas)
        );

        listaPedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPreco();
        }
        return total;
    }

    //ALTERAR PEIDIDO

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos) {

        if (listaPedidos.isEmpty()) {
            System.out.println("Não existem pedidos cadastrados.");
            return;
        }

        System.out.println("Buscar pedido por:");
        System.out.println("1 - ID");
        System.out.println("2 - Nome do cliente");
        int busca = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = null;

        if (busca == 1) {
            System.out.print("Digite o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Pedido p : listaPedidos) {
                if (p.getId() == id) {
                    pedido = p;
                    break;
                }
            }

        } else {

            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            for (Pedido p : listaPedidos) {
                if (p.getCliente().getNome().equalsIgnoreCase(nome)) {
                    pedido = p;
                    break;
                }
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("1 - Adicionar pizza");
        System.out.println("2 - Remover pizza específica");
        System.out.println("3 - Alterar sabor da pizza");
        System.out.println("4 - Calcular frete");
        int op = scanner.nextInt();
        scanner.nextLine();

        Cardapio cardapio = new Cardapio();

        switch (op) {

            case 1:
                adicionarPizzaAoPedido(scanner, pedido, cardapio);
                break;

            case 2:

                for (int i = 0; i < pedido.getPizzas().size(); i++) {
                    System.out.println((i + 1) + " - " + pedido.getPizzas().get(i).getSabores());
                }

                System.out.print("Escolha a pizza para remover: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index >= 0 && index < pedido.getPizzas().size()) {
                    pedido.getPizzas().remove(index);
                    pedido.setValorTotal(somarPizzas(pedido.getPizzas()));
                    System.out.println("Pizza removida!");
                }
                break;

            case 3:

                for (int i = 0; i < pedido.getPizzas().size(); i++) {
                    System.out.println((i + 1) + " - " + pedido.getPizzas().get(i).getSabores());
                }

                System.out.print("Escolha a pizza: ");
                int pizzaIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                List<String> saboresList = new ArrayList<>(cardapio.getCardapio().keySet());

                for (int i = 0; i < saboresList.size(); i++) {
                    System.out.println((i + 1) + " - " + saboresList.get(i));
                }

                System.out.print("Novo sabor: ");
                int novo = scanner.nextInt();
                scanner.nextLine();

                pedido.getPizzas().get(pizzaIndex)
                        .getSabores().set(0, saboresList.get(novo - 1));

                pedido.setValorTotal(somarPizzas(pedido.getPizzas()));
                System.out.println("Sabor alterado!");
                break;

            case 4:

                System.out.print("Digite a distância (km): ");
                double km = scanner.nextDouble();
                scanner.nextLine();

                double frete = calcularFrete(pedido, km);
                System.out.println("Frete: R$ " + frete);
                break;
        }
    }
    //ADICIONANDO PIZZA AO NOVO PEDIDO

    private static void adicionarPizzaAoPedido(Scanner scanner, Pedido pedido, Cardapio cardapio) {

        List<String> saboresList = new ArrayList<>(cardapio.getCardapio().keySet());
        List<String> saboresSelect = new ArrayList<>();

        for (int i = 0; i < saboresList.size(); i++) {
            System.out.println((i + 1) + " - " + saboresList.get(i));
        }

        System.out.print("Quantos sabores? ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Escolha o sabor: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();
            saboresSelect.add(saboresList.get(escolha - 1));
        }

        Pizza nova = new Pizza(
                saboresSelect,
                cardapio.getPrecoJusto(saboresSelect),
                TamanhoPizza.BROTO
        );

        pedido.getPizzas().add(nova);
        pedido.setValorTotal(somarPizzas(pedido.getPizzas()));

        System.out.println("Pizza adicionada!");
    }

    private static double calcularFrete(Pedido pedido, double km) {
        double valorPorKm = 2.0;
        int quantidadePizzas = pedido.getPizzas().size();
        return (km * valorPorKm) + (quantidadePizzas * 1.5);
    }

    //GERAR RELATORIO
    
    private static void gerarRelatorio(List<Pedido> listaPedidos) {

        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
            return;
        }

        double faturamento = 0;
        java.util.Map<String, Integer> contador = new java.util.HashMap<>();
        java.util.Map<String, java.util.Set<String>> grafo = new java.util.HashMap<>();

        for (Pedido pedido : listaPedidos) {

            faturamento += pedido.getValorTotal();

            for (Pizza pizza : pedido.getPizzas()) {

                List<String> sabores = pizza.getSabores();

                for (String sabor : sabores) {
                    contador.put(sabor, contador.getOrDefault(sabor, 0) + 1);
                    grafo.putIfAbsent(sabor, new java.util.HashSet<>());
                }

                for (int i = 0; i < sabores.size(); i++) {
                    for (int j = i + 1; j < sabores.size(); j++) {
                        grafo.get(sabores.get(i)).add(sabores.get(j));
                        grafo.get(sabores.get(j)).add(sabores.get(i));
                    }
                }
            }
        }

        System.out.println("FATURAMENTO TOTAL: R$ " + faturamento);

        System.out.println("\nSabores mais pedidos:");
        for (String sabor : contador.keySet()) {
            System.out.println(sabor + " - " + contador.get(sabor));
        }

        System.out.println("\nGrafo de ligações entre sabores:");
        for (String sabor : grafo.keySet()) {
            System.out.println(sabor + " -> " + grafo.get(sabor));
        }
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {

        if (listaClientes.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        for (Cliente c : listaClientes) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("Endereço: " + c.getEndereco());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Email: " + c.getEmail());
            System.out.println();
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Cliente(nome, endereco, telefone, email);
    }
}
