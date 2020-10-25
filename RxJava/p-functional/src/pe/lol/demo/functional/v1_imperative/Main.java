package pe.lol.demo.functional.v1_imperative;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        List<Integer> numbers = allNumbers();
        System.out.println("ALL NUMBERS ==> " + numbers);

        List<Integer> pairs = numbersPairs(numbers);
        System.out.println("PAIRS NUMBERS ==> " + pairs);

        List<Integer> squared = numbersSquared(pairs);
        System.out.println("NUMBERS SQUARED ==> " + squared);

        List<Integer> only = showNumbers(squared);

        int sum = sumPairs(pairs);
        System.out.println("TOTAL ==> " + sum);
    }

    private List<Integer> allNumbers() {
        return List.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

    private List<Integer> numbersPairs(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    private List<Integer> numbersSquared(List<Integer> pairs) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : pairs) {
            result.add(number * number);
        }
        return result;
    }

    private List<Integer> showNumbers(List<Integer> squared) {
        for (Integer number : squared) {
            System.out.println("NUMBER ==> " + number);
        }
        return squared;
    }

    private int sumPairs(List<Integer> pairs) {
        int sum = 0;
        for (Integer number : pairs) {
            sum += number;
        }
        return sum;
    }

}
