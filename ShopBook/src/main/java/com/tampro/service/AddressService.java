package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.AddressDAO;
import com.tampro.dto.AddressDTO;
import com.tampro.entity.Address;
import com.tampro.entity.User;
import com.tampro.utils.ConvertToDTO;

@Service
public class AddressService {
	@Autowired
	AddressDAO<Address> addressDAO;
	
	public void add(AddressDTO addressDTO)  throws Exception{
		Address address  = new Address();
		address.setActiveFlag(1);
		address.setCreateDate(new Date());
		address.setDescription(addressDTO.getDescription());
		address.setName(addressDTO.getName());
		address.setUpdateDate(new Date());
		address.setPhone(addressDTO.getPhone());
		address.setProvince(addressDTO.getProvince());
		address.setDistrict(addressDTO.getDistrict());
		address.setCommune(addressDTO.getCommune());
		address.setUser(new User(addressDTO.getIdUser()));
		addressDAO.add(address);
	}
	public void delete(AddressDTO addressDTO)  throws Exception{
		Address address  = new Address();
		address.setActiveFlag(0);
		address.setCreateDate(addressDTO.getCreateDate());
		address.setDescription(addressDTO.getDescription());
		address.setName(addressDTO.getName());
		address.setUpdateDate(new Date());
		address.setId(addressDTO.getId());
		address.setPhone(addressDTO.getPhone());
		address.setProvince(addressDTO.getProvince());
		address.setDistrict(addressDTO.getDistrict());
		address.setCommune(addressDTO.getCommune());
		address.setUser(new User(addressDTO.getIdUser()));
		addressDAO.delete(address);
	}
	public void update(AddressDTO addressDTO) throws Exception{
		Address address  = new Address();
		address.setActiveFlag(addressDTO.getActiveFlag());
		address.setCreateDate(addressDTO.getCreateDate());
		address.setDescription(addressDTO.getDescription());
		address.setName(addressDTO.getName());
		address.setUpdateDate(new Date());
		address.setId(addressDTO.getId());
		address.setPhone(addressDTO.getPhone());
		address.setProvince(addressDTO.getProvince());
		address.setDistrict(addressDTO.getDistrict());
		address.setCommune(addressDTO.getCommune());
		address.setUser(new User(addressDTO.getIdUser()));
		addressDAO.update(address);
	}
	public	List<AddressDTO> getAllByProperty(String property, Object object){
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		for(Address address : addressDAO.findByProperty(property, object)) {
			AddressDTO dto = ConvertToDTO.convertAddressEntity(address);
			list.add(dto);
		}
		return list;
	}
	public	AddressDTO findById(int id) {
		Address address = addressDAO.findById(Address.class, id);
		AddressDTO addressDTO = ConvertToDTO.convertAddressEntity(address);
		return addressDTO;
	}

}
