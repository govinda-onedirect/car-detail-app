package com.fincity.cardetailapp.controller;

import com.fincity.cardetailapp.dtos.CarResponseDto;
import com.fincity.cardetailapp.enums.CarSearchEnum;
import com.fincity.cardetailapp.service.CarSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CarSearchController {

    @Autowired
    private CarSearchService carSearchService;

    @GetMapping("/car/search")
    public CollectionModel<CarResponseDto> search(@NonNull @RequestParam("key") CarSearchEnum key,@NonNull @RequestParam("value") Object value){
        List<CarResponseDto> cars = carSearchService.search(key,value);

        for (CarResponseDto car : cars) {
            Long carId = car.getId();
            Link selfLink = linkTo(CarDetailController.class).slash(carId).withRel(LinkRelation.of("ById"));
            car.add(selfLink);
        }

        Link link = linkTo(methodOn(CarSearchController.class).search(key,value)).withSelfRel();
        return CollectionModel.of(cars, link);
    }
}
