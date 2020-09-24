package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.AuthorDAO;
import com.tampro.entity.Author;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AuthorDAOImpl extends BaseDAOImpl<Author> implements AuthorDAO<Author>{

}
