package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.BinaryFunction;

public class Sum implements BinaryFunction {
    @Override
    public Integer apply(Integer val1, Integer val2) {
        return val1+val2;
    }
}
