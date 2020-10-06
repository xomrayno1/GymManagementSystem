package com.tampro.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.OrderDetailDAO;
import com.tampro.dto.OrderDTO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Order;
import com.tampro.entity.OrderDetail;
import com.tampro.entity.ProductInfo;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;

@Service
public class OrderDetailService {

	@Autowired
	OrderDetailDAO<OrderDetail> orderDetailDAO;
	@Autowired
	OrderService orderService;
	public List<OrderDetailDTO> getAllByPropertyBySort(String property, Object object,Paging paging){
 		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
		for(OrderDetail orderDetail : orderDetailDAO.findByPropertySort(property, object, paging,null)) {
			OrderDetailDTO orderDetailDTO = ConvertToDTO.convertOrderDetailEntity(orderDetail);
			orderDetailDTOs.add(orderDetailDTO);
		}
		return orderDetailDTOs;
	}
	public List<OrderDetailDTO> getAllByProperty(String property, Object object){
		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
		for(OrderDetail orderDetail : orderDetailDAO.findByProperty(property, object)) {
			OrderDetailDTO orderDetailDTO = ConvertToDTO.convertOrderDetailEntity(orderDetail);
			orderDetailDTOs.add(orderDetailDTO);
		}
		return orderDetailDTOs;
	}
	public OrderDetailDTO findById(int id) {
		OrderDetail orderDetail = orderDetailDAO.findById(OrderDetail.class, id);
		OrderDetailDTO orderDetailDTO = ConvertToDTO.convertOrderDetailEntity(orderDetail);
		return orderDetailDTO;
	}
	public void add(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail  = new OrderDetail();
		orderDetail.setActiveFlag(1);
		orderDetail.setCreateDate(new Date());
		orderDetail.setId(orderDetail.getId());
		orderDetail.setOrder(new Order(orderDetailDTO.getIdOrder()));
		orderDetail.setPrice(orderDetailDTO.getPrice());
		if(orderDetailDTO.getProductInfoDTO() != null) {
			orderDetail.setProductInfo(new ProductInfo(orderDetailDTO.getProductInfoDTO().getId()));
		}else {
			orderDetail.setProductInfo(new ProductInfo(orderDetailDTO.getIdProduct()));
		}
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
		orderDetail.setUpdateDate(new Date());
		orderDetailDAO.add(orderDetail);
	}
	public void update(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail  = new OrderDetail();
		orderDetail.setActiveFlag(orderDetailDTO.getActiveFlag());
		orderDetail.setCreateDate(orderDetailDTO.getCreateDate());
		orderDetail.setId(orderDetail.getId());
		orderDetail.setOrder(new Order(orderDetailDTO.getIdOrder()));
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setProductInfo(new ProductInfo(orderDetailDTO.getProductInfoDTO().getId()));
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
		orderDetail.setUpdateDate(new Date());
		orderDetailDAO.update(orderDetail);
	}
	public void delete(OrderDetailDTO orderDetailDTO) throws Exception {
		OrderDetail orderDetail  = new OrderDetail();
		orderDetail.setActiveFlag(0);
		orderDetail.setCreateDate(orderDetailDTO.getCreateDate());
		orderDetail.setId(orderDetailDTO.getId());
		orderDetail.setOrder(new Order(orderDetailDTO.getIdOrder()));
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setProductInfo(new ProductInfo(orderDetailDTO.getProductInfoDTO().getId()));
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
		orderDetail.setUpdateDate(new Date());
		orderDetailDAO.delete(orderDetail);
		
		List<OrderDetailDTO> listOrderDetail = getAllByProperty("order.id", orderDetailDTO.getIdOrder());
		OrderDTO orderDTO = orderService.findById(orderDetail.getOrder().getId());
		orderDTO.setListDetailDTOs(listOrderDetail);
		if(listOrderDetail.isEmpty()) {
			orderDTO.setStatus(Constant.CANCEL);
			orderService.delete(orderDTO);
		}else {
			BigDecimal totalPrice = new BigDecimal(0);
			for(OrderDetailDTO dto : getAllByProperty("order.id", orderDetailDTO.getIdOrder())) {
				totalPrice = totalPrice.add(dto.getTotalPrice());
			}
			orderDTO.setTotalPrice(totalPrice);
			orderService.update(orderDTO);
		}	
	}
}
