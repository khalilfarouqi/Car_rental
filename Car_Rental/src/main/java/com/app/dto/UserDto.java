package com.app.dto;

import com.app.entity.enums.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private Long id;
    private Date lastCheckIn;
    private String userName;
    private String passWord;
    private Roles roles;
    private List<OrderDto> orderDtoList;
}
