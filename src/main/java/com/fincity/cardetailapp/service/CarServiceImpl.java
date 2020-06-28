package com.fincity.cardetailapp.service;

import com.fincity.cardetailapp.builder.CarDetailBuilder;
import com.fincity.cardetailapp.dao.CarRepository;
import com.fincity.cardetailapp.dtos.CarRequestDto;
import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.enitities.CarEntity;
import com.fincity.cardetailapp.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarValidatorService carValidatorService;


    @Autowired
    private CarRepository carRepository;


    @Override
    public CarResponseDto addCar(CarRequestDto carRequestDto) {
        carValidatorService.validateRequest(carRequestDto);
        CarEntity carEntity = CarDetailBuilder.buildEntity(carRequestDto);
        Integer id = carRepository.insert(carEntity);
        return CarDetailBuilder.buildResponseDto(carEntity);
    }

    @Override
    public int deleteById(Long id){
        Optional.ofNullable(carRepository.findById(id)).orElseThrow(()->new ValidationException("The provided element doesn't exist!"));
        return carRepository.deleteById(id);
    }

    @Override
    public CarResponseDto getById(Long id){
        CarEntity byId = carRepository.findById(id);
        if (Objects.nonNull(byId)){
            return CarDetailBuilder.buildResponseDto(byId);
        }
        throw new ValidationException("The provided element doesn't exist!");
    }

    @Override
    public List<CarResponseDto> getAllCars(){
        List<CarEntity> all = carRepository.findAll();
        if (!CollectionUtils.isEmpty(all)){
            return CarDetailBuilder.buildResponseDto(all);
        }
        return new ArrayList<>();
    }

    @Override
    public CarResponseDto updateCarDetails(Long id, CarRequestDto dto){
        carValidatorService.validateRequest(dto);
        CarEntity carEntity = CarDetailBuilder.buildEntity(dto);
        carEntity.setId(id);
        int update = carRepository.update(carEntity);
        return CarDetailBuilder.buildResponseDto(carEntity);
    }

}
