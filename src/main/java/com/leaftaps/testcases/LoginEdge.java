package com.leaftaps.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LoginEdge {

	@Test
	public void loginTests() throws IOException, InterruptedException {

		EdgeOptions options = new EdgeOptions();
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("MicrosoftEdge");
		// dc.setVersion("120.0");
		dc.setPlatform(Platform.LINUX);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);

		// ChromeDriver driver = new ChromeDriver();

		// Load the application url
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximize the browser
		driver.manage().window().maximize();
		// Step 3: Print the title --> getTitle
				driver.findElement(By.id("username")).sendKeys("democsr");
				System.out.println("The title is "+driver.getTitle());

				Thread.sleep(5000);

				// Step 3: Print the title --> getTitle
				driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Get the text of the element

		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		// click on Crmsfa Link

		driver.findElement(By.linkText("CRM/SFA")).click();

		// To get the Title of the page

		String title = driver.getTitle();
		System.out.println(title);

		if (title.contains("My Home")) {
			System.out.println("verified Sucessfully");
		} else {

			System.out.println("Verified not Sucessfully");
		}

		// Click on the Leads

		driver.findElement(By.partialLinkText("Lea")).click();

		// CLick on the Create Leads Button

		driver.findElement(By.partialLinkText("Creat")).click();

		// Enter the Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		// Enter the First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vinoth");

		// Enter The Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");

		// Click on the Create Leads Button
		driver.findElement(By.name("submitButton")).click();

		// To Verify the Lead First Name

		WebElement findElement = driver.findElement(By.id("viewLead_firstName_sp"));
		System.out.println(findElement.getText());
		String firstName = findElement.getText();
		if (firstName.equals("Vinoth")) {

			System.out.println("Verfied Sucessfully");

		} else {

			System.out.println("Verified not Sucessfully");

		}

		// To Get the Title of the Page

		String title2 = driver.getTitle();
		System.out.println(title2);
	}

}
