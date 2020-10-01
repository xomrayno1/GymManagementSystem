package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.ReviewsDAO;
import com.tampro.entity.Reviews;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ReviewsDAOImpl extends BaseDAOImpl<Reviews> implements ReviewsDAO<Reviews>	{

}
