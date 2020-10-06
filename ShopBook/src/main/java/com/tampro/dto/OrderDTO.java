package com.tampro.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {
	private int id;	
	private int idUser;
	private ShipmentDetailsDTO shipmentDetails;
	private BigDecimal totalPrice;
	private int vat ;
	private int sales ;
	private int status;
	private BigDecimal subTotal;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	private List<OrderDetailDTO> listDetailDTOs;
	private Date dateTo;
	private Date dateFrom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public BigDecimal getTotalPrice() {
		if(this.totalPrice == null) {
			return new BigDecimal(0);
		}
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BigDecimal getSubTotal() {
		BigDecimal vat = totalPrice.multiply(new BigDecimal(this.vat)).divide(new BigDecimal(100));
		BigDecimal sale = totalPrice.multiply(new BigDecimal(this.sales)).divide(new BigDecimal(100));
		this.subTotal = this.totalPrice.subtract(vat).subtract(sale);
		return this.subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
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
	public ShipmentDetailsDTO getShipmentDetails() {
		return shipmentDetails;
	}
	public void setShipmentDetails(ShipmentDetailsDTO shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
	}
	public List<OrderDetailDTO> getListDetailDTOs() {
		return listDetailDTOs;
	}
	public void setListDetailDTOs(List<OrderDetailDTO> listDetailDTOs) {
		this.listDetailDTOs = listDetailDTOs;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	
}
