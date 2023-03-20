package com.app.sevice;

import java.io.Serializable;

public interface IBaseService<E, D extends Serializable> extends IRsqlService<E, D> {
    D save(D dto);

    D update(D dto);

    void delete(Long id);

    D findById(Long id);
}
