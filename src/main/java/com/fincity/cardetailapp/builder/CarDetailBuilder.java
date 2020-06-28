package com.fincity.cardetailapp.builder;

import com.fincity.cardetailapp.dtos.CarRequestDto;
import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.enitities.CarEntity;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;

public class CarDetailBuilder {

    private static ModelMapper modelMapper;

    private CarDetailBuilder(){
    }

    static {
        modelMapper=new ModelMapper();
    }

    public static CarEntity buildEntity(CarRequestDto requestDto){
        return modelMapper.map(requestDto,CarEntity.class);
    }

    public static CarResponseDto buildResponseDto(Long id,CarEntity carEntity){
        CarResponseDto dto = modelMapper.map(carEntity, CarResponseDto.class);
        dto.setId(id);
        return dto;
    }

    public static CarResponseDto buildResponseDto(CarEntity carEntity){
        return modelMapper.map(carEntity,CarResponseDto.class);
    }

    public static List<CarResponseDto> buildResponseDto(List<CarEntity> carEntity){
        return carEntity.parallelStream().map(CarDetailBuilder::buildResponseDto).collect(Collectors.toList());
    }

}
