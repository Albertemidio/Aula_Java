import java.util.Scanner;

public class Pessoas {

    // ATRIBUTOS
    private String nome;
    private int idade;
    private float peso;

    // CONSTRUTOR
    public Pessoas(String nome, int idade, float peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    // METODO
    public void exibirInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
        System.out.println("----------------------");
    }

    // METODO ATUALIZA ANIVERSARIO
    public void aniversario(){
        this.idade = this.idade + 1;
    }

    // GETTERS
    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public float getPeso(){
        return this.peso;
    }

    // SETTERS
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setPeso(float peso){
        this.peso = peso;
    }

    public static void main(String[] args){

        Scanner x = new Scanner(System.in);

        Pessoas pessoa = new Pessoas("Albert", 24, 65.5f);

        pessoa.exibirInfo();
        pessoa.aniversario();
        pessoa.exibirInfo();

        // ENTRADA DO USUÁRIO
        System.out.println("Digite o nome: ");
        String nome = x.nextLine();

        System.out.println("Digite a Idade: ");
        int idade = Integer.parseInt(x.nextLine());

        System.out.println("Digite o Peso: ");
        float peso = Float.parseFloat(x.nextLine());

        Pessoas pessoa2 = new Pessoas(nome, idade, peso);

        pessoa2.exibirInfo();

        x.close(); // fecha o scanner
    }
}
