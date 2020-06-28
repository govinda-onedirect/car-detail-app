package com.fincity.cardetailapp.utility;


import java.util.function.Function;

public class ConversionUtil {
    public static Function<Object,String> stringFunction = Object::toString;
    public static Function<Object,Integer> intFunction =(obj)-> Integer.parseInt(obj.toString());

}
