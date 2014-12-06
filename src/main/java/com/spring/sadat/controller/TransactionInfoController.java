package com.spring.sadat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sadat.model.TransactionInfo;
import com.spring.sadat.service.TransactionInfoService;

@Controller
@RequestMapping("/transaction")
public class TransactionInfoController {

	@Autowired
	private TransactionInfoService transactionInfoService;

	@RequestMapping(value = { "/", "/listTransactionInfo" })
	public String listTransactionInfo(Map<String, Object> map) {

		map.put("transactionInfo", new TransactionInfo());
		map.put("transactionInfoList", transactionInfoService.listTransactionInfo());

		return "/transaction/listTransactionInfo";
	}

	@RequestMapping("/get/{TransactionId}")
	public String getTransactionInfo(@PathVariable Long TransactionId, Map<String, Object> map) {

		TransactionInfo transactionInfo = transactionInfoService.getTransactionInfo(TransactionId);

		map.put("transactionInfo", transactionInfo);

		return "/transaction/TransactionInfoForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTransactionInfo(@ModelAttribute("transactionInfo") TransactionInfo transactionInfo,
			BindingResult result) {

		transactionInfoService.saveTransactionInfo(transactionInfo);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listTransactionInfo";
	}

	@RequestMapping("/delete/{TransactionId}")
	public String deleteTransactionInfo(@PathVariable("TransactionId") Long id) {

		transactionInfoService.deleteTransactionInfo(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listTransactionInfo";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/transaction/listTransactionInfo";
	}
}
