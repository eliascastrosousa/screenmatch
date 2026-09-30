package br.com.alura.projeto.screenmatch.exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class exercicio01 {
    static void main() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().filter(n-> n%2==0).collect(Collectors.toList()).forEach(n-> System.out.println("Lista de numeros pares: " + n));

        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream().map(String::toUpperCase).forEach(System.out::println);

        List<Integer> numeros02 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numeroImpares = numeros02.stream()
                .filter(n-> n%2!=0)
                .map(n-> n*2)
                .collect(Collectors.toList());

        numeroImpares.forEach(System.out::println);

        List<String> palavras02 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        palavras02.stream().distinct().forEach(System.out::println);

        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        listaDeNumeros.stream().flatMap(l-> l.stream()).collect(Collectors.toList()).forEach(System.out::println);



    }
}
