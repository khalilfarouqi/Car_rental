package com.app.mapper;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends GenericModelMapper<Client, ClientDto>{
}
