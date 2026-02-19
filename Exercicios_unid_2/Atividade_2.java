//2 - Remoção de Elementos Duplicados:
//Crie um método para remover elementos duplicados de um ArrayList

package Exercicios_unid_2;
import java.util.ArrayList;

public class Atividade_2 {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(10);
        lista.add(20);
        lista.add(10);
        lista.add(30);
        lista.add(20);
        lista.add(40);

        System.out.println("Lista original: " + lista);

        removerDuplicados(lista);

        System.out.println("Lista sem duplicados: " + lista);
    }

    public static void removerDuplicados(ArrayList<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {

            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(i).equals(lista.get(j))) {
                    lista.remove(j);
                    j--; // ajusta o índice após remover
                }

            }
        }
    }
}
