package com.app.dto;

import com.app.entity.enums.City;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto implements Serializable {
    private Long id;
    private String country;
    private City bookingCity;
    private City returnCity;
    private Date startDate;
    private Date endDate;
    private int clientAge;
    private String typeInsurance;
    private String orderStatus;
    private CarDto carDto;
    private UserDto userDto;

}
