//Exercício 2: Estruturas Condicionais  
//• Escreva um programa que leia um número e determine se ele é par ou ímpar. Imprima o 
//resultado na tela.  

import java.util.Scanner;

public class Atividade_2 {
   public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = x.nextInt();

        //RESTO DA DIVISÃO
        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é PAR.");
        } else {
            System.out.println("O número " + numero + " é ÍMPAR.");
        }

         x.close();
    }
}

