package com.csc.fixture;

import java.util.List;

import com.csc.PageVerifications.Verification;

import static java.util.Arrays.asList;

public class DropdownListVerification {
	private String locator;

	public DropdownListVerification(String locator) {
		this.locator = locator;
	}

	public void table(List<List<String>> table) {
		// optional function
	}

	public List<List<List<String>>> query() {
		return asList(asList(asList("verify dropdown", Verification.verifyDropDownList(locator))));
	}

}
