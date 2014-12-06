package com.spring.sadat.dao;

import java.util.List;

import com.spring.sadat.model.CurrencyInfo;

public interface CurrencyInfoDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveCurrencyInfo(CurrencyInfo currencyInfo); // create and update

	/*
	 * READ
	 */
	public List<CurrencyInfo> listCurrencyInfo();
	public CurrencyInfo getCurrencyInfo(String country);

	/*
	 * DELETE
	 */
	public void deleteCurrencyInfo(String country);
}
