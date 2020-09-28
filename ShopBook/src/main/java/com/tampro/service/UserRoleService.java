package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.UserRoleDAO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.entity.Role;
import com.tampro.entity.User;
import com.tampro.entity.UserRole;
import com.tampro.utils.ConvertToDTO;

@Service
public class UserRoleService {
	@Autowired
	UserRoleDAO<UserRole> userRoleDAO;
	
	public void add(UserRoleDTO userRoleDTO) {
		UserRole userRole = new UserRole();
		userRole.setActiveFlag(1);
		userRole.setCreateDate(new Date());
		userRole.setRole(new Role(userRoleDTO.getIdRole()));
		userRole.setUpdateDate(new Date());
		userRole.setUser(new User(userRoleDTO.getIdUser()));
		userRoleDAO.add(userRole);
	}
	public void update(UserRoleDTO userRoleDTO) {
		UserRole userRole = new UserRole();
		userRole.setActiveFlag(userRoleDTO.getActiveFlag());
		userRole.setCreateDate(userRoleDTO.getCreateDate());
		userRole.setId(userRoleDTO.getId());
		userRole.setRole(new Role(userRoleDTO.getIdRole()));
		userRole.setUpdateDate(new Date());
		userRole.setUser(new User(userRoleDTO.getIdUser()));
		userRoleDAO.update(userRole);
	}
	public UserRoleDTO findById(int id) {
		UserRole userRole = userRoleDAO.findById(UserRole.class, id);
		UserRoleDTO roleDTO = ConvertToDTO.convertUserRoleEntity(userRole);
		return roleDTO;
	}
	public List<UserRoleDTO> getAllByProperty(String property, Object object) {
		List<UserRoleDTO> list = new ArrayList<UserRoleDTO>();
		for(UserRole userRole : userRoleDAO.findByProperty(property, object)) {
			UserRoleDTO roleDTO = ConvertToDTO.convertUserRoleEntity(userRole);
			list.add(roleDTO);
		}
		return list;
	}
	public void delete(UserRoleDTO userRoleDTO) {
		UserRole userRole = new UserRole();
		userRole.setActiveFlag(0);
		userRole.setCreateDate(userRoleDTO.getCreateDate());
		userRole.setId(userRoleDTO.getId());
		userRole.setRole(new Role(userRoleDTO.getIdRole()));
		userRole.setUpdateDate(new Date());
		userRole.setUser(new User(userRoleDTO.getIdUser()));
		userRoleDAO.delete(userRole);
	}
}
