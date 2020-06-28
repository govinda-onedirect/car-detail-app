package com.fincity.cardetailapp.service;

import com.fincity.cardetailapp.dtos.CarRequestDto;
import com.fincity.cardetailapp.dtos.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto addCar(CarRequestDto carRequestDto);

    int deleteById(Long id);

    CarResponseDto getById(Long id);

    List<CarResponseDto> getAllCars();

    CarResponseDto updateCarDetails(Long id, CarRequestDto dto);
}
