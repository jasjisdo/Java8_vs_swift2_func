# Java8_vs_swift2_func
Comparison of Java8 and Swift2 mapReduce functions

## 1 map strings to ints

### Swift 2.0:

map array of strings to int array
```
let strings1:[String] = ["1", "2", "3"]
let ints:[Int] = strings1.map{Int($0)!}
print(ints)
```

### Java8 Stream API:
```
ArrayList<String> strings1 = new ArrayList<>(asList("1", "2", "3"));
ArrayList<Integer> ints = strings1.stream().map(s -> Integer.parseInt(s))
        .collect(Collectors.toCollection(() -> new ArrayList<>()));
System.out.println(ints);
```

### comment
