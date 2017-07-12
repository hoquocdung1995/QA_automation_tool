package com.csc.fixture;

import java.util.List;

import com.csc.PageVerifications.Verification;

public class VerifyViewGrid {
	private String locator;

	public VerifyViewGrid(String locator) {
		this.locator = locator;
	}

	public List<List<List<String>>> query() {

		return Verification.verifyWebGrid(locator);
	}
}
