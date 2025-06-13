import java.util.List;

public class Main {
    public static void lerArquivos(String caminho) {
        List<String> numeros = FileHander.readNamesFromFile(caminho);

        if (numeros.isEmpty()) {
            System.err.println("Nenhum nome foi lido do arquivo. Verifique o caminho ou conteúdo do arquivo.");
        } else {
            System.out.println("Total de " + numeros.size() + " numeros lidos do arquivo.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Inicializando programa");

        lerArquivos("caminho/do/arquivo.txt");
    }
}
