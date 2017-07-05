package com.orange.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.orange.app.SearchDirectoryPage;
import static com.orange.data.UserData.*;

public class SearchByNameTest extends AbstractTest {

	private SearchDirectoryPage onSearchDirectoryPage;

	@Test
	public void testSearchByName() {

		onSearchDirectoryPage = orangeHrm.openLoginPage().loginAs(ADMIN_USER).goToDirectory();

		String firstNameBeforeSearch = onSearchDirectoryPage.getFirstEmployeeName();

		onSearchDirectoryPage.searchByName(firstNameBeforeSearch);

		assertEquals(onSearchDirectoryPage.getFirstEmployeeName(), firstNameBeforeSearch);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		orangeHrm.close();
	}

}
