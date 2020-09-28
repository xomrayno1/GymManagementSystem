package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.OrderDAO;
import com.tampro.dto.OrderDTO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Order;
import com.tampro.entity.ShipmentDetails;
import com.tampro.entity.User;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO<Order> orderDAO;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ShipmentDetailService shipmentDetailService;
	
	public void add(OrderDTO orderDTO) throws Exception {
		Order order = new Order();
		order.setActiveFlag(1);
		order.setCreateDate(new Date());
		order.setId(orderDTO.getId());
		order.setSales(orderDTO.getSales());
		order.setStatus(1);
		order.setSubTotal(orderDTO.getSubTotal());
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setUpdateDate(new Date());
		order.setUser(new User(orderDTO.getIdUser()));
		order.setVat(orderDTO.getVat());
		order.setStatus(Constant.PROCESSING);
		int idShipment = shipmentDetailService.addInt(orderDTO.getShipmentDetails());
		order.setShipmentDetails(new ShipmentDetails(idShipment));
		int id = orderDAO.addInt(order);
		for(OrderDetailDTO orderDetailDTO : orderDTO.getListDetailDTOs()) {
			orderDetailDTO.setIdOrder(id);
			orderDetailService.add(orderDetailDTO);
		}
		
	}
	public List<OrderDTO> getAllOrderByProperty(OrderDTO orderDTO , Paging paging){
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(orderDTO != null) {
			if(orderDTO.getDateTo() != null && orderDTO.getDateFrom() != null) {
				queryStr.append(" and date(model.createDate) between :dateTo and :dateFrom ");
				mapParam.put("dateTo", orderDTO.getDateTo());
				mapParam.put("dateFrom", orderDTO.getDateFrom());
			}
			if(orderDTO.getStatus() != 0) {
				queryStr.append(" and model.status =:status");
				mapParam.put("status", orderDTO.getStatus());
			}
			if(orderDTO.getIdUser() != 0) {
				queryStr.append(" and model.user.id = :userId");
				mapParam.put("userId", orderDTO.getIdUser());
			}
		}
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		for(Order order : orderDAO.findAll(queryStr.toString(), mapParam, paging)) {
			OrderDTO dto = ConvertToDTO.convertOrderEntity(order);
			list.add(dto);
		}
		return list;
	}
	
}
