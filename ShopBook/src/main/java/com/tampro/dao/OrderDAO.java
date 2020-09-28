package com.tampro.dao;

import com.tampro.entity.Order;

public interface OrderDAO<E> extends BaseDAO<E> {
	int addInt(Order order);
	

}
