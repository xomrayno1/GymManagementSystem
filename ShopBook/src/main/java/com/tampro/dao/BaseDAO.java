package com.tampro.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tampro.dto.Paging;

public interface BaseDAO<E> {
	
	E findById(Class<E> instance, Serializable id );
	List<E> findByProperty(String property , Object object);
	List<E> findAll(String queryStr,Map<String, Object> mapParam,Paging paging);
	public List<E> findByPropertySort(String property, Object object, Paging paging,String sort);
	void delete(E e);
	void update(E e);
	void add(E e);
	
}
