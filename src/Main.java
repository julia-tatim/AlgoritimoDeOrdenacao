import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void gerarRelatorio(String nomeArquivo, int[] dados) {
        System.out.println("---- Arquivo " + nomeArquivo + " ----");

        // Bubble Sort
        int[] arrBubble = Arrays.copyOf(dados, dados.length);
        AlgoritimoOrdenar bubbleAlg = new AlgoritimoOrdenar(arrBubble);
        long timerStart = System.nanoTime();
        bubbleAlg.bolhaSort();
        long timerEnd = System.nanoTime();
        double tempoBubble = (timerEnd - timerStart) / 1_000_000.0;
        System.out.println("Tempo Bubble Sort: " + tempoBubble + " ms");

        // Insertion Sort
        int[] arrInsert = Arrays.copyOf(dados, dados.length);
        AlgoritimoOrdenar insertAlg = new AlgoritimoOrdenar(arrInsert);
        timerStart = System.nanoTime();
        insertAlg.insertSort();
        timerEnd = System.nanoTime();
        double tempoInsert = (timerEnd - timerStart) / 1_000_000.0;
        System.out.println("Tempo Insertion Sort: " + tempoInsert + " ms");

        // Quick Sort
        int[] arrQuick = Arrays.copyOf(dados, dados.length);
        AlgoritimoOrdenar quickAlg = new AlgoritimoOrdenar(arrQuick);
        timerStart = System.nanoTime();
        quickAlg.rapidoSort();
        timerEnd = System.nanoTime();
        double tempoQuick = (timerEnd - timerStart) / 1_000_000.0;
        System.out.println("Tempo Quick Sort: " + tempoQuick + " ms");

        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Inicializando programa");

        // Lendo arquivos csv
        int[] aleatorio100 = FileHandler.lerNumerosArquivo("src/csv/aleatorio_100.csv");
        int[] aleatorio1000 = FileHandler.lerNumerosArquivo("src/csv/aleatorio_1000.csv");
        int[] aleatorio10000 = FileHandler.lerNumerosArquivo("src/csv/aleatorio_10000.csv");
        int[] crescente100 = FileHandler.lerNumerosArquivo("src/csv/crescente_100.csv");
        int[] crescente1000 = FileHandler.lerNumerosArquivo("src/csv/crescente_1000.csv");
        int[] crescente10000 = FileHandler.lerNumerosArquivo("src/csv/crescente_10000.csv");
        int[] decrescente100 = FileHandler.lerNumerosArquivo("src/csv/decrescente_100.csv");
        int[] decrescente1000 = FileHandler.lerNumerosArquivo("src/csv/decrescente_1000.csv");
        int[] decrescente10000 = FileHandler.lerNumerosArquivo("src/csv/decrescente_10000.csv");

        // Gerando relatórios
        gerarRelatorio("aleatorio_100", aleatorio100);
        gerarRelatorio("aleatorio_1000", aleatorio1000);
        gerarRelatorio("aleatorio_10000", aleatorio10000);

        gerarRelatorio("crescente_100", crescente100);
        gerarRelatorio("crescente_1000", crescente1000);
        gerarRelatorio("crescente_10000", crescente10000);

        gerarRelatorio("decrescente_100", decrescente100);
        gerarRelatorio("decrescente_1000", decrescente1000);
        gerarRelatorio("decrescente_10000", decrescente10000);

        System.out.println("Programa finalizado.");
    }
}
