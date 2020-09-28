package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.OrderDAO;
import com.tampro.entity.Order;
@Repository
@Transactional(rollbackFor = Exception.class)
public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO<Order>{

	@Override
	public int addInt(Order order) {
		// TODO Auto-generated method stub
		return (int) factory.getCurrentSession().save(order);	
	}

	

}
