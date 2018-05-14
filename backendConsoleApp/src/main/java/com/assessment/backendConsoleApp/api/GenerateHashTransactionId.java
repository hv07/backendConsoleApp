package com.assessment.backendConsoleApp.api;

import java.math.BigInteger;
import java.security.MessageDigest;

public class GenerateHashTransactionId {

	public static String generateHash(String jsonRequest) {

		String sha1 = "";

		// With the java libraries
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(jsonRequest.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("The sha1 of \"" + jsonRequest + "\" is:");
		System.out.println(sha1);
		return sha1;
	}
}