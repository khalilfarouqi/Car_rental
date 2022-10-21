package com.app.sevice;

import java.io.Serializable;
import java.util.List;

public interface IService <T> extends Serializable {
	
	List<T> getAll();

	T save(T t);

	T getById(Long id);
	
	T update(T t, Long id);

	void deleteById(Long id);
	
}
