package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.ShipmentDetailDAO;
import com.tampro.entity.ShipmentDetails;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ShipmentDetailDAOImpl extends BaseDAOImpl<ShipmentDetails> implements ShipmentDetailDAO<ShipmentDetails> {

	@Override
	public int addInt(ShipmentDetails shipmentDetail) {
		// TODO Auto-generated method stub
		return (int) factory.getCurrentSession().save(shipmentDetail);
	}

}
