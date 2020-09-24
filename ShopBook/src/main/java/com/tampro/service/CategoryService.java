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

import com.tampro.dao.CategoryDAO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Category;
import com.tampro.utils.ConvertToDTO;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO<Category> categoryDAO;
	
	public List<CategoryDTO> getAll(CategoryDTO categoryDTO , Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(categoryDTO != null) {
			if(!StringUtils.isEmpty(categoryDTO.getCode()) && categoryDTO.getCode() != null) {
				queryStr.append(" and model.code =:code ");
				mapParam.put("code", categoryDTO.getCode());
			}
			if(!StringUtils.isEmpty(categoryDTO.getName()) && categoryDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+categoryDTO.getName()+"%");
			}
		}	
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		for(Category category : categoryDAO.findAll(queryStr.toString(), mapParam, paging)) {
			CategoryDTO dto = ConvertToDTO.convertCategoryEntity(category);
			list.add(dto);
		}
		return list;
	}
	public List<CategoryDTO> getAllByProperty(String property , Object object){
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		for(Category category : categoryDAO.findByProperty(property, object)) {
			CategoryDTO dto = ConvertToDTO.convertCategoryEntity(category);
			list.add(dto);
		}
		return list;
	}
	public void delete(CategoryDTO  categoryDTO) throws Exception {
		Category category  = new Category();
		category.setActiveFlag(0);
		category.setCode(categoryDTO.getCode());
		category.setCreateDate(categoryDTO.getCreateDate());
		category.setId(categoryDTO.getId());
		category.setIdParent(categoryDTO.getIdParent());
		category.setImgUrl(categoryDTO.getImgUrl());
		category.setName(categoryDTO.getName());
		category.setOrderIndex(categoryDTO.getOrderIndex());
		category.setUpdateDate(new Date());
		category.setUrl(categoryDTO.getUrl());
		categoryDAO.delete(category);
	}
	public void update(CategoryDTO  categoryDTO) throws IllegalStateException, IOException {
		Category category  = new Category();
		category.setActiveFlag(categoryDTO.getActiveFlag());
		category.setCode(categoryDTO.getCode());
		category.setCreateDate(categoryDTO.getCreateDate());
		category.setId(categoryDTO.getId());
		category.setIdParent(categoryDTO.getIdParent());
		if(!categoryDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String img =System.currentTimeMillis()+"_"+categoryDTO.getMultipartFile().getOriginalFilename();
			upload(img, categoryDTO.getMultipartFile());
			category.setImgUrl("/resources/upload/"+img);	
		}else {
			category.setImgUrl(categoryDTO.getImgUrl());
		}
		category.setName(categoryDTO.getName());
		category.setOrderIndex(categoryDTO.getOrderIndex());
		category.setUpdateDate(new Date());
		category.setUrl(categoryDTO.getUrl());
		categoryDAO.update(category);
	}
	public void add(CategoryDTO  categoryDTO) throws IllegalStateException, IOException {
		Category category  = new Category();
		category.setActiveFlag(1);
		category.setCode(categoryDTO.getCode());
		category.setCreateDate(new Date());
		category.setId(categoryDTO.getId());
		category.setIdParent(categoryDTO.getIdParent());
		if(!categoryDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String img = System.currentTimeMillis()+"_"+categoryDTO.getMultipartFile().getOriginalFilename();
			upload(img, categoryDTO.getMultipartFile());
			category.setImgUrl("/resources/upload/"+img);	
		}
		category.setName(categoryDTO.getName());
		category.setOrderIndex(categoryDTO.getOrderIndex());
		category.setUpdateDate(new Date());
		category.setUrl("the-loai/"+ConvertToDTO.removeAccent(categoryDTO.getName()));
		categoryDAO.add(category);
	}
	public void upload(String img,MultipartFile multipartFile) throws IllegalStateException, IOException {
		File  file  = new File("D:\\EclipseProject\\ShopBook\\src\\main\\webapp\\static\\upload\\"+img);
		multipartFile.transferTo(file);
	}
	public CategoryDTO findById(int id) {
		Category category = categoryDAO.findById(Category.class, id);
		CategoryDTO categoryDTO = ConvertToDTO.convertCategoryEntity(category);
		return categoryDTO;
	}
}
