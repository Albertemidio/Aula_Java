//4 - Busca Binária:
//Implemente um algoritmo de busca binária para encontrar um elemento específico em um array
//ordenado de inteiros. Retorne a posição do número ou -1 se não for encontrado.

public class Atividade_4 {

    public static int buscaBinaria(int[] array, int numero) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (array[meio] == numero) {
                return meio; // encontrou
            } 
            else if (array[meio] < numero) {
                inicio = meio + 1; // busca na direita
            } 
            else {
                fim = meio - 1; // busca na esquerda
            }
        }

        return -1; // não encontrou
    }

    public static void main(String[] args) {

        int[] numeros = {2, 5, 8, 12, 16, 23, 38, 56};

        int numeroProcurado = 23;

        int resultado = buscaBinaria(numeros, numeroProcurado);

        if (resultado != -1) {
            System.out.println("Número encontrado na posição: " + resultado);
        } else {
            System.out.println("Número não encontrado.");
        }
    }
}

