package com.spring.sadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sadat.dao.CurrencyInfoDao;
import com.spring.sadat.model.CurrencyInfo;
import com.spring.sadat.service.CheckPriceService;

@Service
public class CheckPriceServiceImpl implements CheckPriceService {

	@Autowired
	private CurrencyInfoDao currencyInfoDao;

	@Transactional
	public void saveCurrencyInfo(CurrencyInfo currencyInfo) {
		currencyInfoDao.saveCurrencyInfo(currencyInfo);
	}

	@Transactional(readOnly = true)
	public List<CurrencyInfo> listCurrencyInfo() {
		return currencyInfoDao.listCurrencyInfo();
	}

	@Transactional(readOnly = true)
	public CurrencyInfo getCurrencyInfo(String country) {
		return currencyInfoDao.getCurrencyInfo(country);
	}

	@Transactional
	public void deleteCurrencyInfo(String country) {
		currencyInfoDao.deleteCurrencyInfo(country);

	}

}
