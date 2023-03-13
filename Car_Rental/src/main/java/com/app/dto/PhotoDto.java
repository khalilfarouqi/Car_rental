package com.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhotoDto {
    private Long ID;
    private String Photo_1;
    private String Photo_2;
    private String Photo_3;
    private String Photo_4;
    private CarDto carDto;
}