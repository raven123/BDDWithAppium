package com.appium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.utility.AppiumDriverProvider;

import io.appium.java_client.AppiumDriver;

public class LaunchTest {

	private AppiumDriver driver;

	@BeforeMethod
	public void setUp() {
		int port = 4723;
		if(!AppiumDriverProvider.checkIfServerIsRunnning(port)) {
			AppiumDriverProvider.startServer();
			System.out.println("Server Started");
		} else {
			System.out.println("Appium Server already running on Port - " + port);
		}
		driver = AppiumDriverProvider.getDriverInstance();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		AppiumDriverProvider.service.stop();
		
	}

	@Test
	public void appLaunch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable((By.id("com.carwale:id/tv_skip")))).click();

		wait.until(ExpectedConditions.elementToBeClickable((By.id("com.carwale:id/autoCompleteTextView1"))))
				.sendKeys("Thane");
		driver.findElement(By.id("com.carwale:id/confirm_city_btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.carwale:id/autoCompleteTextView1"))))
		.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.carwale:id/atv_car_name"))))
		.sendKeys("tiago");
		
		/*((AndroidDriver)driver).openNotifications();
		
		
		Thread.sleep(5000);
		
		System.out.println(""+driver.findElements((By.id("android:id/title'"))).size());
		*/
		
		
		
		
		

		
		

	}

}
