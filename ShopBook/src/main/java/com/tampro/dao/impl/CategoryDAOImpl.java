package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.CategoryDAO;
import com.tampro.entity.Category;

@Repository
@Transactional(rollbackFor = Exception.class)
public class CategoryDAOImpl  extends BaseDAOImpl<Category> implements CategoryDAO<Category> {

}
