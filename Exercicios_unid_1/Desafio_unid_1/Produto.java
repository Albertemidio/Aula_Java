package Desafio_unid_1;

public class Produto {

    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void exibirProduto() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço: R$ " + preco);
        System.out.println("----------------------------");
    }
}
 

