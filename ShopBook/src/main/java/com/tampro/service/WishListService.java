package com.tampro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.WishListDAO;
import com.tampro.dto.Paging;
import com.tampro.dto.WishListDTO;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.User;
import com.tampro.entity.WishList;
import com.tampro.utils.ConvertToDTO;

@Service
public class WishListService {

	@Autowired
	WishListDAO<WishList> wishListDAO;
	
	public List<WishListDTO> getAll(WishListDTO wishListDTO , Paging paging){
		StringBuilder queryStr = new  StringBuilder();
		Map<String, Object> mapParam = new HashedMap();
		if(wishListDTO!=null) {
			if(wishListDTO.getIdUser() != 0) {
				queryStr.append(" and  model.user.id =:userId");
				mapParam.put("userId", wishListDTO.getIdUser());
			}
		}
		List<WishListDTO> list = new ArrayList<WishListDTO>();
		for(WishList wishList : wishListDAO.findAll(queryStr.toString(), mapParam, paging)) {
			WishListDTO dto = ConvertToDTO.convertWishListEntity(wishList);
			list.add(dto);
		}
		return list;
	}
	public List<WishListDTO> getAllByProperty(String property , Object object){
		List<WishListDTO> list = new ArrayList<WishListDTO>();
		for(WishList category : wishListDAO.findByProperty(property, object)) {
			WishListDTO dto = ConvertToDTO.convertWishListEntity(category);
			list.add(dto);
		}
		return list;
	}

	public void delete(WishListDTO  wishListDTO) throws Exception {
			WishList wishList  = new WishList();
			wishList.setActiveFlag(0);
			wishList.setCreateDate(wishListDTO.getCreateDate());
			wishList.setId(wishListDTO.getId());
			wishList.setProductInfo(new ProductInfo(wishListDTO.getProductInfoDTO().getId()));
			wishList.setUpdateDate(new Date());
			wishList.setUser(new User(wishListDTO.getIdUser()));
			wishListDAO.delete(wishList);
	}
	public void add(int idUser , int idProduct) throws IllegalStateException, IOException {	
			List<WishList> list = wishListDAO.findByProperty("user.id", idUser);
			boolean check = true;
			for(WishList wishList : list) {
				if(wishList.getProductInfo().getId() == idProduct) {
					check = false;
				}
			}
			if(check) {
				WishList wishList  = new WishList();
				wishList.setActiveFlag(1);
				wishList.setCreateDate(new Date());
				wishList.setProductInfo(new  ProductInfo(idProduct));
				wishList.setUpdateDate(new Date());
				wishList.setUser(new User(idUser));
				wishListDAO.add(wishList);
			}
	}
	public WishListDTO findById(int id) {
			WishList wishList = wishListDAO.findById(WishList.class, id);
			WishListDTO wishListDTO = ConvertToDTO.convertWishListEntity(wishList);
			return wishListDTO;
	}
}
