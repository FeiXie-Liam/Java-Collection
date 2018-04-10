package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return array
                .stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array
                .stream()
                .filter(i->i%3==0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        result.addAll(firstList);
        result.retainAll(secondList);
        return result;
    }

    public List<Integer> getDifferentElements() {
        return array
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}