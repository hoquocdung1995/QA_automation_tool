package com.csc.fixture;

import java.util.List;

import static java.util.Arrays.asList;

public class PageVerification {
	
	  public PageVerification(String locator) {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<List<List<String>>> query() {

	    return
	      asList( // table level
	        asList( // row level
	          asList("verify text", "Welcome") // cell column name, value
	        )
	      );
	  }

}
