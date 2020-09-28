package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.UserDAO;
import com.tampro.entity.User;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl extends BaseDAOImpl<User>  implements UserDAO<User>{
	@Override
	public int addInt(User user) {
		// TODO Auto-generated method stub
		return (int) factory.getCurrentSession().save(user);
	}
}
