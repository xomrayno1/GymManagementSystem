package com.tampro.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.PublisherDAO;
import com.tampro.entity.Publisher;

import org.springframework.stereotype.Repository;

@Repository
@Transactional(rollbackFor = Exception.class)
public class PublisherDAOImpl  extends BaseDAOImpl<Publisher> implements PublisherDAO<Publisher>{

}
