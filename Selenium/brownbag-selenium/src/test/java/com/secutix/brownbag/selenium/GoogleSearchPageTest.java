package com.secutix.brownbag.selenium;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchPageTest {

	@Test
	public void titleShouldBeSet() {
		// Use this if you have FF installed somewhere else than %PROGRAMFILES%\Mozilla Firefox\firefox.exe
		 final FirefoxBinary binary = new FirefoxBinary(new
		 File("C:\\Program Files (x86)\\Mozilla Firefox ESR\\firefox.exe"));
		 final WebDriver driver = new FirefoxDriver(binary, null);
		//final WebDriver driver = new FirefoxDriver();

		GoogleSearchPage googlePage = new GoogleSearchPage(driver);
		googlePage.searchText("Secutix");
		assertThat(driver.getTitle()).contains("Secutix");

		driver.quit();
	}

}
