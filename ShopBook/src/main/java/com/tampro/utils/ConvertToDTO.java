package com.tampro.utils;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.tampro.dto.AddressDTO;
import com.tampro.dto.AuthDTO;
import com.tampro.dto.AuthorDTO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.HistoryDTO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.OrderDTO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.dto.ProductInStockDTO;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.PublisherDTO;
import com.tampro.dto.ReviewDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.ShipmentDetailsDTO;
import com.tampro.dto.UserDTO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.dto.WishListDTO;
import com.tampro.entity.Address;
import com.tampro.entity.Auth;
import com.tampro.entity.Author;
import com.tampro.entity.Category;
import com.tampro.entity.History;
import com.tampro.entity.Invoice;
import com.tampro.entity.Menu;
import com.tampro.entity.Order;
import com.tampro.entity.OrderDetail;
import com.tampro.entity.ProductInStock;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.Publisher;
import com.tampro.entity.Reviews;
import com.tampro.entity.Role;
import com.tampro.entity.ShipmentDetails;
import com.tampro.entity.User;
import com.tampro.entity.UserRole;
import com.tampro.entity.WishList;

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
		categoryDTO.setIdCategory(category.getUrl().replace("-", "").replace("&", "")+"Id");
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
	public static ReviewDTO convertReviewEntity(Reviews reviews) {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setActiveFlag(reviews.getActiveFlag());
		reviewDTO.setContent(reviews.getContent());
		reviewDTO.setCreateDate(reviews.getCreateDate());
		reviewDTO.setEmail(reviews.getEmail());
		reviewDTO.setId(reviews.getId());
		reviewDTO.setName(reviews.getName());
		reviewDTO.setIdProduct(reviews.getProductInfo().getId());
		reviewDTO.setRating(reviews.getRating());
		reviewDTO.setUpdateDate(reviews.getUpdateDate());
		if(reviews.getUser() != null) {
			reviewDTO.setIdUser(reviews.getUser().getId());
		}
		return reviewDTO;
	}
	public static AddressDTO convertAddressEntity(Address address) {
		AddressDTO addressDTO= new AddressDTO();
		addressDTO.setActiveFlag(address.getActiveFlag());
		addressDTO.setCreateDate(address.getCreateDate());
		addressDTO.setDescription(address.getDescription());
		addressDTO.setCommune(address.getCommune());
		addressDTO.setDistrict(address.getDistrict());
		addressDTO.setProvince(address.getProvince());
		addressDTO.setUpdateDate(address.getUpdateDate());
		addressDTO.setPhone(address.getPhone());
		addressDTO.setName(address.getName());
		addressDTO.setIdUser(address.getUser().getId());
		addressDTO.setId(address.getId());
		return addressDTO;
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
		RoleDTO roleDTO = convertRoleEntity(user.getUserRole().iterator().next().getRole());
		userDTO.setRoleDTO(roleDTO);
		userDTO.setUserRoleDTOs(userRoleDTOs);
		userDTO.setIdRole(user.getUserRole().iterator().next().getRole().getId());
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
		productInfoDTO.setUpdateDate(productinfo.getUpdateDate());
		productInfoDTO.setUrl(productinfo.getUrl());
		return productInfoDTO;
	}
	public static WishListDTO convertWishListEntity(WishList wishList) {
		WishListDTO wishListDTO = new WishListDTO();
		wishListDTO.setActiveFlag(wishList.getActiveFlag());
		wishListDTO.setCreateDate(wishList.getCreateDate());
		wishListDTO.setId(wishList.getId());
		ProductInfoDTO productInfoDTO = convertProducInfoEntity(wishList.getProductInfo());
		wishListDTO.setProductInfoDTO(productInfoDTO);
		wishListDTO.setUpdateDate(wishList.getUpdateDate());
		wishListDTO.setIdUser(wishList.getUser().getId());
		return wishListDTO;
		
	}
	public static OrderDTO convertOrderEntity(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setActiveFlag(order.getActiveFlag());
		orderDTO.setCreateDate(order.getCreateDate());
		orderDTO.setId(order.getId());
		orderDTO.setIdUser(order.getUser().getId());
		orderDTO.setSales(order.getSales());
		ShipmentDetailsDTO shipmentDetails = convertShipmentDetailsEntity(order.getShipmentDetails());
		orderDTO.setShipmentDetails(shipmentDetails);
		orderDTO.setStatus(order.getStatus());
		orderDTO.setSubTotal(order.getSubTotal());
		orderDTO.setTotalPrice(order.getTotalPrice());
		orderDTO.setUpdateDate(order.getUpdateDate());
		orderDTO.setVat(order.getVat());
		return orderDTO;
		
	}
	public static OrderDetailDTO convertOrderDetailEntity(OrderDetail orderDetail) {
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setActiveFlag(orderDetail.getActiveFlag());
		orderDetailDTO.setCreateDate(orderDetail.getCreateDate());
		orderDetailDTO.setId(orderDetail.getId());
		orderDetailDTO.setIdOrder(orderDetail.getOrder().getId());
		orderDetailDTO.setPrice(orderDetail.getPrice());
		ProductInfoDTO productInfoDTO = convertProducInfoEntity(orderDetail.getProductInfo());
		orderDetailDTO.setProductInfoDTO(productInfoDTO);
		orderDetailDTO.setQuantity(orderDetail.getQuantity());
		orderDetailDTO.setStatus(orderDetail.getStatus());
		orderDetailDTO.setTotalPrice(orderDetail.getTotalPrice());
		orderDetailDTO.setUpdateDate(orderDetail.getUpdateDate());
		return orderDetailDTO;
	}
	public static ShipmentDetailsDTO convertShipmentDetailsEntity(ShipmentDetails shipmentDetails) {
		ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO();
		shipmentDetailsDTO.setActiveFlag(shipmentDetails.getActiveFlag());
		shipmentDetailsDTO.setCommune(shipmentDetails.getCommune());
		shipmentDetailsDTO.setCreateDate(shipmentDetails.getCreateDate());
		shipmentDetailsDTO.setDescription(shipmentDetails.getDescription());
		shipmentDetailsDTO.setDistrict(shipmentDetails.getDistrict());
		shipmentDetailsDTO.setId(shipmentDetails.getId());
		shipmentDetailsDTO.setIdUser(shipmentDetails.getUser().getId());
		shipmentDetailsDTO.setName(shipmentDetails.getName());
		shipmentDetailsDTO.setPhone(shipmentDetails.getPhone());
		shipmentDetailsDTO.setProvince(shipmentDetails.getProvince());
		shipmentDetailsDTO.setUpdateDate(shipmentDetails.getUpdateDate());
		return shipmentDetailsDTO;
	}
	public static ProductInStockDTO convertProductInStockEntity(ProductInStock ProductInStock) {
		ProductInStockDTO productInStockDTO = new ProductInStockDTO();
		productInStockDTO.setActiveFlag(ProductInStock.getActiveFlag());
		productInStockDTO.setCreateDate(ProductInStock.getCreateDate());
		productInStockDTO.setId(ProductInStock.getId());
		productInStockDTO.setIdProduct(ProductInStock.getProductInfo().getId());
		productInStockDTO.setQuantity(ProductInStock.getQuantity());
		productInStockDTO.setUpdateDate(ProductInStock.getUpdateDate());
		return productInStockDTO;
	}
	public static HistoryDTO convertHistoryEntity(History history) {
		HistoryDTO historyDTO = new HistoryDTO();
		historyDTO.setActionName(history.getActionName());
		historyDTO.setActiveFlag(history.getActiveFlag());
		historyDTO.setCreateDate(history.getCreateDate());
		historyDTO.setId(history.getId());
		historyDTO.setPrice(history.getPrice());
		ProductInfoDTO productInfoDTO = convertProducInfoEntity(history.getProductInfo());
		historyDTO.setProductInfoDTO(productInfoDTO);
		historyDTO.setQuantity(history.getQuantity());
		historyDTO.setTotalPrice(history.getTotalPrice());
		historyDTO.setType(history.getType());
		historyDTO.setUpdateDate(history.getUpdateDate());
		UserDTO userDTO = convertUserEntity(history.getUser());
		historyDTO.setUserDTO(userDTO);
		return historyDTO;
	}
	public static InvoiceDTO convertInvoiceEntity(Invoice invoice) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setActiveFlag(invoice.getActiveFlag());
		invoiceDTO.setCreateDate(invoice.getCreateDate());
		invoiceDTO.setId(invoice.getId());
		invoiceDTO.setPrice(invoice.getPrice());
		ProductInfoDTO productInfoDTO = convertProducInfoEntity(invoice.getProductInfo());
		invoiceDTO.setProductInfoDTO(productInfoDTO);
		invoiceDTO.setQuantity(invoice.getQuantity());
		invoiceDTO.setTotalPrice(invoice.getTotalPrice());
		invoiceDTO.setIdProduct(invoice.getProductInfo().getId());
		invoiceDTO.setType(invoice.getType());
		invoiceDTO.setUpdateDate(invoice.getUpdateDate());
		UserDTO userDTO = convertUserEntity(invoice.getUser());
		invoiceDTO.setUserDTO(userDTO);
		return invoiceDTO;
	}
	public static String removeAccent(String url) {
		String temp = Normalizer.normalize(url, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		temp = pattern.matcher(temp).replaceAll("").replace(" ", "-").replace("'", "").toLowerCase();
		return temp.replaceAll("đ", "d");
	}
//	public static void main(String[] args) {
//		System.out.println(removeAccent("Fiction - Literature"));
//		System.out.println(removeAccent("Medical Books"));
//	
//
//	}
}
