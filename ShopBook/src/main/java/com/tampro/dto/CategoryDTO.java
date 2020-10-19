package com.tampro.dto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDTO  extends Base{
	private int id;
	private int idParent;
	private String code;
	private String name;
	private String imgUrl;
	private MultipartFile multipartFile  ;
	private List<CategoryDTO> childCategory;
	private int orderIndex;
	private String url;
	private List<ProductInfoDTO> productInfoDTOs;
	private String idCategory;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdParent() {
		return idParent;
	}
	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public List<CategoryDTO> getChildCategory() {
		return childCategory;
	}
	public void setChildCategory(List<CategoryDTO> childCategory) {
		this.childCategory = childCategory;
	}
	public int getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ProductInfoDTO> getProductInfoDTOs() {
		return productInfoDTOs;
	}
	public void setProductInfoDTOs(List<ProductInfoDTO> productInfoDTOs) {
		this.productInfoDTOs = productInfoDTOs;
	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	
	
	
	
	
}
