package com.tampro.dao;

import com.tampro.entity.User;

public interface UserDAO<E>  extends BaseDAO<E> {
	int addInt(User user);

}
