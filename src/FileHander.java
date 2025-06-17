import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHander {

    public static List<Integer> readFromFile(String filePath) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    continue;
                }

                if (isFirstLine && !isNumeric(trimmedLine)) {
                    isFirstLine = false;
                    continue;
                }

                try {
                    numeros.add(Integer.parseInt(trimmedLine));
                } catch (NumberFormatException e) {
                    System.err.println("Valor não numérico ignorado: " + trimmedLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
        }
        return numeros;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}