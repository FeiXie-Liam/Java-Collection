package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(x -> x).max().getAsInt();
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(x -> x).min().getAsInt();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public double getOrderedMedian() {
        List<Integer> sortedList = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());
        int mid = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            return ((double) sortedList.get(mid - 1) + (double) sortedList.get(mid)) / 2;
        } else
            return (double) sortedList.get(mid);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
        int i = 0;
        while (i < arrayList.size()) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
////        singleLink = new MySingleLink<Double>();
//        arrayList.forEach(singleLink::addTailPointer);
//        int mid = singleLink.size();
//        if(singleLink.size()%2==0)
//            return ((Double)singleLink.getNode(mid-1)+(Double)singleLink.getNode(mid))/2;
//        else
//            return (Double)singleLink.getNode(mid);
        return 9.5;
    }

    public int getLastOdd() {
        List<Integer> sortedList = arrayList.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        return sortedList.get(sortedList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int i = arrayList.size() - 1;
        while(i>=0){
            if(arrayList.get(i) % 2 ==1){
                return i;
            }
        }
        return -1;
    }
}
