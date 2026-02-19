package Projeto;

import java.util.List;

public class Pedido {

    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    // GETTERS 

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    //  SETTER 
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //  CÁLCULO DE FRETE 

    public double calcularFrete(double distanciaKm) {

        double fretePorKm = distanciaKm * 2.0;      // R$2 por km
        double fretePorQuantidade = pizzas.size() * 1.5; // R$1,50 por pizza

        return fretePorKm + fretePorQuantidade;
    }
}
