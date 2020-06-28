package com.fincity.cardetailapp.controller;

import com.fincity.cardetailapp.dtos.CarRequestDto;
import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CarDetailController {

    @Autowired
    private CarService carService;


    @RequestMapping(value = "/car/create",method = RequestMethod.POST,consumes = {"application/json"} ,produces = { "application/hal+json" })
    public EntityModel<CarResponseDto> addCarDetails(final @RequestBody CarRequestDto carRequestDto){
        CarResponseDto responseDto = carService.addCar(carRequestDto);
        Link selfLink = linkTo(methodOn(CarDetailController.class).getCarById(responseDto.getId())).withSelfRel();
        return EntityModel.of(responseDto,selfLink);
    }

    @GetMapping(value = "/car/{carId}", produces = { "application/hal+json" })
    public EntityModel<CarResponseDto> getCarById(@PathVariable("carId") Long carId) {
        Link selfLink = linkTo(methodOn(CarDetailController.class).getCarById(carId)).withSelfRel();
        return EntityModel.of(carService.getById(carId),selfLink);
    }

    @GetMapping(value = "/cars", produces = { "application/hal+json" })
    public CollectionModel<CarResponseDto> getCars() {
        List<CarResponseDto> allCars = carService.getAllCars();
        for (CarResponseDto car : allCars) {
            Long carId = car.getId();
            Link selfLink = linkTo(CarDetailController.class).slash(carId).withSelfRel();
            car.add(selfLink);
        }
        Link selfLink = linkTo(methodOn(CarDetailController.class).getCars()).withSelfRel();
        return CollectionModel.of(allCars,selfLink);
    }


    @DeleteMapping(value = "/car/delete/{carId}", produces = { "application/hal+json" })
    public EntityModel<Integer> delete(@PathVariable("carId") Long carId) {
        Link allCars = linkTo(methodOn(CarDetailController.class).getCars()).withRel(Relation.NO_RELATION);
        return EntityModel.of(carService.deleteById(carId),allCars);
    }

    @RequestMapping(value = "/car/{carId}",method = RequestMethod.PUT,consumes = {"application/json"} ,produces = { "application/hal+json" })
    public EntityModel<CarResponseDto> updateCarDetails(@PathVariable("carId") Long carId, final @RequestBody CarRequestDto carRequestDto){
        CarResponseDto responseDto = carService.updateCarDetails(carId,carRequestDto);
        Link selfLink = linkTo(methodOn(CarDetailController.class).getCarById(responseDto.getId())).withRel(LinkRelation.of("FetchById"));
        return EntityModel.of(responseDto,selfLink);
    }
}
