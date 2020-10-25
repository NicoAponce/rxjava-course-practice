package pe.lol.demo.functional.v2_super_function_class;

import pe.lol.demo.functional.v2_super_function_class.utils.*;
import pe.lol.demo.functional.v2_super_function_class.function_class.SuperFunction;

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

        List<Integer> natural=SuperFunction.getNumber(10,new Natural());
        System.out.println("NUMBER NATURAL ==> " + natural);

        List<Integer> change=SuperFunction.change(natural,new Squared());
        System.out.println("NUMBER * NUMBER ==> " + change);

        List<Integer> random=SuperFunction.getNumber(10,new Aleatory());
        System.out.println("NUMBER RANDOM ==> "+ random);

        List<Integer> pairOnly= SuperFunction.filter(random,new Pair());
        System.out.println("ONLY PAIRS ==> " + pairOnly);

        List<Integer> oddOnly= SuperFunction.filter(random,new Odd());
        System.out.println("ONLY ODD ==> " + oddOnly);

        List<Integer> oneByOne=SuperFunction.showNumbers(random,new Departure());

        int total=SuperFunction.reducer(random,1,new Sum());
        System.out.println("TOTAL ==> " + total);
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
