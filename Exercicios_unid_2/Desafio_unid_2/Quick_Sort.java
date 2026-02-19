package Exercicios_unid_2.Desafio_unid_2;

import java.util.ArrayList;

public class Quick_Sort {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(3);
        numeros.add(25);
        numeros.add(7);
        numeros.add(15);

        System.out.println("Antes da ordenação:");
        System.out.println(numeros);

        quickSort(numeros, 0, numeros.size() - 1);

        System.out.println("Após ordenação decrescente:");
        System.out.println(numeros);
    }

    public static void quickSort(ArrayList<Integer> lista, int inicio, int fim) {

        if (inicio < fim) {

            int posicaoPivo = particionar(lista, inicio, fim);

            quickSort(lista, inicio, posicaoPivo - 1);
            quickSort(lista, posicaoPivo + 1, fim);
        }
    }

    public static int particionar(ArrayList<Integer> lista, int inicio, int fim) {

        int pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {

            // Para ordem DECRESCENTE
            if (lista.get(j) > pivo) {

                i++;

                int temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        int temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, temp);

        return i + 1;
    }
}
