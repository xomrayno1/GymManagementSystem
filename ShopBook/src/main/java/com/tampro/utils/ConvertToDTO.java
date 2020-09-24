package com.tampro.utils;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.AuthorDTO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.PublisherDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.UserDTO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.entity.Auth;
import com.tampro.entity.Author;
import com.tampro.entity.Category;
import com.tampro.entity.Menu;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.Publisher;
import com.tampro.entity.Role;
import com.tampro.entity.User;
import com.tampro.entity.UserRole;

public class ConvertToDTO {

	public static CategoryDTO convertCategoryEntity(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setActiveFlag(category.getActiveFlag());
		categoryDTO.setCode(category.getCode());
		categoryDTO.setCreateDate(category.getCreateDate());
		categoryDTO.setId(category.getId());
		categoryDTO.setIdParent(category.getIdParent());
		categoryDTO.setImgUrl(category.getImgUrl());
		categoryDTO.setName(category.getName());
		categoryDTO.setUpdateDate(category.getUpdateDate());
		categoryDTO.setUrl(category.getUrl());		
		return categoryDTO;		
	}
	public static AuthorDTO convertAuthorEntity(Author author) {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setActiveFlag(author.getActiveFlag());
		authorDTO.setCreateDate(author.getCreateDate());
		authorDTO.setDescription(author.getDescription());
		authorDTO.setEmail(author.getEmail());
		authorDTO.setId(author.getId());
		authorDTO.setName(author.getName());
		authorDTO.setUpdateDate(author.getUpdateDate());
		authorDTO.setUrl(author.getUrl());
		return authorDTO;
	}
	public static UserDTO convertUserEntity(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setActiveFlag(user.getActiveFlag());
		userDTO.setBirthDay(user.getBirthDay());
		userDTO.setCreateDate(user.getCreateDate());
		userDTO.setEmail(user.getEmail());
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhone(user.getPhone());
		userDTO.setUpdateDate(user.getUpdateDate());
		userDTO.setUsername(user.getUsername());
		Set<UserRoleDTO> userRoleDTOs = new HashSet();
		for(UserRole userRole : user.getUserRole()) {
			UserRoleDTO dto = convertUserRoleEntity(userRole);
			userRoleDTOs.add(dto);
		}
		userDTO.setUserRoleDTOs(userRoleDTOs);
		return userDTO;
	}
	public static UserRoleDTO convertUserRoleEntity(UserRole userRole) {
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		userRoleDTO.setActiveFlag(userRole.getActiveFlag());
		userRoleDTO.setCreateDate(userRole.getCreateDate());
		userRoleDTO.setId(userRole.getId());
		userRoleDTO.setIdUser(userRole.getUser().getId());
		RoleDTO roleDTO = convertRoleEntity(userRole.getRole());
		userRoleDTO.setRoleDTO(roleDTO);
		userRoleDTO.setUpdateDate(userRole.getUpdateDate());
		return userRoleDTO;
	}
	public static RoleDTO convertRoleEntity(Role role) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setActiveFlag(role.getActiveFlag());
		roleDTO.setCreateDate(role.getCreateDate());
		roleDTO.setDescription(role.getDescription());
		roleDTO.setId(role.getId());
		roleDTO.setName(role.getName());
		roleDTO.setUpdateDate(role.getUpdateDate());
		Set<AuthDTO> authDTOs = new HashSet<AuthDTO>();
		for(Auth item : role.getAuths()) {
			AuthDTO authDTO = convertAuthEntity(item);
			authDTOs.add(authDTO);
		}
		roleDTO.setAuths(authDTOs);
		return roleDTO;
	}
	public static AuthDTO convertAuthEntity(Auth auth) {
		AuthDTO authDTO = new AuthDTO();
		authDTO.setId(auth.getId());
		authDTO.setIdRole(auth.getRole().getId());
		MenuDTO menuDTO = convertMenuEntity(auth.getMenu());
		authDTO.setMenuDTO(menuDTO);
		authDTO.setActiveFlag(auth.getActiveFlag());
		authDTO.setCreateDate(auth.getCreateDate());
		authDTO.setUpdateDate(auth.getUpdateDate());
		authDTO.setPermission(auth.getPermission());
		return authDTO;
	}
	public static MenuDTO convertMenuEntity(Menu menu) {
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setActiveFlag(menu.getActiveFlag());
		menuDTO.setCreateDate(menu.getCreateDate());
		menuDTO.setId(menu.getId());
		menuDTO.setIdParent(menu.getIdParent());
		menuDTO.setName(menu.getName());
		menuDTO.setOrderIndex(menu.getOrderIndex());
		menuDTO.setUpdateDate(menu.getUpdateDate());
		menuDTO.setUrl(menu.getUrl());
		return menuDTO;
	}

	public static PublisherDTO convertPublisherEntity(Publisher publisher) {
		PublisherDTO publisherDTO = new PublisherDTO();
		publisherDTO.setActiveFlag(publisher.getActiveFlag());
		publisherDTO.setAddress(publisher.getAddress());
		publisherDTO.setCode(publisher.getCode());
		publisherDTO.setCreateDate(publisher.getCreateDate());
		publisherDTO.setEmail(publisher.getEmail());
		publisherDTO.setId(publisher.getId());
		publisherDTO.setName(publisher.getName());
		publisherDTO.setPhone(publisher.getPhone());
		publisherDTO.setUpdateDate(publisher.getUpdateDate());
		publisherDTO.setWebiste(publisher.getWebiste());
		publisherDTO.setUrl(publisher.getUrl());
		return publisherDTO;
	}
	public static ProductInfoDTO convertProducInfoEntity(ProductInfo productinfo) {
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO.setActiveFlag(productinfo.getActiveFlag());
		AuthorDTO authorDTO = convertAuthorEntity(productinfo.getAuthor());
		productInfoDTO.setAuthorDTO(authorDTO);
		CategoryDTO categoryDTO = convertCategoryEntity(productinfo.getCategory());
		productInfoDTO.setCategoryDTO(categoryDTO);
		productInfoDTO.setCode(productinfo.getCode());
		productInfoDTO.setCreateDate(productinfo.getCreateDate());
		productInfoDTO.setDateOfPublication(productinfo.getDateOfPublication());
		productInfoDTO.setDescription(productinfo.getDescription());
		productInfoDTO.setId(productinfo.getId());
		productInfoDTO.setImgUrl(productinfo.getImgUrl());
		productInfoDTO.setIdAuthor(productinfo.getAuthor().getId());
		productInfoDTO.setIdCategory(productinfo.getCategory().getId());
		productInfoDTO.setIdPublisher(productinfo.getPublisher().getId());
		productInfoDTO.setISBN(productinfo.getISBN());
		productInfoDTO.setName(productinfo.getName());
		productInfoDTO.setPageNumber(productinfo.getPageNumber());
		productInfoDTO.setPrice(productinfo.getPrice());
		PublisherDTO publisherDTO = convertPublisherEntity(productinfo.getPublisher());
		productInfoDTO.setPublisherDTO(publisherDTO);
		productInfoDTO.setSize(productinfo.getSize());
		productInfoDTO.setStatus(productinfo.getStatus());
		productInfoDTO.setUpdateDate(productinfo.getUpdateDate());
		productInfoDTO.setUrl(productinfo.getUrl());
		return productInfoDTO;
	}
	public static String removeAccent(String url) {
		String temp = Normalizer.normalize(url, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		temp = pattern.matcher(temp).replaceAll("").replace(" ", "-").toLowerCase();
		return temp.replaceAll("đ", "d");
	}
//	public static void main(String[] args) {
//		System.out.println(removeAccent("Fiction - Literature"));
//		System.out.println(removeAccent("Medical Books"));
//	
//
//	}
}
