package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.Transform;

public class Squared implements Transform {
    @Override
    public Integer apply(Integer value) {
        return value * value;
    }
}
