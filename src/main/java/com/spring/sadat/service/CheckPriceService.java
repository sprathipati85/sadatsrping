package com.spring.sadat.service;

import java.util.List;

import com.spring.sadat.model.CurrencyInfo;

public interface CheckPriceService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveCurrencyInfo(CurrencyInfo currencyInfo);

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
