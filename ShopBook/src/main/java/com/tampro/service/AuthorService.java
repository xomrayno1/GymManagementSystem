package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.AuthorDAO;
import com.tampro.dto.AuthorDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Author;
import com.tampro.utils.ConvertToDTO;

@Service
public class AuthorService {
	@Autowired
	AuthorDAO<Author> authorDAO;

	public void add(AuthorDTO authorDTO)  throws Exception{
		Author author = new Author();
		author.setActiveFlag(1);
		author.setCreateDate(new Date());
		author.setDescription(authorDTO.getDescription());
		author.setEmail(authorDTO.getEmail());
		author.setName(authorDTO.getName());
		author.setUpdateDate(new Date());
		author.setUrl(ConvertToDTO.removeAccent(authorDTO.getName()));
		authorDAO.add(author);
	}
	public void delete(AuthorDTO authorDTO)  throws Exception{
		Author author = new Author();
		author.setActiveFlag(0);
		author.setCreateDate(authorDTO.getCreateDate());
		author.setDescription(authorDTO.getDescription());
		author.setEmail(authorDTO.getEmail());
		author.setName(authorDTO.getName());
		author.setUpdateDate(new Date());
		author.setId(authorDTO.getId());
		author.setUrl(authorDTO.getUrl());
		authorDAO.delete(author);
	}
	public void update(AuthorDTO authorDTO) throws Exception{
		Author author = new Author();
		author.setActiveFlag(authorDTO.getActiveFlag());
		author.setCreateDate(authorDTO.getCreateDate());
		author.setDescription(authorDTO.getDescription());
		author.setEmail(authorDTO.getEmail());
		author.setName(authorDTO.getName());
		author.setUpdateDate(new Date());
		author.setId(authorDTO.getId());
		author.setUrl(authorDTO.getUrl());
		authorDAO.update(author);
	}
	public	List<AuthorDTO> getAll(AuthorDTO authorDTO,Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(authorDTO != null) {
			if(!StringUtils.isEmpty(authorDTO.getName()) && authorDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+authorDTO.getName()+"%");
			}
		}	
		List<AuthorDTO> list = new ArrayList<AuthorDTO>();
		for(Author author : authorDAO.findAll(queryStr.toString(), mapParam, paging)) {
			AuthorDTO dto = ConvertToDTO.convertAuthorEntity(author);
			list.add(dto);
		}
		return list;
	}
	public	List<AuthorDTO> getAllByProperty(String property, Object object){
		List<AuthorDTO> list = new ArrayList<AuthorDTO>();
		for(Author author : authorDAO.findByProperty(property, object)) {
			AuthorDTO dto = ConvertToDTO.convertAuthorEntity(author);
			list.add(dto);
		}
		return list;
	}
	public	AuthorDTO findById(int id) {
		Author author = authorDAO.findById(Author.class, id);
		AuthorDTO authorDTO = 	ConvertToDTO.convertAuthorEntity(author);
		return authorDTO;
	}
}
