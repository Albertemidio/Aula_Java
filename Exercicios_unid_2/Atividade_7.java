//7 - Ordem de Chegada:
//Crie um programa para simular a ordem de chegada de elementos em uma fila e exiba a ordem de saída.

package Exercicios_unid_2;
import java.util.LinkedList;
import java.util.Queue;
public class Atividade_7 {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.add(1);
        fila.add(2);
        fila.add(3);
        fila.add(4);
        fila.add(5);

        System.out.println("Ordem de chegada dos elementos na fila: " + fila);

        
        System.out.print("Ordem de saída dos elementos na fila: ");
        while (!fila.isEmpty()) {
            System.out.print(fila.poll() + " ");
        }
    }
}

