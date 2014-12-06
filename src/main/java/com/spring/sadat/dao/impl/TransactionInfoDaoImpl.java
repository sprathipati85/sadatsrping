package com.spring.sadat.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sadat.dao.TransactionInfoDao;
import com.spring.sadat.model.TransactionInfo;

@Repository
public class TransactionInfoDaoImpl implements TransactionInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveTransactionInfo(TransactionInfo transactionInfo) {
		getSession().merge(transactionInfo);

	}

	@SuppressWarnings("unchecked")
	public List<TransactionInfo> listTransactionInfo() {

		return getSession().createCriteria(TransactionInfo.class).list();
	}

	public TransactionInfo getTransactionInfo(Long id) {
		return (TransactionInfo) getSession().get(TransactionInfo.class, id);
	}

	public void deleteTransactionInfo(Long id) {

		TransactionInfo transactionInfo = getTransactionInfo(id);

		if (null != transactionInfo) {
			getSession().delete(transactionInfo);
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
