import java.util.*;

public class ForcaBruta extends Mochila {

    public ForcaBruta (List<Item> itens, int capacidade) {

        super (itens, capacidade);

    }

    @Override
    public Solucao solucao() {

        Solucao melhorSolucao = new Solucao();

        melhorSolucao.setItens(new LinkedList<Item>());

        for (List<Item> subConjunto : subConjuntos (itens)) {

            double peso = getPeso(subConjunto);

            if (peso <= capacidade) {

                melhorSolucao.setValor(getValor(subConjunto));

                melhorSolucao.setItens(subConjunto);

                melhorSolucao.setPeso(getPeso(subConjunto));

            }

        }

        melhorSolucao.setNomeSolucao("Força Bruta");

        return melhorSolucao;
    }

    private List<List<Item>> subConjuntos (List<Item> itens) {

        List<List<Item>> subConjuntos = new LinkedList<List<Item>>();

        if (itens.isEmpty()) {

            subConjuntos.add(new LinkedList<Item>());

        } else {

            Item inicio = itens.get(0);

            List<List<Item>> subSubConjuntos = subConjuntos(itens.subList(1, itens.size()));

            for (List<Item> subConjunto : subSubConjuntos) {

                subConjuntos.add(subConjunto);

                List<Item> temporaria = new LinkedList<Item>(subConjunto);

                temporaria.add(0, inicio);

                subConjuntos.add(temporaria);

            }

        }

        return subConjuntos;

    }

}
