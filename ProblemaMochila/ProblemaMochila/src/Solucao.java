import java.util.*;

public class Solucao {

    private String nomeSolucao;
    private List<Item> itens;
    private double peso;
    private double valor;

    public String getNomeSolucao() {
        return nomeSolucao;
    }

    public void setNomeSolucao(String nomeSolucao) {
        this.nomeSolucao = nomeSolucao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {

        StringBuilder mensagem = new StringBuilder();

        mensagem.append(nomeSolucao + " Peso = " + peso + ": Valor = " + valor + "\n");

        Collections.sort(itens, Item.comparaPorIndice());

        mensagem.append("Itens = {\n");

        double somaValor = 0.0;

        double somaPeso = 0.0;

        for (Item item : itens) {

            mensagem.append(item.getIndice() + " ");

            mensagem.append("[");

            mensagem.append("Indice: " + item.getIndice() + ", ");

            mensagem.append("Peso: " + item.getPeso() + ", ");

            mensagem.append("Valor: " + item.getValor());

            mensagem.append("]\n");

            somaPeso += item.getPeso();

            somaValor += item.getValor();

        }

        mensagem.append("}\n\n");

        mensagem.append("Soma dos Pesos: " + somaPeso + " Soma dos Valores: " + somaValor + "\n");

        return mensagem.toString();
    }
}
