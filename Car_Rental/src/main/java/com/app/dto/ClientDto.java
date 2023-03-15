package com.app.dto;

import com.app.entity.enums.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends UserDto implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private String adress;
    private String tel;
    private City city;
    private String country;
    private String cin;
    private String licence;
    private Date dateLicence;
    private Date dateCreation;
    private String email;
    private int volNumbre;
}
