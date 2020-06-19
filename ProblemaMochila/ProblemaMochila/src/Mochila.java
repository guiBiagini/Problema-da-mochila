import java.util.*;

public abstract class Mochila {

    protected List<Item> itens;
    protected int capacidade;

    protected Mochila(List<Item> itens, int capacidade) {

        this.itens = itens;

        this.capacidade = capacidade;

    }

    public abstract Solucao solucao ();

    public double getPeso (List<Item> itens) {

        double peso = 0.0;

        for (Item item : itens) {

            peso += item.getPeso();

        }

        return peso;

    }

    public double getValor (List<Item> itens) {

        double valor = 0.0;

        for (Item item : itens) {

            valor += item.getValor();

        }

        return  valor;
    }
}
