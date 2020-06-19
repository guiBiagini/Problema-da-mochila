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

        System.out.println("Solu��es: ");

        System.out.println();

        // Cria um array para armazenar as chamadas solu��es
        List<Mochila> solucoes = new ArrayList<Mochila>();

        // Adiciona a solu��o por for�a bruta
        if (QUANTIDADE_ITENS <= 20)
            solucoes.add(new ForcaBruta(itens, capacidade));

        // Adiciona a solu��o gulosa
        solucoes.add(new Gulosa(itens, capacidade));

        // Adiciona programa��o din�mica
        
        solucoes.add(new ProgramacaoDinamica(itens, capacidade));

        // Cria um formato de data e hora para melhor exibi��o
        DateFormat horaFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Para cada solu��o que foi adicionada no array
        for (Mochila solucao : solucoes) {

            // Tempo inicial da solu��o
            long tempoInicialForcaBruta = System.nanoTime();
            Date dataHoraInicial = new Date();
            String horaInicial = horaFormatada.format(dataHoraInicial);

            // Execu��o da Solu��o
            Solucao resposta = solucao.solucao();

            // Tempo Final da solu��o
            long tempoFinalForcaBruta = System.nanoTime();
            Date dataHoraFinal = new Date();
            String horaFinal = horaFormatada.format(dataHoraFinal);

            // Impress�o da solu��o
            System.out.println(resposta);

            // Impress�o dos tempos
            System.out.println("Tempo inicial : " + horaInicial);
            System.out.println("Tempo final: " + horaFinal);
            System.out.println ("Tempo decorrido: " + (tempoFinalForcaBruta - tempoInicialForcaBruta) / 1000000 + "mseg");

            System.out.println();
            System.out.println();

        }

    }
}
