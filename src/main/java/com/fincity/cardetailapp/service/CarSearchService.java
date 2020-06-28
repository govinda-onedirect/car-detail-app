package com.fincity.cardetailapp.service;

import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.enums.CarSearchEnum;

import java.util.List;

public interface CarSearchService {
    /**
     * Pagination is not implemented here!
     * @param key
     * @param value
     * @return
     */
    List<CarResponseDto> search(CarSearchEnum key, Object value);
}
