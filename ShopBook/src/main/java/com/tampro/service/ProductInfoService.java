package com.tampro.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tampro.dao.ProductInfoDAO;
import com.tampro.dto.FilterSearch;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.entity.Author;
import com.tampro.entity.Category;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.Publisher;
import com.tampro.utils.ConvertToDTO;
@Service
public class ProductInfoService {
	@Autowired
	ProductInfoDAO<ProductInfo> productInfoDAO;
	
	public	List<ProductInfoDTO> getProductNews(){
		List<ProductInfoDTO> list = new ArrayList<ProductInfoDTO>();
		Paging paging = new Paging(6);
		paging.setPageIndex(1);
		StringBuilder queryStr = new StringBuilder(" ORDER BY (model.createDate) DESC  ");
		for(ProductInfo productInfo : productInfoDAO.findAll(queryStr.toString(), null,new Paging(6) )) {
			ProductInfoDTO dto = ConvertToDTO.convertProducInfoEntity(productInfo);
			list.add(dto);
		}
		return list;
		
	}
	public	List<ProductInfoDTO> getAll(ProductInfoDTO productInfoDTO,Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(productInfoDTO != null) {
			if(!StringUtils.isEmpty(productInfoDTO.getCode()) && productInfoDTO.getCode() != null) {
				queryStr.append(" and model.code =:code ");
				mapParam.put("code", productInfoDTO.getCode());
			}
			if(!StringUtils.isEmpty(productInfoDTO.getName()) && productInfoDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+productInfoDTO.getName()+"%");
			}
		}	
		List<ProductInfoDTO> list = new ArrayList<ProductInfoDTO>();
		for(ProductInfo productInfo : productInfoDAO.findAll(queryStr.toString(), mapParam, paging)) {
			ProductInfoDTO dto = ConvertToDTO.convertProducInfoEntity(productInfo);
			list.add(dto);
		}
		return list;
	}
	public	List<ProductInfoDTO> getAllSort(ProductInfoDTO productInfoDTO,Paging paging,String sort){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(productInfoDTO != null) {
			if(!StringUtils.isEmpty(productInfoDTO.getCode()) && productInfoDTO.getCode() != null) {
				queryStr.append(" and model.code =:code ");
				mapParam.put("code", productInfoDTO.getCode());
			}
			if(!StringUtils.isEmpty(productInfoDTO.getName()) && productInfoDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+productInfoDTO.getName()+"%");
			}
			if(!StringUtils.isEmpty(sort)) {
				if(sort.equals("gia-tang")) {
					queryStr.append(" ORDER BY model.price asc ");
				}else if(sort.equals("gia-giam")){
					queryStr.append(" ORDER BY model.price desc ");
				}
			}
		}	
		List<ProductInfoDTO> list = new ArrayList<ProductInfoDTO>();
		for(ProductInfo productInfo : productInfoDAO.findAll(queryStr.toString(), mapParam, paging)) {
			ProductInfoDTO dto = ConvertToDTO.convertProducInfoEntity(productInfo);
			list.add(dto);
		}
		return list;
	}
	public	List<ProductInfoDTO> getAllByProperty(String property, Object object){
		List<ProductInfoDTO> list = new ArrayList<ProductInfoDTO>();
		for(ProductInfo productInfo : productInfoDAO.findByProperty(property, object)) {
			ProductInfoDTO dto = ConvertToDTO.convertProducInfoEntity(productInfo);
			list.add(dto);
		}
		return list;
	}
	public	List<ProductInfoDTO> getAllByPropertySort(String property, Object object,Paging paging ,String sort){
		List<ProductInfoDTO> list = new ArrayList<ProductInfoDTO>();
		for(ProductInfo productInfo : productInfoDAO.findByPropertySort(property,object,paging,sort)) {
			ProductInfoDTO dto = ConvertToDTO.convertProducInfoEntity(productInfo);
			list.add(dto);
		}
		return list;
	}
	public	ProductInfoDTO findById(int id) {
		ProductInfo productInfo = productInfoDAO.findById(ProductInfo.class, id);
		ProductInfoDTO productInfoDTO = ConvertToDTO.convertProducInfoEntity(productInfo);
		return productInfoDTO;		
	}
	public void add(ProductInfoDTO productInfoDTO) throws IllegalStateException, IOException {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setActiveFlag(1);
		productInfo.setAuthor(new Author(productInfoDTO.getIdAuthor()));
		productInfo.setCategory(new Category(productInfoDTO.getIdCategory()));
		productInfo.setCode(productInfoDTO.getCode());
		productInfo.setCreateDate(new Date());
		productInfo.setDateOfPublication(productInfoDTO.getDateOfPublication());
		productInfo.setDescription(productInfoDTO.getDescription());
		if(!productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String img = System.currentTimeMillis()+"_"+productInfoDTO.getMultipartFile().getOriginalFilename();
			upload(img, productInfoDTO.getMultipartFile());
			productInfo.setImgUrl("/resources/upload/"+img);	
		}
		productInfo.setISBN(productInfoDTO.getISBN());
		productInfo.setName(productInfoDTO.getName());
		productInfo.setPageNumber(productInfoDTO.getPageNumber());
		productInfo.setPrice(productInfoDTO.getPrice());
		productInfo.setPublisher(new Publisher(productInfoDTO.getIdPublisher()));
		productInfo.setSize(productInfoDTO.getSize());
		productInfo.setUrl("/"+ConvertToDTO.removeAccent(productInfoDTO.getName()));
		productInfo.setUpdateDate(new Date());
		productInfoDAO.add(productInfo);
	}
	public	void delete(ProductInfoDTO productInfoDTO) throws Exception {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setActiveFlag(0);
		productInfo.setAuthor(new Author(productInfoDTO.getIdAuthor()));
		productInfo.setCategory(new Category(productInfoDTO.getIdCategory()));
		productInfo.setCode(productInfoDTO.getCode());
		productInfo.setCreateDate(productInfoDTO.getCreateDate());
		productInfo.setDateOfPublication(productInfoDTO.getDateOfPublication());
		productInfo.setDescription(productInfoDTO.getDescription());
		productInfo.setId(productInfoDTO.getId());
		productInfo.setImgUrl(productInfoDTO.getImgUrl());
		productInfo.setISBN(productInfoDTO.getISBN());
		productInfo.setName(productInfoDTO.getName());
		productInfo.setPageNumber(productInfoDTO.getPageNumber());
		productInfo.setPrice(productInfoDTO.getPrice());
		productInfo.setPublisher(new Publisher(productInfoDTO.getIdPublisher()));
		productInfo.setSize(productInfoDTO.getSize());
		productInfo.setUpdateDate(new Date());
		productInfo.setUrl(productInfoDTO.getUrl());
		productInfoDAO.delete(productInfo);
	}
	public	void update(ProductInfoDTO productInfoDTO) throws IllegalStateException, IOException {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setActiveFlag(productInfoDTO.getActiveFlag());
		productInfo.setAuthor(new Author(productInfoDTO.getIdAuthor()));
		productInfo.setCategory(new Category(productInfoDTO.getIdCategory()));
		productInfo.setCode(productInfoDTO.getCode());
		productInfo.setCreateDate(productInfoDTO.getCreateDate());
		productInfo.setDateOfPublication(productInfoDTO.getDateOfPublication());
		productInfo.setDescription(productInfoDTO.getDescription());
		productInfo.setId(productInfoDTO.getId());
		if(!productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String img = System.currentTimeMillis()+"_"+productInfoDTO.getMultipartFile().getOriginalFilename();
			upload(img, productInfoDTO.getMultipartFile());
			productInfo.setImgUrl("/resources/upload/"+img);	
		}else {
			productInfo.setImgUrl(productInfoDTO.getImgUrl());
		}
		productInfo.setISBN(productInfoDTO.getISBN());
		productInfo.setName(productInfoDTO.getName());
		productInfo.setPageNumber(productInfoDTO.getPageNumber());
		productInfo.setPrice(productInfoDTO.getPrice());
		productInfo.setPublisher(new Publisher(productInfoDTO.getIdPublisher()));
		productInfo.setSize(productInfoDTO.getSize());
		productInfo.setUpdateDate(new Date());
		productInfo.setUrl(productInfoDTO.getUrl());
		productInfoDAO.update(productInfo);
	}
	public	void updatePrice(ProductInfoDTO productInfoDTO) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setActiveFlag(productInfoDTO.getActiveFlag());
		productInfo.setAuthor(new Author(productInfoDTO.getIdAuthor()));
		productInfo.setCategory(new Category(productInfoDTO.getIdCategory()));
		productInfo.setCode(productInfoDTO.getCode());
		productInfo.setCreateDate(productInfoDTO.getCreateDate());
		productInfo.setDateOfPublication(productInfoDTO.getDateOfPublication());
		productInfo.setDescription(productInfoDTO.getDescription());
		productInfo.setId(productInfoDTO.getId());
		productInfo.setImgUrl(productInfoDTO.getImgUrl());
		productInfo.setISBN(productInfoDTO.getISBN());
		productInfo.setName(productInfoDTO.getName());
		productInfo.setPageNumber(productInfoDTO.getPageNumber());
		productInfo.setPrice(productInfoDTO.getPrice());
		productInfo.setPublisher(new Publisher(productInfoDTO.getIdPublisher()));
		productInfo.setSize(productInfoDTO.getSize());
		productInfo.setUpdateDate(new Date());
		productInfo.setUrl(productInfoDTO.getUrl());
		productInfoDAO.update(productInfo);
	}
	public void upload(String img,MultipartFile multipartFile) throws IllegalStateException, IOException {
		File  file  = new File("D:\\EclipseProject\\ShopBook\\src\\main\\webapp\\static\\upload\\"+img);
		multipartFile.transferTo(file);
	}


}
