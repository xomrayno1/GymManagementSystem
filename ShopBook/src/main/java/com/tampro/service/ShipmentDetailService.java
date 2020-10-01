package com.tampro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.ShipmentDetailDAO;
import com.tampro.dto.ShipmentDetailsDTO;
import com.tampro.entity.ShipmentDetails;
import com.tampro.entity.User;
import com.tampro.utils.ConvertToDTO;

@Service
public class ShipmentDetailService {
	
	@Autowired
	ShipmentDetailDAO<ShipmentDetails> shipmentDetailDAO;
	
	public List<ShipmentDetailsDTO> getAllByProperty(String property, Object object){
		return null;
	}
	public ShipmentDetailsDTO findById(int id) {
		ShipmentDetails shipmentDetails = shipmentDetailDAO.findById(ShipmentDetails.class, id);
		ShipmentDetailsDTO shipmentDetailsDTO = ConvertToDTO.convertShipmentDetailsEntity(shipmentDetails);
		return shipmentDetailsDTO;
	}
	public int addInt(ShipmentDetailsDTO shipmentDetailsDTO) {
		ShipmentDetails shipmentDetails = new ShipmentDetails();
		shipmentDetails.setActiveFlag(1);
		shipmentDetails.setCommune(shipmentDetailsDTO.getCommune());
		shipmentDetails.setCreateDate( new Date());
		shipmentDetails.setDescription(shipmentDetailsDTO.getDescription());
		shipmentDetails.setDistrict(shipmentDetailsDTO.getDistrict());
		shipmentDetails.setPhone(shipmentDetailsDTO.getPhone());
		shipmentDetails.setName(shipmentDetailsDTO.getName());
		shipmentDetails.setProvince(shipmentDetailsDTO.getProvince());
		shipmentDetails.setUpdateDate(new Date());
		shipmentDetails.setUser(new User(shipmentDetailsDTO.getIdUser()));
		return shipmentDetailDAO.addInt(shipmentDetails);
	}
	public void update(ShipmentDetailsDTO shipmentDetailsDTO) {
		ShipmentDetails shipmentDetails = new ShipmentDetails();
		shipmentDetails.setActiveFlag(shipmentDetailsDTO.getActiveFlag());
		shipmentDetails.setCommune(shipmentDetailsDTO.getCommune());
		shipmentDetails.setCreateDate( shipmentDetailsDTO.getCreateDate());
		shipmentDetails.setDescription(shipmentDetailsDTO.getDescription());
		shipmentDetails.setDistrict(shipmentDetailsDTO.getDistrict());
		shipmentDetails.setPhone(shipmentDetailsDTO.getPhone());
		shipmentDetails.setName(shipmentDetailsDTO.getName());
		shipmentDetails.setProvince(shipmentDetailsDTO.getProvince());
		shipmentDetails.setUpdateDate(new Date());
		shipmentDetails.setUser(new User(shipmentDetailsDTO.getIdUser()));
		shipmentDetailDAO.update(shipmentDetails);
	}
	public void delete(ShipmentDetailsDTO shipmentDetailsDTO) {
		ShipmentDetails shipmentDetails = new ShipmentDetails();
		shipmentDetails.setActiveFlag(0);
		shipmentDetails.setCommune(shipmentDetailsDTO.getCommune());
		shipmentDetails.setCreateDate( shipmentDetailsDTO.getCreateDate());
		shipmentDetails.setDescription(shipmentDetailsDTO.getDescription());
		shipmentDetails.setDistrict(shipmentDetailsDTO.getDistrict());
		shipmentDetails.setPhone(shipmentDetailsDTO.getPhone());
		shipmentDetails.setName(shipmentDetailsDTO.getName());
		shipmentDetails.setProvince(shipmentDetailsDTO.getProvince());
		shipmentDetails.setUpdateDate(new Date());
		shipmentDetails.setUser(new User(shipmentDetailsDTO.getIdUser()));
		shipmentDetailDAO.delete(shipmentDetails);
	}
}
