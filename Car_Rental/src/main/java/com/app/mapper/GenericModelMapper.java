package com.app.mapper;

import java.io.Serializable;
import java.util.List;

public interface GenericModelMapper<Entity, Dto extends Serializable> {

    Dto toDto(Entity entity);

    List<Dto> toDto(List<Entity> entities);

    Entity toEntity(Dto dto);

    List<Entity> toEntity(List<Dto> dtos);
}
