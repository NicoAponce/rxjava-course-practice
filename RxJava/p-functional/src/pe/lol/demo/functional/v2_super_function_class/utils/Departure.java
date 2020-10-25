package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.Consumer;

public class Departure implements Consumer {
    @Override
    public void accept(Integer value) {
        System.out.println("RANDOM ==> " + value);
    }
}
