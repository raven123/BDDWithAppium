package com.appium.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumDriverProvider {

	 static AppiumDriver driver;

	 public static AppiumDriverLocalService service;
	 static AppiumServiceBuilder builder;
	 static DesiredCapabilities cap;

	public static AppiumDriver getDriverInstance() {
		if (driver == null) {
			try {
				URL netURL = new URL("http://127.0.0.1:4723/wd/hub");

				File classpathRoot = new File(System.getProperty("user.dir") + "/src/test");
				File appDir = new File(classpathRoot, "resources");
				File app = new File(appDir, "test.apk");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability("deviceName", "04c4da2d9804");
				capabilities.setCapability("platformVersion", "7.0");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "com.carwale");
				capabilities.setCapability("appActivity", "com.carwale.carwale.activities.home.ActivitySplash");
				capabilities.setCapability("noReset", "false");
				driver = new AndroidDriver(netURL, capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driver;
	}

	public static void startServer() {
		// Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	public static void stopServer() {
		service.stop();
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

}
