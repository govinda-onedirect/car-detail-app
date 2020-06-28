package com.fincity.cardetailapp.enums;

import com.fincity.cardetailapp.utility.ConversionUtil;

import java.util.function.Function;

public enum CarSearchEnum {
    NAME(String.class,ConversionUtil.stringFunction),
    MANUFACTURE_NAME(String.class, ConversionUtil.stringFunction),
    COLOR(String.class,ConversionUtil.stringFunction),
    MANUFACTURE_YEAR(Integer.class,ConversionUtil.intFunction),
    MODEL(String.class,ConversionUtil.stringFunction);

    private Class classType;
    private Function convertType;

    CarSearchEnum(Class aClass,Function convertType) {
        this.classType = aClass;
        this.convertType = convertType;
    }

    public Class getClassType() {
        return classType;
    }

    public Function getConvertType() {
        return convertType;
    }
}
