package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.RoleDAO;
import com.tampro.dto.Paging;
import com.tampro.dto.RoleDTO;
import com.tampro.entity.Role;
import com.tampro.utils.ConvertToDTO;

@Service
public class RoleService {
	@Autowired
	RoleDAO<Role> roleDAO;
	
	public void add(RoleDTO roleDTO) throws Exception {
		Role role = new Role();
		role.setActiveFlag(1);
		role.setCreateDate(new Date());
		role.setDescription(roleDTO.getDescription());
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setUpdateDate(new Date());
		roleDAO.add(role);
	}
	public void delete(RoleDTO roleDTO) throws Exception{
		Role role = new Role();
		role.setActiveFlag(0);
		role.setCreateDate(roleDTO.getCreateDate());
		role.setDescription(roleDTO.getDescription());
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setUpdateDate(new Date());
		roleDAO.delete(role);
	}
	public void update(RoleDTO roleDTO) throws Exception{
		Role role = new Role();
		role.setActiveFlag(roleDTO.getActiveFlag());
		role.setCreateDate(roleDTO.getCreateDate());
		role.setDescription(roleDTO.getDescription());
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setUpdateDate(new Date());
		roleDAO.update(role);
	}
	public List<RoleDTO> getAll( Paging paging){
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		for(Role role : roleDAO.findAll(null, null, paging)) {
			RoleDTO roleDTO  = ConvertToDTO.convertRoleEntity(role);
			list.add(roleDTO);
		}
		return list;
	}
	public RoleDTO findById(int id) {
		Role role = roleDAO.findById(Role.class, id);
		RoleDTO roleDTO = ConvertToDTO.convertRoleEntity(role);
		return roleDTO;
	}
	public List<RoleDTO> findByProperty(String property , Object object){
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		for(Role role : roleDAO.findByProperty(property,object)) {
			RoleDTO roleDTO  = ConvertToDTO.convertRoleEntity(role);
			list.add(roleDTO);
		}
		return list;
	}

}
