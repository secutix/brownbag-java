package com.secutix.brownbag.selenium;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DashBoardTest {

	@Test
	public void dashBoardShouldHaveTabs() {
		final WebDriver driver = getDriver();

		DashBoard dashboard = new DashBoard(driver);
		assertThat(dashboard.getTabs()).isNotEmpty();

		driver.quit();
	}

	@Test
	public void dashBoardShouldShowTestResults() {
		final WebDriver driver = getDriver();

		DashBoard dashboard = new DashBoard(driver);
		dashboard.clickOnTab("Development");

		assertThat(dashboard.showsContinuousTestingResults()).isTrue();

		driver.quit();
	}

	private WebDriver getDriver() {
		// Use this if you have FF installed somewhere else than %PROGRAMFILES%\Mozilla Firefox\firefox.exe
		// final FirefoxBinary binary =
		// new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox ESR\\firefox.exe"));
		// final WebDriver driver = new FirefoxDriver(binary, null);
		final WebDriver driver = new FirefoxDriver();

		return driver;
	}
}
