package de.dailab.schaufenster.nanu.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by domann on 21.07.16.
 */
public class Java8StreamMapReduce {

    @SafeVarargs
    public static <E> List<E> asList(E... elements) {
        return Arrays.asList(elements);
    }

    @SafeVarargs
    public static <E> Stream<E> asStream(E... elements) {
        return Arrays.stream(elements);
    }

    public static void main(String... args) {

        // #1 map array (list) of strings to int array (list)
        ArrayList<String> strings1 = new ArrayList<>(asList("1", "2", "3"));
        ArrayList<Integer> ints = strings1.stream().map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(ints);

        // #2 reduce array of string by concat elements
        ArrayList<String> strings2 = new ArrayList<>(asList("a", "b", "c"));
        String string2 = strings2.stream().reduce(String::concat).orElse("");
        System.out.println(string2);

        // #3.1 filter non present optionals from array string
        ArrayList<Optional<String>> optionals31 = new ArrayList<>(asList(Optional.of("a"), Optional.empty(),
                Optional.of("b"), Optional.empty(), Optional.of("c"), Optional.empty()));
        ArrayList<Optional<String>> nonNilOptionals31 = optionals31.stream().filter(Optional::isPresent)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(nonNilOptionals31);

        // #3.2 filter non present optionals from array string and map present optional to contained values
        ArrayList<Optional<String>> optionals32 = new ArrayList<>(asList(Optional.of("a"), Optional.empty(),
                Optional.of("b"), Optional.empty(), Optional.of("c"), Optional.empty()));
        ArrayList<String> nonOptionals32 = optionals32.stream().filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(nonOptionals32);

        // #3.3 (alt) filter non present optionals from array string and map present optional to contained values
        ArrayList<Optional<String>> optionals33 = new ArrayList<>(asList(Optional.of("a"), Optional.empty(),
                Optional.of("b"), Optional.empty(), Optional.of("c"), Optional.empty()));
        ArrayList<String> nonOptionals33 = optionals32.stream().filter(Optional::isPresent).flatMap(o -> asStream(o.orElse(null)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(nonOptionals33);

        // #4.1 flatMap nested string array to string array
        ArrayList<List<String>> nestedStrings = new ArrayList<>(asList(asList("a", "b", "c"), asList("d", "e", "f")));
        ArrayList<String> stringArray = nestedStrings.stream().flatMap(Collection::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(stringArray);

        // #4.2 flatMap nested string array to doubled int array
        ArrayList<List<String>> nestedStrings42 = new ArrayList<>(asList(asList("1", "2", "3"), asList("4", "5", "6")));
        ArrayList<Integer> doubledIntArray = nestedStrings42.stream().flatMap(Collection::stream).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(doubledIntArray);

        // #4.3 flatMap array of nested string sets to one string array
        Set<String> stringSet1 = new HashSet<>();
        stringSet1.add("a");
        stringSet1.add("b");
        stringSet1.add("c");
        Set<String> stringSet2 = new HashSet<>();
        stringSet2.add("1");
        stringSet2.add("2");
        stringSet2.add("3");
        Set<String> stringSet3 = new HashSet<>();
        stringSet3.add("x");
        stringSet3.add("y");
        stringSet3.add("z");
        ArrayList<Set<String>> stringSets = new ArrayList<>(asList(stringSet1, stringSet2, stringSet3));
        ArrayList<String> bigStringArray = stringSets.stream().flatMap(Collection::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(bigStringArray);
    }
}
