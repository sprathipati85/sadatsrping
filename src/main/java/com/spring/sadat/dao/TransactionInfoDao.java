package com.spring.sadat.dao;

import java.util.List;

import com.spring.sadat.model.TransactionInfo;

public interface TransactionInfoDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveTransactionInfo(TransactionInfo transactionInfo); // create and update

	/*
	 * READ
	 */
	public List<TransactionInfo> listTransactionInfo();
	public TransactionInfo getTransactionInfo(Long id);

	/*
	 * DELETE
	 */
	public void deleteTransactionInfo(Long id);
}
