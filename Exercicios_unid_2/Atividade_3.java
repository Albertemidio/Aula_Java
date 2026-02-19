//3 - Mesclar Listas:
//Implemente uma função que receba duas ArrayLists e retorne uma nova lista que contenha todos os
//elementos das listas originais intercalados.

package Exercicios_unid_2;
 import java.util.ArrayList;

public class Atividade_3 {
    
    public static ArrayList<Integer> intercalarListas(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> novaLista = new ArrayList<>();

        int i = 0;

        // Enquanto ainda houver elementos em pelo menos uma das listas
        while (i < lista1.size() || i < lista2.size()) {

            if (i < lista1.size()) {
                novaLista.add(lista1.get(i));
            }

            if (i < lista2.size()) {
                novaLista.add(lista2.get(i));
            }

            i++;
        }

        return novaLista;
    }

    public static void main(String[] args) {

        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        lista2.add(8); // lista2 maior

        ArrayList<Integer> resultado = intercalarListas(lista1, lista2);

        System.out.println("Lista intercalada: " + resultado);
    }
}

