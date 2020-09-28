package com.tampro.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.BaseDAO;
import com.tampro.dto.Paging;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImpl<E>  implements BaseDAO<E>{
	@Autowired
	SessionFactory factory;

	public E findById(Class<E> instance, Serializable id) {
		// TODO Auto-generated method stub
		System.out.println("==========find by id===========");
		return factory.getCurrentSession().find(instance, id);
	}

	public List<E> findByProperty(String property, Object object) {
		// TODO Auto-generated method stub
		System.out.println("==========find by property===========");	
		StringBuilder query = new StringBuilder();
		query.append(" FROM ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		String newStr = property.replace(".", "");
		if(property !=null) {
			query.append(" and  model."+property).append(" =:"+newStr);
		}
		
		System.out.println("SQL : "+query.toString());
		Query<E> queryStr = factory.getCurrentSession().createQuery(query.toString());
 		if(object !=null) {
 			queryStr.setParameter(newStr, object);
		}
		return queryStr.getResultList();
	}
	public List<E> findByPropertySort(String property, Object object, Paging paging , String sort) {
		// TODO Auto-generated method stub
		System.out.println("==========find by property===========");	
		StringBuilder query = new StringBuilder();
		StringBuilder countSelect = new StringBuilder();
		query.append(" FROM ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		countSelect.append("SELECT COUNT(*) FROM ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		String newStr = property.replace(".", "");
		if(property !=null) {
			query.append(" and  model."+property).append(" =:"+newStr);
			countSelect.append(" and  model."+property).append(" =:"+newStr);
		}
		if(sort != null) {
			if(sort.contains("gia-tang")) {
				query.append(" ORDER BY model.price ASC ");
			}else if(sort.contains("gia-giam")) {
				query.append(" ORDER BY model.price DESC ");
			}
		}
		System.out.println("SQL : "+query.toString());
		Query<E> queryStr = factory.getCurrentSession().createQuery(query.toString());
		Query<E> count = factory.getCurrentSession().createQuery(countSelect.toString());
 		if(object !=null) {
 			queryStr.setParameter(newStr, object);
 			count.setParameter(newStr, object);
		} 		
		if(paging != null) {
			long totalProduct = (Long) count.uniqueResult();
			paging.setTotalProduct(totalProduct);
			queryStr.setFirstResult(paging.getOffSet());
			queryStr.setMaxResults(paging.getNumberPerPage());
		}
 		
		return queryStr.getResultList();
	}

	public List<E> findAll(String queryStr, Map<String, Object> mapParam, Paging paging) {
		// TODO Auto-generated method stub
		System.out.println("==========find all===========");
		StringBuilder querySelect = new StringBuilder();
		StringBuilder countSelect = new StringBuilder();
		querySelect.append(" FROM ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		countSelect.append("SELECT COUNT(*) FROM ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		if(queryStr != null) {
			querySelect.append(queryStr);
			countSelect.append(queryStr);
		}
		Query<E> query  = factory.getCurrentSession().createQuery(querySelect.toString());
		Query<E> count  = factory.getCurrentSession().createQuery(countSelect.toString());
		System.out.println("SQL : "+querySelect.toString());
		if(mapParam != null) {
			for(String key : mapParam.keySet()) {
				query.setParameter(key, mapParam.get(key));
				count.setParameter(key, mapParam.get(key));
			}
		}
		if(paging != null) {
			long totalProduct = (Long) count.uniqueResult();
			paging.setTotalProduct(totalProduct);
			query.setFirstResult(paging.getOffSet());
			query.setMaxResults(paging.getNumberPerPage());
		}
		
		return query.getResultList();
	}

	public void delete(E e) {
		// TODO Auto-generated method stub
		System.out.println("==========delete===========");
		factory.getCurrentSession().merge(e);
	}

	public void update(E e) {
		// TODO Auto-generated method stub
		System.out.println("==========update===========");
		factory.getCurrentSession().merge(e);
	}

	public void add(E e) {
		// TODO Auto-generated method stub
		System.out.println("==========add===========");
		factory.getCurrentSession().persist(e);
	}
	public String getGenericName() { // Trả về class hiện tại đag sử dụng
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>"); // tạo pattern
		Matcher m = pattern.matcher(s); // check xem s có hợp lệ hay k , trả về Matcher
		String generic="null"; 
		if(m.find()) { // kiểm tra 
			generic = m.group(1);
		}
		return generic;
	}
}
