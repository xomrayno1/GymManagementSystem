package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.WishListDAO;
import com.tampro.entity.WishList;

@Repository
@Transactional(rollbackFor = Exception.class)
public class WishListDAOImpl extends BaseDAOImpl<WishList> implements WishListDAO<WishList> {

}
