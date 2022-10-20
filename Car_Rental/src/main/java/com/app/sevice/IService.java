package com.app.sevice;

import java.util.List;

public interface IService <T> {
	
	List<T> getAll();

	T save(T t);

	T getById(Long id);
	
	T update(T t, Long id);

	void deleteById(Long id);
	
}
