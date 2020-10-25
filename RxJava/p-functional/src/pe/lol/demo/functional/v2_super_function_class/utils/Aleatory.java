package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.Provider;

import java.util.Random;

public class Aleatory implements Provider {

    Random random=new Random();

    @Override
    public Integer getNumber() {
        return random.nextInt(10000);
    }
}
