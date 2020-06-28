package com.fincity.cardetailapp.dtos;


import java.io.Serializable;

public class CarRequestDto implements Serializable {
    private static final Long serialVersionUID=1L;
    private String name;
    private String manufactureName;
    private String model;
    private Integer manufactureYear;
    private String color;

    public CarRequestDto() {
    }

    public CarRequestDto(String name, String manufactureName, String model, Integer manufactureYear, String color) {
        this.name = name;
        this.manufactureName = manufactureName;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.color = color;
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
        return "CarRequestDto{" +
                "name='" + name + '\'' +
                ", manufactureName='" + manufactureName + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", color='" + color + '\'' +
                '}';
    }
}
