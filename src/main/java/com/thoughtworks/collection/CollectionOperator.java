package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> l = new ArrayList<>();
        int begin = left < right ? left : right;
        int end = left > right ? left : right;
        for (int i = begin; i <= end; i++) {
            l.add(i);
        }
        if (left > right)
            Collections.reverse(l);
        return l;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> l = new ArrayList<>();
        int begin = left < right ? left : right;
        int end = left > right ? left : right;
        for (int i = begin; i <= end; i++) {
            l.add(i);
        }
        l = l.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        if (left > right)
            Collections.reverse(l);
        return l;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays
                .stream(array)
                .boxed()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

    }

    public int popLastElment(int[] array) {
        List<Integer> listArray = Arrays
                .stream(array)
                .boxed()
                .collect(Collectors.toList());
        return listArray.get(listArray.size()-1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> arrayList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        arrayList.retainAll(Arrays.stream(secondArray).boxed().collect(Collectors.toList()));
        return arrayList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> arrayList = Arrays.stream(firstArray).collect(Collectors.toList());
        for (int i = 0; i < secondArray.length; i++) {
            if(!arrayList.contains(secondArray[i]))
                arrayList.add(secondArray[i]);
        }
        return arrayList;
    }
}
