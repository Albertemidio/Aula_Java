//1 - Implementação da Árvore Binária:
//Crie uma classe em Java para representar uma árvore binária e implemente métodos para inserir
//elementos, percorrer a árvore em pré-ordem, pós-ordem e em ordem.

    // Classe da Árvore Binária
class ArvoreBinaria {

    // Classe interna para representar o nó
    class No {
        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
            esquerda = null;
            direita = null;
        }
    }

    private No raiz;

    // Método para inserir elemento
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }

        return atual;
    }

    // Percurso Em Ordem (Esquerda -> Raiz -> Direita)
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.print(atual.valor + " ");
            emOrdemRec(atual.direita);
        }
    }

    // Percurso Pré-Ordem (Raiz -> Esquerda -> Direita)
    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No atual) {
        if (atual != null) {
            System.out.print(atual.valor + " ");
            preOrdemRec(atual.esquerda);
            preOrdemRec(atual.direita);
        }
    }

    // Percurso Pós-Ordem (Esquerda -> Direita -> Raiz)
    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(No atual) {
        if (atual != null) {
            posOrdemRec(atual.esquerda);
            posOrdemRec(atual.direita);
            System.out.print(atual.valor + " ");
        }
    }
}

public class Atividade_1 {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo valores
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Percurso Em Ordem:");
        arvore.emOrdem();

        System.out.println("Percurso Pré-Ordem:");
        arvore.preOrdem();

        System.out.println("Percurso Pós-Ordem:");
        arvore.posOrdem();
    }
}

