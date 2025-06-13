import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHander {

    public static List<String> readFromFile(String filePath) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    lista.add(trimmedLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
        }
        return lista;
    }

    public static void printDistribution(int[] distribution) {
        for (int i = 0; i < distribution.length; i++) {
            System.out.printf("  Slot %d: %d chaves%n", i, distribution[i]);
        }
    }
}