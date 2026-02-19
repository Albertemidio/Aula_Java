//8 - Contagem de Palavras:
//Escreva um programa que conte a frequência das palavras em uma frase utilizando um HashMap. 

package Exercicios_unid_2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Atividade_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();

        String[] palavras = frase.split(" ");
        HashMap<String, Integer> contagem = new HashMap<>();

        for (String palavra : palavras) {

            if (contagem.containsKey(palavra)) {
                // Se já existe, aumenta 1
                contagem.put(palavra, contagem.get(palavra) + 1);
            } else {
                // Se não existe, coloca 1
                contagem.put(palavra, 1);
            }
        }

        System.out.println("\nFrequência das palavras:");
        for (Map.Entry<String, Integer> entrada : contagem.entrySet()) {
            System.out.println(entrada.getKey() + " = " + entrada.getValue());
        }

        scanner.close();
    }
}

