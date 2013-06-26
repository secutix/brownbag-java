package com.secutix.brownbag.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Lists;

public class DashBoard {

	private final String URL = "http://www.stx.local";

	private final WebDriver driver;

	public DashBoard(final WebDriver driver) {
		this.driver = driver;
		driver.get(URL);
	}

	public void clickOnTab(final String tabName) {
	}

	public List<WebElement> getTabs() {
		return Lists.newArrayList();
	}

	public boolean showsContinuousTestingResults() {
		return false;
	}

}
