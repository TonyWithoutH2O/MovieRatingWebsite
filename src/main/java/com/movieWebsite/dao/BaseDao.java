package com.movieWebsite.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * Save an object
	 * @param o
	 * @return
	 */
	public Serializable save(T o);
	
	/**
	 * Delete an object
	 * @param o
	 */
	public void delete(T o);
	
	/**
	 * Update an object
	 * @param o
	 */
	public void update(T o);
	
	/**
	 * Get an object
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, Object[] param);
	
	/**
	 * Find using hql
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param);
	
	/**
	 * Execute a hql statement
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, Object[] param);
}
