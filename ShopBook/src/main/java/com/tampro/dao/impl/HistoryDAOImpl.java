package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.HistoryDAO;
import com.tampro.entity.History;

@Transactional(rollbackFor = Exception.class)
@Repository
public class HistoryDAOImpl  extends BaseDAOImpl<History> implements HistoryDAO<History>{

}
