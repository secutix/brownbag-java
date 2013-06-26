package com.secutix.brownbag.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private final String URL = "http://www.google.com";

	private final WebDriver driver;

	public GoogleSearchPage(final WebDriver driver) {
		this.driver = driver;
		driver.get(URL);
	}

	public void searchText(final String text) {
		final WebElement input = driver.findElement(By.name("q"));
		input.sendKeys(text);
		input.submit();
	}
}
