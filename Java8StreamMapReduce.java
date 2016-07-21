package de.dailab.schaufenster.nanu.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by domann on 21.07.16.
 */
public class Java8StreamMapReduce {

    public static <E> List<E> asList(E... elements) {
        return Arrays.asList(elements);
    }

    public static void main(String... args) {

        // #1 map array (list) of strings to int array (list)
        ArrayList<String> strings1 = new ArrayList<>(asList("1", "2", "3"));
        ArrayList<Integer> ints = strings1.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        System.out.println(ints);

        // #2 reduce array of string by concat elements
        ArrayList<String> strings2 = new ArrayList<>(asList("a", "b", "c"));
        String string2 = strings2.stream().reduce(String::concat).orElse("");
        System.out.println(string2);

        // #3.1 filter non present optionals from array string
        ArrayList<Optional<String>> strings31 = new ArrayList<>(
                asList(Optional.ofNullable("a"),
                        Optional.empty(),
                        Optional.ofNullable("b"),
                        Optional.empty(),
                        Optional.ofNullable("c"),
                        Optional.empty()
                )
        );
    }
}
