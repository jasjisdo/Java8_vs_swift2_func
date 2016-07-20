

import UIKit

// #1 map array of strings to int array
let strings1:[String] = ["1", "2", "3"]
let ints:[Int] = strings1.map{Int($0)!}
print(ints)

// #2 reduce array of string by concat elements
let strings2:[String] = ["a", "b", "c"]
func concat(accumulator: String, current: String) -> String {
    return accumulator + current
}
let string2:String = strings2.reduce("", combine: concat)
print(string2)

// #3.1 filter non present optionals from array string
let optionals31 : [String?] = ["a", nil, "b", nil, "c", nil]
let nonNilOptionals31 = optionals31.filter{$0 != nil}
print(nonNilOptionals31)

// #3.2 filter non present optionals from array string and map present optional to contained values
let optionals32 : [String?] = ["a", nil, "b", nil, "c", nil]
let nonOptionals32 = optionals32.filter{$0 != nil}.map{$0}
print(nonOptionals32)

// #3.3 (alt) filter non present optionals from array string and map present optional to contained values
let optionals33 : [String?] = ["a", nil, "b", nil, "c", nil]
let nonOptionals33 = optionals33.flatMap{$0}
print(nonOptionals33)

// #4.1 flatMap nested string array to string array
let nestedStrings:[[String]] = [["a", "b", "c"], ["d", "e", "f"]]
let stringArray:[String] = nestedStrings.flatMap{$0}
print(stringArray)

// #4.2 flatMap nested string array to doubled int array
let nestedStrings42:[[String]] = [["1", "2", "3"], ["4", "5", "6"]]
let doubledIntArray:[Int] = nestedStrings42.flatMap{$0.map{Int($0)! * 2}}
print(doubledIntArray)

// #4.3 flatMap array of nested string sets to one string array
var stringSet1 = Set<String>()
stringSet1.insert("a")
stringSet1.insert("b")
stringSet1.insert("c")
var stringSet2 = Set<String>()
stringSet2.insert("1")
stringSet2.insert("2")
stringSet2.insert("3")
var stringSet3 = Set<String>()
stringSet3.insert("x")
stringSet3.insert("y")
stringSet3.insert("z")

let stringSets:[Set<String>] = [stringSet1, stringSet2, stringSet3]
let bigStringArray:[String] = stringSets.flatMap{$0}
print(bigStringArray)



