import javax.swing.plaf.synth.SynthSeparatorUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {

        final long QUANTIDADE_ITENS = 2500;

        System.out.println("Problema da Mochila");
        System.out.println("-------------------");

        System.out.println();
        System.out.println();

        List<Item> itens = Item.geraItensAleatoriamente(QUANTIDADE_ITENS);

       // Item.imprimeLista(itens);

        int capacidade = 1000;

        System.out.println("Capacidade da mochila: " + capacidade);

        System.out.println();

        System.out.println("Soluções: ");

        System.out.println();

        // Cria um array para armazenar as chamadas soluções
        List<Mochila> solucoes = new ArrayList<Mochila>();

        // Adiciona a solução por força bruta
        if (QUANTIDADE_ITENS <= 20)
            solucoes.add(new ForcaBruta(itens, capacidade));

        // Adiciona a solução gulosa
        solucoes.add(new Gulosa(itens, capacidade));

        // Adiciona programação dinâmica
        
        solucoes.add(new ProgramacaoDinamica(itens, capacidade));

        // Cria um formato de data e hora para melhor exibição
        DateFormat horaFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Para cada solução que foi adicionada no array
        for (Mochila solucao : solucoes) {

            // Tempo inicial da solução
            long tempoInicialForcaBruta = System.nanoTime();
            Date dataHoraInicial = new Date();
            String horaInicial = horaFormatada.format(dataHoraInicial);

            // Execução da Solução
            Solucao resposta = solucao.solucao();

            // Tempo Final da solução
            long tempoFinalForcaBruta = System.nanoTime();
            Date dataHoraFinal = new Date();
            String horaFinal = horaFormatada.format(dataHoraFinal);

            // Impressão da solução
            System.out.println(resposta);

            // Impressão dos tempos
            System.out.println("Tempo inicial : " + horaInicial);
            System.out.println("Tempo final: " + horaFinal);
            System.out.println ("Tempo decorrido: " + (tempoFinalForcaBruta - tempoInicialForcaBruta) / 1000000 + "mseg");

            System.out.println();
            System.out.println();

        }

    }
}
