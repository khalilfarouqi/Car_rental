package com.app.sevice;

import org.springframework.data.domain.Page;

import java.io.Serializable;

public interface IRsqlService <E, D extends Serializable>{
    Page<D> rsqlQuery(String query, Integer page, Integer size, String order, String sort);
}
