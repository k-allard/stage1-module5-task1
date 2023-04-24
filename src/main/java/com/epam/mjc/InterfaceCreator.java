package com.epam.mjc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String str : strings) {
                if (!Character.isLetter(str.charAt(0))
                        || Character.isLowerCase(str.charAt(0)))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> addition = new LinkedList<>();
            for (Integer integer : integers) {
                if (integer % 2 == 0)
                    addition.add(integer);
            }
            integers.addAll(addition);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(s -> Character.isLowerCase(s.charAt(0))
                    || s.charAt(s.length() - 1) != '.'
                    || s.split(" ").length < 4);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> res = new HashMap<>();
            for (String str : strings)
                res.put(str, str.length());
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> res = new LinkedList<>(integers);
            res.addAll(integers2);
            return res;
        };
    }
}
