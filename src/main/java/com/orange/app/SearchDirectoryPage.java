package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qagroup.tools.AbstractPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchDirectoryPage extends AbstractPage {

	protected SearchDirectoryPage(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("directory"));
	}

	@FindBy(css = ".odd>td>ul>li>b")
	private WebElement firstEmployeeField;

	@FindBy(css = "#searchDirectory_emp_name_empName")
	private WebElement nameField;

	@FindBy(css = "#searchBtn")
	private WebElement searchButton;

	@Step("Read first employee name")
	@Attachment("Name")
	public String getFirstEmployeeName() {
		return firstEmployeeField.getText();
	}

	@Step("Search by <{0}>")
	public void searchByName(String search) {
		typeIntoNameField(search);
		clickSearchButton();
	}

	@Step("Type into 'Name' Field <{0}>")
	public void typeIntoNameField(String text) {
		nameField.sendKeys(text);
	}

	@Step
	public void clickSearchButton() {
		searchButton.click();
	}

}
