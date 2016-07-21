# Java8_vs_swift2_func
Comparison of Java8 and Swift2 mapReduce functions

## preface
I try to compare the usage of map reduce functions of java8 and swift. To simplify the java code I used the following extra (or cheating) methods to hold the examples similar as possible.

```java
@SafeVarargs
public static <E> List<E> asList(E... elements) {
    return Arrays.asList(elements);
}

@SafeVarargs
public static <E> Stream<E> asStream(E... elements) {
    return Arrays.stream(elements);
}
```
The first method `asList` is used to create a List in one line like in [google guava library](https://google.github.io/guava/releases/19.0/api/docs/com/google/common/collect/Lists.html#newArrayList(E...)). The second method `asStream` is used to create a zero, one or more elements containing java8 stream.

relevant code:
* [swift2](https://github.com/jasjisdo/Java8_vs_swift2_func/blob/master/Swift2MapReduce.playground/Contents.swift)
* [java8](https://github.com/jasjisdo/Java8_vs_swift2_func/blob/master/Java8StreamMapReduce.java)

## 1. map strings to ints

### Swift 2.0:

map array of strings to int array
```swift
let strings1:[String] = ["1", "2", "3"]
let ints:[Int] = strings1.map{Int($0)!}
print(ints)
```

### Java8 Stream API:

map array (list) of strings to int array (list)
```java
ArrayList<String> strings1 = new ArrayList<>(asList("1", "2", "3"));
ArrayList<Integer> ints = strings1.stream().map(Integer::parseInt)
    .collect(Collectors.toCollection(ArrayList::new));
System.out.println(ints);
```

### comment
