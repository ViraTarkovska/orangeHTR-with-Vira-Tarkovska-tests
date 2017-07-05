package com.orange.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.orange.app.LocalizationTab;
import static org.testng.Assert.*;
import static com.orange.data.UserData.*;

public class ChangeSiteLanguageTest extends AbstractTest {

	private LocalizationTab onLocalizationTab;

	@Test
	public void testChangeSiteLanguage() {

		onLocalizationTab = orangeHrm.openLoginPage().loginAs(ADMIN_USER).goToAdmin().hoverConfigurationClickLocalization();

		assertEquals(onLocalizationTab.getCurrentLanguage(), "US English", "Language is not English");

		onLocalizationTab.switchMode().openLanguageDropdown().selectFrench().switchMode();

		assertEquals(onLocalizationTab.localizationHeadingValue(), "Localisation", "Language is not French");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		orangeHrm.close();
	}

}
