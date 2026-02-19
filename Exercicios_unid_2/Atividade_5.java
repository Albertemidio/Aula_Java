//5 - Inversão com Pilha:
//Implemente um método para inverter a ordem dos elementos em um ArrayList utilizando uma pilha.

package Exercicios_unid_2;
import java.util.ArrayList;
import java.util.Stack;

public class Atividade_5 {
    public static void inverterLista(ArrayList<Integer> lista) {
        Stack<Integer> pilha = new Stack<>();

        // Coloca todos os elementos da lista na pilha
        for (int i = 0; i < lista.size(); i++) {
            pilha.push(lista.get(i));
        }

        // Retira da pilha e coloca de volta na lista (invertendo)
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, pilha.pop());
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);

        System.out.println("Lista original: " + numeros);

        inverterLista(numeros);

        System.out.println("Lista invertida: " + numeros);
    }
}
