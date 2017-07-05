package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class LocalizationTab extends AbstractPage {

	private WebElement localizationHeading;
	private WebElement btnSave;
	private WebElement localization_dafault_language;
	

	@FindBy(css = "#localization_dafault_language >option[value*='fr']")
	private WebElement frenchOption;

	public LocalizationTab(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("localization"));
	}

	
	@Step("Open language dropdown")
	public LocalizationTab openLanguageDropdown() {
		localization_dafault_language.click();
		return new LocalizationTab(driver);
	}

	@Step("Go to edit mode")
	public LocalizationTab switchMode() {
		clickSaveEditButton();
		return new LocalizationTab(driver);
	}
	
	public LocalizationTab switchToEditMode() {
		String value = btnSave.getAttribute("value");
		if(value.equals("Edit"))
			clickSaveEditButton();
		return this;
	}
	
	public void clickSaveEditButton() {
		btnSave.click();
	}

	@Step("Select French")
	public LocalizationTab selectFrench() {
		frenchOption.click();
		return new LocalizationTab(driver);
	}

	@Step("Read language field falue")
	 @Attachment("Language field falue")
	public String getCurrentLanguage() {
		Select select = new Select(localization_dafault_language);
		WebElement selectedOption = select.getFirstSelectedOption();		
		return selectedOption.getText();
	}
	
	 @Step("Read localization heading value")
		 @Attachment("Localization heading value")
		 public String localizationHeadingValue() {
		 return localizationHeading.getText();
		 }

}
