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

	@Step("First time read name")
	@Attachment("Name")
	public String firstTimeReadName() {
		return firstEmployeeField.getText();
	}

	@Step("Send name and click 'Search' button")
	public void searchByName() {
		nameField.sendKeys(firstTimeReadName());
		searchButton.click();
	}

	@Step("Second time read name")
	@Attachment("Name")
	public String secondTimeReadName() {
		return firstEmployeeField.getText();
	}

}
