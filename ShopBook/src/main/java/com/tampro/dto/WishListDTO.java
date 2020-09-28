package com.tampro.dto;

import java.io.Serializable;

public class WishListDTO  extends Base implements Serializable{
	private int id;
	private int idUser;
	private ProductInfoDTO productInfoDTO;

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
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
}
