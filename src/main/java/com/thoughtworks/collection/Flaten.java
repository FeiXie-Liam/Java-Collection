package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(array).map(x -> Arrays.stream(x)).flatMap(x -> x).collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Arrays
                .stream(array)
                .map(x -> Arrays.stream(x))
                .flatMap(x -> x)
                .distinct()
                .collect(Collectors.toList());
    }
}
