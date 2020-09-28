package com.tampro.dao;

import com.tampro.entity.ShipmentDetails;

public interface ShipmentDetailDAO<E> extends BaseDAO<E>{

	
	int addInt(ShipmentDetails shipmentDetail);
	
}
