package com.assessment.backendConsoleApp.persistence;

import java.io.IOException;

public interface IPersistence {
	
	public void save(String transaction) throws IOException, ClassNotFoundException;
	
	public void getTransactionsByUserId(String userId)throws IOException, ClassNotFoundException;
	
	public void getTransactionsByUserIdTransactionId(String userId, String transactionId)throws IOException, ClassNotFoundException;
	
	public void getTransactionsSumByUserId(String userId)throws IOException, ClassNotFoundException;
}
