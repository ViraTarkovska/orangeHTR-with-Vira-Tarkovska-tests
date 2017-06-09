package com.orange.app;

import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends AbstractPage {

	@FindBy(css = "#menu_admin_Configuration")
	private WebElement configuration;

	@FindBy(css = "#menu_admin_localization")
	private WebElement localization;

	public AdminPage(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("admin"));
	}

	@Step("Hover 'Configuration' item in admin menu and click on 'Localization'")
	public LocalizationTab hoverConfigurationClickLocalization() {
		Actions actions = new Actions(driver);
		actions.moveToElement(configuration);

		actions.moveToElement(localization);
		actions.click().build().perform();
		return new LocalizationTab(driver);
	}

}
