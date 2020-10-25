package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.Predicate;

public class Pair implements Predicate {
    @Override
    public boolean test(Integer value) {
        return value % 2 == 0;
    }
}
