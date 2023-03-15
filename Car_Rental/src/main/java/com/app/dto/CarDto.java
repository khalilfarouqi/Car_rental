package com.app.dto;

import com.app.entity.enums.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto implements Serializable {
    private Long id;
    private String name;
    private Brande brande;
    private String matricule;
    private Double mileage;
    private int model;
    private int horsPower;
    private Double consumption;
    private Fuel fuel;
    private Boolean bluetooth;
    private Boolean airBag;
    private GearBox gearBox;
    private int seat;
    private int door;
    private Style style;
    private int bootSize;
    private Double price;
    private Double rate;
    private Boolean cdm;
    private Boolean protectionVol;
    private Boolean respoCivile;
    private Boolean brisGlacePneus;
    private PhotoDto photoDto;
    private List<OrderDto> orderDtoList;
}
