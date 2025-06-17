import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    public static int[] lerNumerosArquivo(String filePath) {
        int lineCount = contarLinhas(filePath);  // Conta linhas válidas (não vazias)
        int[] numbers = new int[lineCount];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    try {
                        numbers[index++] = Integer.parseInt(trimmedLine);
                    } catch (NumberFormatException e) {
                        System.err.println("Linha inválida (não é número): " + trimmedLine);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
        }

        return numbers;
    }

    private static int contarLinhas(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao contar linhas no arquivo " + filePath + ": " + e.getMessage());
        }
        return count;
    }

    public static void printDistribution(int[] distribution) {
        for (int i = 0; i < distribution.length; i++) {
            System.out.printf("  Slot %d: %d chaves%n", i, distribution[i]);
        }
    }
}
