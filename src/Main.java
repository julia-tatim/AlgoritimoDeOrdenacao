import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Análise de Algoritmos de Ordenação!");

        String[] testFiles = {
                "src/csv/aleatorio_100.csv",
                "src/csv/aleatorio_1000.csv",
                "src/csv/aleatorio_10000.csv",
                "src/csv/crescente_100.csv",
                "src/csv/crescente_1000.csv",
                "src/csv/crescente_10000.csv",
                "src/csv/decrescente_100.csv",
                "src/csv/decrescente_1000.csv",
                "src/csv/decrescente_10000.csv"
        };

        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new QuickSort()
        };

        for (String file: testFiles) {
            System.out.println("\n Processando: " + file);

            List<Integer> integerData = FileHander.readFromFile(file);

            int[] data = integerData.stream().mapToInt(i -> i).toArray();

            for (SortAlgorithm algorithm : algorithms) {
                SortTester.testAlgorithm(algorithm, data);
            }
        }
    }
}
