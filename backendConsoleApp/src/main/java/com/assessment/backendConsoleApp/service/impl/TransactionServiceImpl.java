package com.assessment.backendConsoleApp.service.impl;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.backendConsoleApp.api.GenerateHashTransactionId;
import com.assessment.backendConsoleApp.model.Transaction;
import com.assessment.backendConsoleApp.persistence.impl.PersistenceImpl;
import com.assessment.backendConsoleApp.service.ITransactionService;
import com.google.gson.Gson;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private PersistenceImpl persistence;

	String jsonFormat;
	Transaction transaction;

	@Override
	public void addTransaction(String addUserTransaction) throws ClassNotFoundException {

		System.out.println("Adding Transaction => ");

		if (StringUtils.isNumeric(addUserTransaction.substring(0, addUserTransaction.indexOf(" ")))) {
			int begin = addUserTransaction.indexOf("{", addUserTransaction.indexOf("{"));
			int end = addUserTransaction.indexOf("}", addUserTransaction.indexOf("}")) + 1;
			jsonFormat = addUserTransaction.substring(begin, end);
			transaction = new Gson().fromJson(jsonFormat, Transaction.class);
			transaction.setTransaction_id(GenerateHashTransactionId.generateHash(addUserTransaction));
			Gson gson = new Gson();
			jsonFormat = gson.toJson(transaction);
			System.out.println(transaction.toString());
			try {
				persistence.save(jsonFormat);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		} else {
			System.out.println("Invalid information");
		}

	}

	@Override
	public void showTransaction(String showUserTransaction) throws ClassNotFoundException {
		System.out.println("Show Transaction => " + showUserTransaction);
		try {
			String idUser = showUserTransaction.substring(0, showUserTransaction.indexOf(" "));
			String idTransaction = showUserTransaction.substring(showUserTransaction.indexOf(" ") +1, showUserTransaction.indexOf("s") -1);
			System.out.println(idTransaction);
			if (StringUtils.isNumeric(idUser)) {
				persistence.getTransactionsByUserIdTransactionId(idUser, idTransaction);
			} else {
				System.out.println("Invalid information");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void listTransactions(String printAllUserTransactions) throws ClassNotFoundException {
		System.out.println("List Transaction => " + printAllUserTransactions);
		try {
			String idUser = printAllUserTransactions.substring(0, printAllUserTransactions.indexOf(" "));
			System.out.println(idUser);
			if (StringUtils.isNumeric(idUser)) {
				persistence.getTransactionsByUserId(idUser);
			} else {
				System.out.println("Invalid information");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sumTransactions(String printAllSumUserTransactions) throws ClassNotFoundException {
		System.out.println("Sum Transaction => " + printAllSumUserTransactions);
		try {
			String idUser = printAllSumUserTransactions.substring(0, printAllSumUserTransactions.indexOf(" "));
			System.out.println(idUser);
			if (StringUtils.isNumeric(idUser)) {
				persistence.getTransactionsSumByUserId(idUser);
			} else {
				System.out.println("Invalid information");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
