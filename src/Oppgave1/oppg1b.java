package Oppgave1;

import java.util.function.BiFunction;

public class oppg1b {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> maksFunksjon = (a, b) -> Math.max(a, b);
        BiFunction<Integer, Integer, Integer> avstandFunksjon = (a, b) -> Math.abs(a - b);
        int sum = beregn(12, 13, summerFunksjon);
        int maks = beregn(-5, 3, maksFunksjon);
        int abs = beregn(54, 45, avstandFunksjon);
        System.out.println(sum);
        System.out.println(maks);
        System.out.println(abs);
    }

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> op) {
        return op.apply(a, b);
    }
}
