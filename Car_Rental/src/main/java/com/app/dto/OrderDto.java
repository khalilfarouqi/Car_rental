package com.app.dto;

import com.app.entity.enem.City;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Long ID;
    private String Contry;
    private City Booking_City;
    private City Return_City;
    private Date Start_Date;
    private Date End_Date;
    private int Client_Age;
    private String Type_Insurance;
    private String Order_Status;
    private CarDto carDto;
    private UserDto userDto;

}
