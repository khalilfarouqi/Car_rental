package com.app.dto;

import com.app.entity.enem.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto implements Serializable {
    private Long ID;
    private String Name;
    private Brande brande;
    private String Matricule;
    private Double Mileage;
    private int Model;
    private int HorsPower;
    private Double Consumption;
    private Fuel fuel;
    private Boolean Bluetooth;
    private Boolean AirBag;
    private GearBox gearBox;
    private int Seat;
    private int Door;
    private Style style;
    private int bootSize;
    private Double Price;
    private Double Rate;
    private Boolean CDM;
    private Boolean Protection_Vol;
    private Boolean Respo_Civile;
    private Boolean Bris_Glace_Pneus;
    private PhotoDto photoDto;
    private List<OrderDto> orderDtoList;
}
