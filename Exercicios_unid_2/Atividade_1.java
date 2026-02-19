//1 - Inversão de Lista:
//Escreva um programa para inverter os elementos de um ArrayList sem usar métodos prontos do java

package Exercicios_unid_2;

import java.util.ArrayList;

public class Atividade_1 {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);

        System.out.println("Lista original: " + lista);

        int inicio = 0;
        int fim = lista.size() - 1;

        while (inicio < fim) {

            int temp = lista.get(inicio);
            lista.set(inicio, lista.get(fim));
            lista.set(fim, temp);

            inicio++;
            fim--;
        }

        System.out.println("Lista invertida: " + lista);
    }
}


