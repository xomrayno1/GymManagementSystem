package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.AddressDAO;
import com.tampro.entity.Address;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AddressDAOImpl  extends BaseDAOImpl<Address> implements AddressDAO<Address>{

}
