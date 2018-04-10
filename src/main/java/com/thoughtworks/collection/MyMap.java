package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(x -> 3 * x).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(x -> (Character.toString((char) (x + 96)))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(x -> {
                    StringBuilder a = new StringBuilder();
                    List<Integer> listArray = new ArrayList<>();
                    while (x != 0 || x % 26 != 0) {
                        x= x-1;
                        listArray.add(x%26);
                        x = x / 26;
                    }
                    Collections.reverse(listArray);
                    for (Integer i:listArray) {
                        a.append(letters[i]);
                    }
                    return a.toString();
        })
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List<Integer> collect = array.stream().sorted().collect(Collectors.toList());
        Collections.reverse(collect);
        return collect;
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
