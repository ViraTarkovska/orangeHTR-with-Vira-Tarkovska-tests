package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qagroup.tools.AbstractPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class DashboardPage extends AbstractPage {

	private WebElement welcome;
	
	private WebElement menu_directory_viewDirectory;
	
	private WebElement menu_admin_viewAdminModule;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("dashboard"));
	}

	@Step("Read Greeting message")
	@Attachment("Message")
	public String getGreetingMessage() {
		return welcome.getText();
	}
	@Step("Go to Search Directory Page")
	public SearchDirectoryPage goToDirectory() {
		menu_directory_viewDirectory.click();
		return new SearchDirectoryPage(driver);
	}
	
	@Step("Go to Admin Page")
	public AdminPage goToAdmin() {
		menu_admin_viewAdminModule.click();
		return new AdminPage(driver);
	}
}
