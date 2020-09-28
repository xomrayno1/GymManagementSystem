package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.UserDAO;
import com.tampro.dto.Paging;
import com.tampro.dto.UserDTO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.entity.User;
import com.tampro.utils.ConvertToDTO;

@Service
public class UserService {
	@Autowired
	UserDAO<User> userDAO;
	@Autowired
	UserRoleService userRoleService;
	
	public void add(UserDTO userDTO)  throws Exception{
		User user = new User();
		user.setActiveFlag(1);
		user.setBirthDay(userDTO.getBirthDay());
		user.setCreateDate(new Date());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		user.setUpdateDate(new Date());
		user.setUsername(userDTO.getUsername());
		int id = userDAO.addInt(user);
		userRoleService.add(new UserRoleDTO(id,userDTO.getIdRole()));
 	}
	public void delete(UserDTO userDTO) {
		User user = new User();
		user.setActiveFlag(0);
		user.setBirthDay(userDTO.getBirthDay());
		user.setCreateDate(new Date());
		user.setEmail(userDTO.getEmail());
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		user.setUpdateDate(new Date());
		user.setUsername(userDTO.getUsername());
		userDAO.delete(user);
		List<UserRoleDTO> userRoleDTOs = userRoleService.getAllByProperty("user.id", user.getId());
		if(!userRoleDTOs.isEmpty()) {
			userRoleDTOs.get(0).setIdRole(userDTO.getIdRole());
			userRoleService.delete(userRoleDTOs.get(0));
		}
	}
	public void update(UserDTO userDTO) {
		User user = new User();
		user.setActiveFlag(userDTO.getActiveFlag());
		user.setBirthDay(userDTO.getBirthDay());
		user.setCreateDate(new Date());
		user.setEmail(userDTO.getEmail());
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		user.setUpdateDate(new Date());
		user.setUsername(userDTO.getUsername());
		userDAO.update(user);
		List<UserRoleDTO> userRoleDTOs = userRoleService.getAllByProperty("user.id", user.getId());
		if(!userRoleDTOs.isEmpty()) {
			userRoleDTOs.get(0).setIdRole(userDTO.getIdRole());
			userRoleService.update(userRoleDTOs.get(0));
		}
	}
	public void updatePassword(UserDTO userDTO) {
		User user = new User();
		user.setActiveFlag(userDTO.getActiveFlag());
		user.setBirthDay(userDTO.getBirthDay());
		user.setCreateDate(new Date());
		user.setEmail(userDTO.getEmail());
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		user.setUpdateDate(new Date());
		user.setUsername(userDTO.getUsername());
		userDAO.update(user);
	}
	public List<UserDTO> getAll(UserDTO userDTO,Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(userDTO != null) {
			if(!StringUtils.isEmpty(userDTO.getName()) && userDTO.getName() != null) {
				queryStr.append(" and model.name  like :name ");
				mapParam.put("name", "%"+userDTO.getName()+"%");
			}
		}	
		List<UserDTO> list = new ArrayList<UserDTO>();
		for(User user : userDAO.findAll(queryStr.toString(), mapParam, paging)) {
			UserDTO dto = ConvertToDTO.convertUserEntity(user);
			list.add(dto);
		}
		return list;	
	}
	public List<UserDTO> getAllByProperty(String property, Object object){
		List<UserDTO> list = new ArrayList<UserDTO>();
		for(User user : userDAO.findByProperty(property, object)) {
			UserDTO dto = ConvertToDTO.convertUserEntity(user);
			list.add(dto);
		}
		return list;	
	}
	public UserDTO findById(int id) {
		User user = userDAO.findById(User.class, id);
		UserDTO userDTO = ConvertToDTO.convertUserEntity(user);
		return userDTO;		
	}

}
