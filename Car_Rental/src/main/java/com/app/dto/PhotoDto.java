package com.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhotoDto implements Serializable {
    private Long id;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private CarDto carDto;
}