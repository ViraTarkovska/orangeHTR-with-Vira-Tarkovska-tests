package com.orange.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.orange.app.SearchDirectoryPage;

public class SearchByNameTest extends AbstractTest {

	
	private SearchDirectoryPage onSearchDirectoryPage;

	@Test
	public void testSearchByName() {
		
		onSearchDirectoryPage = orangeHrm.openLoginPage().login().goToDirectory();

		onSearchDirectoryPage.searchByName();

		assertEquals(onSearchDirectoryPage.secondTimeReadName(), onSearchDirectoryPage.firstTimeReadName());
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		orangeHrm.close();
	}

}
