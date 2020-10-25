package pe.lol.demo.functional.v2_super_function_class.function_class;

import pe.lol.demo.functional.v2_super_function_class.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFunction {

    public static List<Integer> filter(List<Integer> values,Predicate predicate){
        List<Integer> result=new ArrayList<>();
        for (Integer value:values) {
            if(predicate.test(value)){
                result.add(value);
            }

        }
        return result;
    }

    public static List<Integer> getNumber(int size, Provider provider){
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(provider.getNumber());
        }
        return  result;
    }

    public static List<Integer> change(List<Integer> values, Transform transform){
        List<Integer> result=new ArrayList<>();
        for (Integer value: values) {
            result.add(transform.apply(value));
        }
        return result;
    }

    public static List<Integer> showNumbers(List<Integer> values, Consumer consumer){
        for (Integer value: values){
            consumer.accept(value);
        }
        return values;
    }

    public static Integer reducer(List<Integer> values,Integer id, BinaryFunction binaryFunction){
        int total=id;
        for (Integer value:values){
            total=binaryFunction.apply(total,value);
        }
        return total;
    }
}
