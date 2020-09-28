package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.OrderDetailDAO;
import com.tampro.entity.OrderDetail;

@Repository
@Transactional(rollbackFor = Exception.class)
public class OrderDetailDAOImpl extends BaseDAOImpl<OrderDetail> implements OrderDetailDAO<OrderDetail>{

}
