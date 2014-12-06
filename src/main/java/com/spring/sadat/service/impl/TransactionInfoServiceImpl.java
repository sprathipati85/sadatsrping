package com.spring.sadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sadat.dao.TransactionInfoDao;
import com.spring.sadat.model.TransactionInfo;
import com.spring.sadat.service.TransactionInfoService;

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {

	@Autowired
	private TransactionInfoDao transactionInfoDao;

	@Transactional
	public void saveTransactionInfo(TransactionInfo transactionInfo) {
		transactionInfoDao.saveTransactionInfo(transactionInfo);
	}

	@Transactional(readOnly = true)
	public List<TransactionInfo> listTransactionInfo() {
		return transactionInfoDao.listTransactionInfo();
	}

	@Transactional(readOnly = true)
	public TransactionInfo getTransactionInfo(Long id) {
		return transactionInfoDao.getTransactionInfo(id);
	}

	@Transactional
	public void deleteTransactionInfo(Long id) {
		transactionInfoDao.deleteTransactionInfo(id);

	}

}
