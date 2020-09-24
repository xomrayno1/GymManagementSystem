package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.PublisherDAO;
import com.tampro.dto.Paging;
import com.tampro.dto.PublisherDTO;
import com.tampro.entity.Publisher;
import com.tampro.utils.ConvertToDTO;

@Service
public class PublisherService {
	@Autowired
	PublisherDAO<Publisher> publisherDAO;
	
	public void add(PublisherDTO publisherDTO) throws Exception {
		Publisher publisher = new Publisher();
		publisher.setActiveFlag(1);
		publisher.setAddress(publisherDTO.getAddress());
		publisher.setCode(publisherDTO.getCode());
		publisher.setCreateDate(new Date());
		publisher.setEmail(publisherDTO.getEmail());
		publisher.setName(publisherDTO.getName());
		publisher.setPhone(publisherDTO.getPhone());
		publisher.setUpdateDate(new Date());
		publisher.setWebiste(publisherDTO.getWebiste());
		publisher.setUrl("/"+ConvertToDTO.removeAccent(publisherDTO.getName()));
		publisherDAO.add(publisher);
	}
	public	void delete(PublisherDTO publisherDTO)  throws Exception{
		Publisher publisher = new Publisher();
		publisher.setActiveFlag(0);
		publisher.setAddress(publisherDTO.getAddress());
		publisher.setCode(publisherDTO.getCode());
		publisher.setCreateDate(publisherDTO.getCreateDate());
		publisher.setEmail(publisherDTO.getEmail());
		publisher.setName(publisherDTO.getName());
		publisher.setPhone(publisherDTO.getPhone());
		publisher.setUpdateDate(new Date());
		publisher.setWebiste(publisherDTO.getWebiste());
		publisher.setId(publisherDTO.getId());
		publisher.setUrl(publisherDTO.getUrl());
		publisherDAO.delete(publisher);
	}
	public	void update(PublisherDTO publisherDTO)  throws Exception{
		Publisher publisher = new Publisher();
		publisher.setActiveFlag(publisherDTO.getActiveFlag());
		publisher.setAddress(publisherDTO.getAddress());
		publisher.setCode(publisherDTO.getCode());
		publisher.setCreateDate(publisherDTO.getCreateDate());
		publisher.setEmail(publisherDTO.getEmail());
		publisher.setName(publisherDTO.getName());
		publisher.setPhone(publisherDTO.getPhone());
		publisher.setUpdateDate(new Date());
		publisher.setWebiste(publisherDTO.getWebiste());
		publisher.setId(publisherDTO.getId());
		publisher.setUrl(publisherDTO.getUrl());
		publisherDAO.update(publisher);
	}
	public	List<PublisherDTO> getAll(PublisherDTO publisherDTO,Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(publisherDTO != null) {
			if(!StringUtils.isEmpty(publisherDTO.getCode()) && publisherDTO.getCode() != null) {
				queryStr.append(" and model.code =:code ");
				mapParam.put("code", publisherDTO.getCode());
			}
			if(!StringUtils.isEmpty(publisherDTO.getName()) && publisherDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+publisherDTO.getName()+"%");
			}
		}	
		List<PublisherDTO> list = new ArrayList<PublisherDTO>();
		for(Publisher publisher : publisherDAO.findAll(queryStr.toString(), mapParam, paging)) {
			PublisherDTO dto = ConvertToDTO.convertPublisherEntity(publisher);
			list.add(dto);
		}
		return list;
	}
	public	List<PublisherDTO> getAllByProperty(String property, Object object){
		List<PublisherDTO> list = new ArrayList<PublisherDTO>();
		for(Publisher publisher : publisherDAO.findByProperty(property, object)) {
			PublisherDTO dto = ConvertToDTO.convertPublisherEntity(publisher);
			list.add(dto);
		}
		return list;
	}
	public	PublisherDTO findById(int id) {
		Publisher publisher = publisherDAO.findById(Publisher.class, id);
		PublisherDTO publisherDTO = ConvertToDTO.convertPublisherEntity(publisher);
		return publisherDTO;
	}

}
