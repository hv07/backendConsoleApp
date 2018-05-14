package com.assessment.backendConsoleApp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assessment.backendConsoleApp.controller.ITransactionController;
import com.assessment.backendConsoleApp.service.impl.TransactionServiceImpl;

@Controller
public class TransactionControllerImpl implements ITransactionController {

	@Autowired
	private TransactionServiceImpl transactionService;

	@Override
	public void driveTransactionAction(String request) {

		if (request.contains("add")) {
			if (request.contains("{") || request.contains("}")) {
				try {
					transactionService.addTransaction(request);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("There is not Json request");
			}
		} else if (request.contains("show")) {
			try {
				transactionService.showTransaction(request);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		} else if (request.contains("list")) {
			try {
				transactionService.listTransactions(request);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else if (request.contains("sum")) {
			try {
				transactionService.sumTransactions(request);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
