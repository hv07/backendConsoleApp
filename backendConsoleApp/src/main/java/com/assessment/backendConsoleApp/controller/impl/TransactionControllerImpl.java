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
		try {
			if (request.contains("add")) {
				if (request.contains("{") || request.contains("}")) {

					transactionService.addTransaction(request);

				} else {
					System.out.println("There is not Json request");
				}
			} else if (request.contains("show")) {

				transactionService.showTransaction(request);

			} else if (request.contains("list")) {

				transactionService.listTransactions(request);

			} else if (request.contains("sum")) {

				transactionService.sumTransactions(request);

			}
		} catch (Exception e) {
			System.err.print(e)
		}
	}

}
