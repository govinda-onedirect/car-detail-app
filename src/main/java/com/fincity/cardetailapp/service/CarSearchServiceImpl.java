package com.fincity.cardetailapp.service;

import com.fincity.cardetailapp.builder.CarDetailBuilder;
import com.fincity.cardetailapp.dao.CarRepository;
import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.enitities.CarEntity;
import com.fincity.cardetailapp.enums.CarSearchEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarSearchServiceImpl implements CarSearchService{

    @Autowired
    private CarRepository carRepository;



    @Override
    public List<CarResponseDto> search(CarSearchEnum key, Object value) {
        List<CarEntity> carEntities = carRepository.searchBy(key, value);
        if (!CollectionUtils.isEmpty(carEntities)) {
            return CarDetailBuilder.buildResponseDto(carEntities);
        }
        return new ArrayList<>();
    }

    private void validateRequest(CarSearchEnum key, Object value){
        if (value instanceof Integer){

        }
    }
}
