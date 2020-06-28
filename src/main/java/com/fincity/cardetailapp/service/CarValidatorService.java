package com.fincity.cardetailapp.service;

import com.fincity.cardetailapp.dtos.CarRequestDto;
import com.fincity.cardetailapp.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CarValidatorService {

    private static final String EMPTY_VALIDATION_MESSAGE =" is mandatory!";
    private static final String SIZE_VALIDATION_MESSAGE = "Maximum allowed alphabets are 50 for ";

    /**
     * Reflection can be used over here instead of calling validation method for each field.
     * @param requestDto
     */
    public void validateRequest(CarRequestDto requestDto){
        validateField("name",requestDto.getName());
        validateField("manufactureName",requestDto.getManufactureName());
        validateField("model",requestDto.getModel());
        validateField("color",requestDto.getColor());
        emptyValidation("year",requestDto.getManufactureYear().toString());

    }

    private void validateField(String field, String value){
        emptyValidation(field,value);
        sizeValidation(field,value);
    }

    private void emptyValidation(String field, String value){
        if (StringUtils.isEmpty(value)){
            throw  new ValidationException(field+EMPTY_VALIDATION_MESSAGE);
        }
    }

    private void sizeValidation(String field, String value){
        if (value.length()>50){
            throw  new ValidationException(SIZE_VALIDATION_MESSAGE+field);
        }
    }
}
