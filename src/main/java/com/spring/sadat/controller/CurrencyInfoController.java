package com.spring.sadat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sadat.model.CurrencyInfo;
import com.spring.sadat.service.CheckPriceService;

@Controller
@RequestMapping("/currency")
public class CurrencyInfoController {

	@Autowired
	private CheckPriceService checkPriceService;

	@RequestMapping(value = { "/", "/listCurrencyInfo" })
	public String listCurrencyInfo(Map<String, Object> map) {

		map.put("currencyInfo", new CurrencyInfo());
		map.put("currencyInfoList", checkPriceService.listCurrencyInfo());

		return "/currency/listCurrencyInfo";
	}

	@RequestMapping("/get/{country}")
	public String getTransactionInfo(@PathVariable Long country, Map<String, Object> map) {

		CurrencyInfo currencyInfo = checkPriceService.getCurrencyInfo(country);

		map.put("currencyInfo", currencyInfo);

		return "/currency/CurrencyInfoForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurrencyInfo(@ModelAttribute("currencyInfo") CurrencyInfo currencyInfo,
			BindingResult result) {

		checkPriceService.saveCurrencyInfo(currencyInfo);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listCurrencyInfo";
	}

	@RequestMapping("/delete/{country}")
	public String deleteCurrencyInfo(@PathVariable("country") String country) {

		checkPriceService.deleteCurrencyInfo(country);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listCurrencyInfo";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/currency/listCurrencyInfo";
	}
}
