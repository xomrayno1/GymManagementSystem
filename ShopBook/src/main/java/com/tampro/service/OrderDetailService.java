package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.OrderDetailDAO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.entity.Order;
import com.tampro.entity.OrderDetail;
import com.tampro.entity.ProductInfo;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;

@Service
public class OrderDetailService {

	@Autowired
	OrderDetailDAO<OrderDetail> orderDetailDAO;
	
	public List<OrderDetailDTO> getAllByProperty(String property, Object object){
		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
		for(OrderDetail orderDetail : orderDetailDAO.findByProperty(property, object)) {
			OrderDetailDTO orderDetailDTO = ConvertToDTO.convertOrderDetailEntity(orderDetail);
			orderDetailDTOs.add(orderDetailDTO);
		}
		return orderDetailDTOs;
	}
	public OrderDetailDTO findById(int id) {
		return null;
	}
	public void add(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail  = new OrderDetail();
		orderDetail.setActiveFlag(1);
		orderDetail.setCreateDate(new Date());
		orderDetail.setId(orderDetail.getId());
		orderDetail.setOrder(new Order(orderDetailDTO.getIdOrder()));
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setProductInfo(new ProductInfo(orderDetailDTO.getProductInfoDTO().getId()));
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
		orderDetail.setUpdateDate(new Date());
		orderDetailDAO.add(orderDetail);
	}
	public void update(OrderDetailDTO orderDetailDTO) {
		
	}
	public void delete(OrderDetailDTO orderDetailDTO) {
		
	}
}
