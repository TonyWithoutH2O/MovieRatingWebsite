package com.movieWebsite.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.movieWebsite.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
		
	}

	@Override
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	@Override
	public T get(String hql, Object[] param) {
		List<T> list = find(hql, param);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Object[] param) {
		Query query = getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.list();	
	}

	@Override
	public Integer executeHql(String hql, Object[] param) {
		Query query = getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.executeUpdate();
	}
	
}
