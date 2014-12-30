package com.a1electronics.ecommerce.services.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.a1electronics.ecommerce.services.GenericService;

@Service("GenericService")
public abstract class GenericServiceImpl<T, D, PK extends Serializable>
		implements GenericService<T, D, PK> {

	@Autowired
	private  JpaRepository<T, PK> dao;
	@Autowired
    private  DozerBeanMapper mapper;
	protected Class<T> entityClass;
    protected Class<D> dtoClass;
	
    
    public GenericServiceImpl() {
		super();
	    ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	    this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	    this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];

	}


	public D findById(PK id) {
		return mapper.map(dao.findOne(id), dtoClass);
	}

	public List<D> findAll(){
		List<D> result = new ArrayList<D>();
        for (T t : dao.findAll()) {
            result.add(mapper.map(t, dtoClass));
        }
        return result;
	}

	public D create(D created){
		return null;
	}

	public D delete(PK id){
		return null;
	}

	public D update(D updated){
		return null;
	}
}
