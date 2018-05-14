package com.assessment.backendConsoleApp.service;

public interface ITransactionService {
	
	public void addTransaction(String addUserTransaction) throws ClassNotFoundException;
	
	public void showTransaction(String showUserTransaction) throws ClassNotFoundException;
	
	public void listTransactions(String printAllUserTransactions) throws ClassNotFoundException;
	
	public void sumTransactions(String printAllSumUserTransactions)throws ClassNotFoundException;
	
}
