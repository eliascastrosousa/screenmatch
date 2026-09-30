package br.com.alura.projeto.screenmatch.exercicios;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class exercicio02 {
    static void main() {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        IntSummaryStatistics statistics = numeros.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());


    }
}
