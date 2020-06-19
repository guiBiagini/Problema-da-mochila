import java.time.LocalTime;
import java.util.*;

public class Item {

    private long indice;
    private double valor;
    private double peso;

    public Item(long indice, double valor, double peso) {

        this.indice = indice;

        this.valor = valor;

        this.peso = peso;

    }

    public long getIndice() {
        return indice;
    }

    public void setIndice(long indice) {
        this.indice = indice;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getRazao() {

        return valor / peso;

    }

    public static List<Item> geraItensAleatoriamente(long n){

        List<Item> novaLista = new LinkedList<Item>();

        Random numeroAleatorio = new Random(LocalTime.now().getNano());

        int valorMaximo = 25;

        int pesoMaximo = 12;

        for (long i = 0; i < n; i++) {

            int peso = 1 + numeroAleatorio.nextInt(pesoMaximo);

            int valor = (1 + peso / 4) * (1 + numeroAleatorio.nextInt(valorMaximo));

            Item item = new Item (i, valor, peso);

            novaLista.add(item);
        }

        return novaLista;
    }

    public static void imprimeLista(List<Item> itens) {

        Collections.sort(itens, Item.comparaPorIndice());

        System.out.println("Itens = {");

        for (Item item : itens) {

            System.out.print("[");

            System.out.print("Indice: " + item.getIndice() + ", ");

            System.out.print("Peso: " + item.getPeso() + ", ");

            System.out.print("Valor: " + item.getValor());

            System.out.println("]");

        }

        System.out.print("}\n");
    }

    public static Comparator<Item> comparaPorRazao() {

        return new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {

                return Double.compare(o2.getRazao(), o1.getRazao());

            }

        };

    }

    public static Comparator<Item> comparaPorIndice() {

        return new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {

                return (int) (o1.indice - o2.indice);

            }

        };

    }

}
