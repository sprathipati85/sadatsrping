package com.spring.sadat.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sadat.dao.CurrencyInfoDao;
import com.spring.sadat.model.CurrencyInfo;

@Repository
public class CurrencyInfoDaoImpl implements CurrencyInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveCurrencyInfo(CurrencyInfo currencyInfo) {
		getSession().merge(currencyInfo);

	}

	@SuppressWarnings("unchecked")
	public List<CurrencyInfo> listCurrencyInfo() {

		return getSession().createCriteria(CurrencyInfo.class).list();
	}

	public CurrencyInfo getCurrencyInfo(String country) {
		return (CurrencyInfo) getSession().get(CurrencyInfo.class, country);
	}

	public void deleteCurrencyInfo(String country) {

		CurrencyInfo currencyInfo = getCurrencyInfo(country);

		if (null != currencyInfo) {
			getSession().delete(currencyInfo);
		}

	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
