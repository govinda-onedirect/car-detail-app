package com.fincity.cardetailapp.dtos;

import org.springframework.hateoas.RepresentationModel;

public class CarResponseDto extends RepresentationModel<CarResponseDto> {
    private Long id;
    private String name;
    private String manufactureName;
    private String model;
    private Integer manufactureYear;
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufactureName='" + manufactureName + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", color='" + color + '\'' +
                '}';
    }
}
