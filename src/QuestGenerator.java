public class QuestGenerator {
    public static String generateSequence(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            double t = n == 1 ? 1 : (double) i / (n - 1);
            double probability = 0.5 + 0.5 * Math.sin(Math.PI * (t - 0.5));
            result = result.concat((getDeterministicValue(i, n) >= probability - 0.01) ? "b" : "s");
        }
        return result;
    }

    private static double getDeterministicValue(int index, int length) {
        return (double) (index * 37 + length) % (length - 1) / (length);
    }

    public static void main(String[] args) {
        int n = 100;
        String sequence = generateSequence(n);
        System.out.println(sequence);
    }
}
