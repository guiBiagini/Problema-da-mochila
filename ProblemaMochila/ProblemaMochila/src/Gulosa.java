import java.util.*;

public class Gulosa extends Mochila {

    public Gulosa (List<Item> itens, int capacidade) {

        super (itens, capacidade);

    }

    @Override
    public Solucao solucao() {

        Solucao melhorSolucaoEncontrada = new Solucao();

        melhorSolucaoEncontrada.setItens(new ArrayList<Item>(itens));

        Collections.sort(melhorSolucaoEncontrada.getItens(), Item.comparaPorRazao());

        double capacidadeUtilizada = 0.0;

        double valor = 0.0;

        int indice = 0;

        Item itemAtual;

        do {

            itemAtual = melhorSolucaoEncontrada.getItens().get(indice);

            if (capacidadeUtilizada + itemAtual.getPeso() <= capacidade) {

                capacidadeUtilizada += itemAtual.getPeso();

                valor += itemAtual.getValor();

                indice ++;

            }

        } while (indice < melhorSolucaoEncontrada.getItens().size() &&
                capacidadeUtilizada + itemAtual.getPeso() <= capacidade);


        melhorSolucaoEncontrada.setItens(melhorSolucaoEncontrada.getItens().subList(0, indice));

        melhorSolucaoEncontrada.setPeso(capacidadeUtilizada);

        melhorSolucaoEncontrada.setValor(valor);

        melhorSolucaoEncontrada.setNomeSolucao("Solução Gulosa (Não é necessariamente Otima)");

        return melhorSolucaoEncontrada;

    }
}
