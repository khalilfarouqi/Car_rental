package com.app.dto;

import com.app.entity.enem.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends UserDto implements Serializable {
    private String First_Name;
    private String Last_Name;
    private Gender gender;
    private int Age;
    private String Adress;
    private String Tel;
    private City City;
    private String Country;
    private String CIN;
    private String Licence;
    private Date Date_Licence;
    private Date Date_Creation;
    private String Email;
    private int Vol_Numbre;
}
