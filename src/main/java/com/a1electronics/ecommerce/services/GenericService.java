package com.a1electronics.ecommerce.services;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, D, PK extends Serializable> {

	public D findById(PK id);
	public List<D> findAll();
	public D create(D created);
	public D delete(PK id);
	public D update(D updated);
	
	
}
