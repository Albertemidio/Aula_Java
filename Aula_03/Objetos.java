public class Objetos {

//ATRIBUTOS
    private String nome;
    private int idade;
    private float peso;

//CONSTRUTOR
public Objetos(String nome, int idade, float peso){
    this.nome = nome;
    this.idade = idade;
    this.peso = peso;

}

//METODO
public void exibirInfo(){
    System.out.println("Nome: "+nome);
    System.out.println("Idade: "+idade);
    System.out.println("Peso: "+peso);
}

public static void main(String[]args){
    Objetos pessoa = new Objetos("Albert", 24, 65.5f);

    pessoa.exibirInfo();
}

}
