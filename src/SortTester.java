public class SortTester {
    public static void testAlgorithm(SortAlgorithm algorithm, int[] data) {
        int[] dataCopy = data.clone();

        long startTime = System.nanoTime();
        algorithm.sort(dataCopy);
        long endTime = System.nanoTime();

        double durationMs = (endTime - startTime) / 1_000_000.0;
        System.out.printf("%s: %.3f ms%n", algorithm.getAlgorithmName(), durationMs);
    }
}