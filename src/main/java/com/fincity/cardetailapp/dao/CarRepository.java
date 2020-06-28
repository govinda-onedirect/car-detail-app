package com.fincity.cardetailapp.dao;


import com.fincity.cardetailapp.enitities.CarEntity;
import com.fincity.cardetailapp.enums.CarSearchEnum;

import java.util.List;

public interface CarRepository {
    Long insert(CarEntity car);

    CarEntity findById(Long id);

    List< CarEntity > findAll();

    int deleteById(Long id);

    int update(CarEntity carEntity);

    List< CarEntity > searchBy(CarSearchEnum carSearchEnum, Object value);
}
