package com.spring.sadat.service;

import java.util.List;

import com.spring.sadat.model.TransactionInfo;

public interface TransactionInfoService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveTransactionInfo(TransactionInfo transactionInfo);

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
