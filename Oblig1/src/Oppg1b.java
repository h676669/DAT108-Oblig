public class Oppg1b {

    public static void main(String[] args) {
        System.out.println(beregn(12, 13, (a, b) -> a + b));
        System.out.println(beregn(-5, 3, (a, b) -> Math.max(a, b)));
        System.out.println(beregn(54, 45, (a, b) -> Math.abs(a - b)));
    }

    public static int beregn(int a, int b, Operasjon o) {
        return o.operer(a, b);
    }

    @FunctionalInterface
    interface Operasjon {
        public int operer(int a, int b);
    }
}


