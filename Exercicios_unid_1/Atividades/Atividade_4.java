//Exercício 4: Listas (ArrayList)  
//• Implemente um programa que permita ao usuário adicionar e remover elementos de uma 
//lista dinâmica (por exemplo, ArrayList) de números inteiros.   

import java.util.Scanner;

public class Atividade_4 {

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);

        int[] listaNumeros = new int[5]; 
        int quantidade = 0; 
        int opcao;

        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Exibir lista de números");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            opcao = x.nextInt();

            switch (opcao) {

                case 1:
                    if (quantidade < listaNumeros.length) {
                        System.out.print("Digite o número a ser adicionado: ");
                        int numeroAdd = x.nextInt();
                        listaNumeros[quantidade] = numeroAdd;
                        quantidade++;
                        System.out.println("Número adicionado.");
                    } else {
                        System.out.println("A lista está cheia.");
                    }
                    break;

                case 2:
                    if (quantidade == 0) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.print("Digite o índice a ser removido: ");
                        int indice = x.nextInt();

                        if (indice >= 0 && indice < quantidade) {

                            // desloca os elementos para a esquerda
                            for (int i = indice; i < quantidade - 1; i++) {
                                listaNumeros[i] = listaNumeros[i + 1];
                            }

                            quantidade--;
                            System.out.println("Número removido.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 3:
                    if (quantidade == 0) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Lista de números:");
                        for (int i = 0; i < quantidade; i++) {
                            System.out.println(i + " - " + listaNumeros[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        x.close();
    }
}
