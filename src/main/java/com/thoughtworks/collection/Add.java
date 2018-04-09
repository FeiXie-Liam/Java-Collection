package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> l = new ArrayList<>();
        int begin = leftBorder < rightBorder ? leftBorder : rightBorder;
        int end = leftBorder > rightBorder ? leftBorder : rightBorder;
        for (int i = begin; i <= end; i++) {
            l.add(i);
        }
        return l.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, (sum, i) -> sum + i);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> l = new ArrayList<>();
        int begin = leftBorder < rightBorder ? leftBorder : rightBorder;
        int end = leftBorder > rightBorder ? leftBorder : rightBorder;
        for (int i = begin; i <= end; i++) {
            l.add(i);
        }
        return l.stream()
                .filter(i -> i % 2 == 1)
                .reduce(0, (sum, i) -> sum + i);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(i -> 3 * i + 2)
                .reduce(0, (sum, i) -> sum + i);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(i -> {
                    if (i % 2 == 1) {
                        return 3 * i + 2;
                    } else
                        return i;
                })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(i -> i % 2 == 1)
                .map(i -> 3 * i + 5)
                .reduce(0, (sum, i) -> sum + i);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> sortedList = arrayList.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        int mid = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            return (sortedList.get(mid - 1) + sortedList.get(mid)) / 2;
        } else
            return sortedList.get(mid);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenArray = arrayList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        int total=evenArray.stream()
                .reduce(0, (sum, i) -> sum + i);
        return total/evenArray.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        arrayList = arrayList.stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList());
        return arrayList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(i->i%2==0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(i->i%2==0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream()
                .filter(i->i%2==1)
                .sorted()
                .collect(Collectors.toList());
        Collections.reverse(oddList);
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<arrayList.size() - 1;++i){
            result.add((arrayList.get(i)+arrayList.get(i+1))*3);
        }
        return result;
    }
}
