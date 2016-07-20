

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

// #3.2 (alt) filter non present optionals from array string and map present optional to contained values
let optionals33 : [String?] = ["a", nil, "b", nil, "c", nil]
let nonOptionals33 = optionals33.flatMap{$0}
print(nonOptionals33)


