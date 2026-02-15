package Projeto_humor;
import java.util.Scanner;

public class AnaliseDeHumor {

    public static void main(String[] args) {

        Scanner X = new Scanner(System.in);

        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        int[] humor = new int[7];

        int soma = 0;
        int melhorDia = 0;
        int piorDia = 0;

        System.out.println("ANALISADOR DE HUMOR DA SEMANA");
        System.out.println("Nota de 0 a 10 para cada dia.\n");

        for (int i = 0; i < dias.length; i++) {
            System.out.print(dias[i] + ": ");
            humor[i] = X.nextInt();

            soma += humor[i];

            if (humor[i] > humor[melhorDia]) {
                melhorDia = i;
            }

            if (humor[i] < humor[piorDia]) {
                piorDia = i;
            }
        }

        double media = (double) soma / humor.length;

        System.out.println("\n=== RESULTADO ===");
        System.out.println("Média da semana: " + media);
        System.out.println("Melhor dia: " + dias[melhorDia] + " (" + humor[melhorDia] + ")");
        System.out.println("Pior dia: " + dias[piorDia] + " (" + humor[piorDia] + ")");

        // Análise automática
        if (media >= 8) {
            System.out.println("Semana incrível! 🔥");
        } else if (media >= 5) {
            System.out.println("Semana razoável 🙂");
        } else {
            System.out.println("Semana difícil... mas vai melhorar 💪");
        }

        // Gráfico simples
        System.out.println("\n=== GRÁFICO DA SEMANA ===");

        for (int i = 0; i < dias.length; i++) {
            System.out.print(dias[i] + ": ");
            for (int j = 0; j < humor[i]; j++) {
                System.out.print("*");
            }
            System.out.println(" (" + humor[i] + ")");
        }

        X.close();
    }
}
