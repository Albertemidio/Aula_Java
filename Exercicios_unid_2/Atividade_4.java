//4 - Verificação de Expressões:
//Utilizando pilhas, desenvolva um programa para verificar se uma expressão matemática contendo
//parênteses está balanceada.

package Exercicios_unid_2;
import java.util.Scanner;
import java.util.Stack;

public class Atividade_4 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();

        System.out.print("Digite a expressão: ");
        String expressao = scanner.nextLine();

        boolean balanceada = true;

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.push(c); // empilha
            } 
            else if (c == ')') {
                if (pilha.isEmpty()) {
                    balanceada = false;
                    break;
                }
                pilha.pop(); // desempilha
            }
        }

        if (!pilha.isEmpty()) {
            balanceada = false;
        }

        if (balanceada) {
            System.out.println("Expressão balanceada!");
        } else {
            System.out.println("Expressão NÃO balanceada!");
        }

        scanner.close();
    }
}

