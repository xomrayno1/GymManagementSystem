package com.tampro.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDTO {
	private int id;
	private ProductInfoDTO productInfoDTO;
	private int idOrder;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private int quantity;
	private int status;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	
	
	public OrderDetailDTO() {
		
	}
	public OrderDetailDTO(ProductInfoDTO productInfoDTO, BigDecimal price, BigDecimal totalPrice, int quantity) {
		this.productInfoDTO = productInfoDTO;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;
	}
	public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
		this.productInfoDTO = productInfoDTO;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	
	

}
