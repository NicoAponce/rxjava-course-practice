package pe.lol.demo.functional.v2_super_function_class.utils;

import pe.lol.demo.functional.v2_super_function_class.interfaces.Provider;

public class Natural implements Provider {

    private static int next=0;

    @Override
    public Integer getNumber() {
        return next++;
    }
}
