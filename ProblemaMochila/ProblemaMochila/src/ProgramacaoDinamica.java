//import com.sun.prism.shader.FillCircle_Color_AlphaTest_Loader;

import java.util.*;

public class ProgramacaoDinamica extends Mochila {

    private double [][] tabela;

    public ProgramacaoDinamica(List<Item> itens, int capacidade) {

        super(itens, capacidade);

    }

    @Override
    public Solucao solucao() {

        // Cria a tabela
        tabela = new double[capacidade + 1][itens.size()];

        // Inicia a tabela com todos os valores iguais a -1
        for (int i = 0; i < capacidade + 1; ++ i)
            for (int j = 0; j < itens.size(); ++ j)
                tabela [i][j] = -1;

        // Recupera o algoritimo elemento
        retornaElemento(capacidade, itens.size() - 1);

        // A solução  obtida percorrendo a tabela
        Solucao melhorSolucao = percorreTabela();

        melhorSolucao.setNomeSolucao("Programação Dinâmica");

        return melhorSolucao;
    }

    private Solucao percorreTabela() {

        Solucao melhorSolucao = new Solucao();

        melhorSolucao.setItens(new ArrayList<Item>());

        int i = capacidade;

        int j = itens.size() - 1;

        while (j >= 0) {

            Item itemAtual = itens.get(j);

            double sem = j == 0 ? 0 : tabela[i][j - 1];

            if (tabela[i][j] != sem) {

                melhorSolucao.getItens().add(itemAtual);

                melhorSolucao.setValor(itemAtual.getValor());

                melhorSolucao.setPeso(itemAtual.getPeso());

                i -= (int) itemAtual.getPeso();
            }

            -- j;

        }


        return melhorSolucao;
    }

    private double retornaElemento(int i, int j) {

        // Condição de parada da recurssão
        if (i < 0 || j < 0)
            return 0;

        Item itemAtual = itens.get(j);

        double com, sem, elemento = tabela [i][j];

        // O elemento ainda não foi memorizado
        if (elemento == -1) {

            if (itemAtual.getPeso() > i)
                com = -1;
            else
                com = itemAtual.getValor() + retornaElemento(i - (int) itemAtual.getPeso(), j - 1);

            sem = retornaElemento(i, j - 1);

            elemento = Math.max(com, sem);

            // Elemento memorizado
            tabela[i][j] = elemento;
        }

        return elemento;
    }
}
