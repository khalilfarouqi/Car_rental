package com.app.dto;

import com.app.entity.enem.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private Long ID;
    private Date Last_CheckIn;
    private String UserName;
    private String PassWord;
    private Roles roles;
    private List<OrderDto> orderDtoList;
}
