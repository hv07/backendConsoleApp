package com.assessment.backendConsoleApp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assessment.backendConsoleApp.controller.impl.TransactionControllerImpl;

@SpringBootApplication
public class BackendConsoleAppApplication implements CommandLineRunner {

	@Autowired
	private TransactionControllerImpl transactionController;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(BackendConsoleAppApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***************** Welcome to Console Transaction *****************");
		Scanner informationScan = new Scanner(System.in);

		System.out.println("\n Please enter information");
		
		String request = informationScan.nextLine();
		transactionController.driveTransactionAction(request);
	}
}