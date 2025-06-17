public class AlgoritimoOrdenar {
    public int[] lista;
    public int tamanho;

    public AlgoritimoOrdenar(int[] lista) {
        this.lista = lista;
        this.tamanho = lista.length;
    }

    public int[] bolhaSort() {
        boolean troca = true;

        while (troca) {  // Percorre a lista inteira enquanto empurra o elemento maior que o atual para direita
            troca = false;
            for (int i = 0; i < tamanho - 1; i++) {
                if (lista[i] > lista[i + 1]) {
                    int atual = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = atual;
                    troca = true;
                }
            }
        }
        return lista;
    }

    public int[] insertSort() {
        for (int i = 1; i < tamanho; i++) { //Começa no segundo elemento
            int atual = lista[i];
            int anterior = i - 1; // Index anterior, não valor anterior

            while (anterior >= 0 && lista[anterior] > atual) { // Empurra o elemento menor que o atual para esquerda
                lista[anterior + 1] = lista[anterior];
                anterior--;
            }
            lista[anterior + 1] = atual; // Se o elemento anterior for maior que o atual, ele é empurrado para direita
        }
        return lista;
    }

    public int[] rapidoSort() {
        quickSort(0, tamanho - 1);// Primeiro e Ultimo elementos
        return lista;
    }

    private void quickSort(int primeiro, int ultimo) {
        if (primeiro < ultimo) {
            int posicaoPivo = particionar(primeiro, ultimo);
            quickSort(primeiro, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, ultimo);
        }
    }

    private int particionar(int primeiro, int ultimo) {
        int pivo = lista[ultimo];
        int ponteiro = primeiro - 1; // O ponteiro será usado para armazenar onde na lista foi a última troca

        for (int i = primeiro; i < ultimo; i++){ // Faz os elementos menores que o pivo irem para esquerda, trocando eles com o inicio/ponteiro
            if (lista[i] <= pivo) {
                ponteiro++;
                int troca = lista[ponteiro];
                lista[ponteiro] = lista[i];
                lista[i] = troca;
            }
        }
        int troca = lista[ponteiro + 1];
        lista[ponteiro + 1] = lista[ultimo];
        lista[ultimo] = troca; // Essa ultima troca deixa o pivo no meio
        return ponteiro + 1;
    }
}
