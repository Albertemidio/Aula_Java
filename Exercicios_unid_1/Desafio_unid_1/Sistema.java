package Desafio_unid_1;

 import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== MENU ESTOQUE =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    estoque.add(new Produto(id, nome, quantidade, preco));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("Digite o ID do produto para remover: ");
                    int idRemover = scanner.nextInt();

                    boolean removido = false;

                    for (int i = 0; i < estoque.size(); i++) {
                        if (estoque.get(i).getId() == idRemover) {
                            estoque.remove(i);
                            removido = true;
                            System.out.println("Produto removido!");
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do produto para atualizar: ");
                    int idAtualizar = scanner.nextInt();

                    boolean encontrado = false;

                    for (Produto p : estoque) {
                        if (p.getId() == idAtualizar) {

                            System.out.print("Nova quantidade: ");
                            int novaQuantidade = scanner.nextInt();
                            p.setQuantidade(novaQuantidade);

                            System.out.print("Novo preço: ");
                            double novoPreco = scanner.nextDouble();
                            p.setPreco(novoPreco);

                            System.out.println("Produto atualizado!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    if (estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                    } else {
                        for (Produto p : estoque) {
                            p.exibirProduto();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

       
    }
}

