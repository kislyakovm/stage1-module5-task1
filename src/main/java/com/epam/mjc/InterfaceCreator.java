package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        Predicate<List<String>> isValuesStartWithUpperCase = list -> {
            for (String value : list) {
                if (!value.isEmpty() && !Character.isUpperCase(value.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
        return isValuesStartWithUpperCase;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        Consumer<List<Integer>> addEvenValuesAtTheEnd = list -> {
            List<Integer> newList = new ArrayList<>(list);

            for (int i : newList) {
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
        };
        return addEvenValuesAtTheEnd;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String value : values) {
                if (value.matches("[A-Z].*\\.") && value.split("\\s+").length > 3) {
                    filteredList.add(value);
                }
            }
            return filteredList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Function<List<String>, Map<String, Integer>> stringSize = list -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String str : list) {
                resultMap.put(str, str.length());
            }
            return resultMap;
        };
        return stringSize;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList = (list1, list2) -> {
            List<Integer> result = new ArrayList<>();

            result.addAll(list1);
            result.addAll(list2);

            return result;
        };
        return concatList;
    }
}
