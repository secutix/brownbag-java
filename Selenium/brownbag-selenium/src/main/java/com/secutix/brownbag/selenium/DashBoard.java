package com.secutix.brownbag.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoard {

	private final String URL = "http://www.stx.local";

	private final WebDriver driver;

	public DashBoard(final WebDriver driver) {
		this.driver = driver;
		driver.get(URL);
	}

	public void clickOnTab(final String tabName) {
		for (WebElement tab : getTabs()) {
			if (tab.getText().equals(tabName)) {
				tab.click();
				break;
			}
		}
	}

	public List<WebElement> getTabs() {
		return driver.findElements(By.cssSelector("#myTab li"));
	}

	public boolean showsContinuousTestingResults() {
		final List<WebElement> titleElements = driver.findElements(By.className("box_title"));
		for (WebElement titleElement : titleElements) {
			if (titleElement.getText().contains("Continuous testing")) {
				return true;
			}
		}
		return false;
	}

}
