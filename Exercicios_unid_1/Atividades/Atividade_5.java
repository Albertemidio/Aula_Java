//Exercício 5: Matrizes (Arrays)  
//• Crie uma matriz (array) de números inteiros. Encontre e imprima o maior valor na matriz. 

public class Atividade_5 {
     public static void main(String[] args) {

        // CRIANDO A MATRIZ 3X3
        int[][] matriz = {
            {10, 55, 4},
            {32, 2, 30},
            {5, 60, 18}
        };

        int maiorNumero = matriz[0][0];

       //LENGTH É DO ARRAY - O I PERCORRE AS LINHAS E O J AS COLUNAS
        for (int i = 0; i < matriz.length; i++) { 
            for (int j = 0; j < matriz[i].length; j++) { 
                
                if (matriz[i][j] > maiorNumero) {
                    maiorNumero = matriz[i][j];
                }
            }
        }
        System.out.println("O maior valor da matriz é: " + maiorNumero);
    }
}
