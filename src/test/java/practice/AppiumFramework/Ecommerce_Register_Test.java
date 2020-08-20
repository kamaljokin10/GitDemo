package practice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Register_Test extends base {

	@Test
	public void registration() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Import Capabilities
		service = startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Filling the form
		//username
		FormPage formPage = new FormPage(driver);
		formPage.nameField.sendKeys("Hello");
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		
		//hiding keyboard
		driver.hideKeyboard();
		
		//Select radio button by female option
		formPage.femaleOption.click();
		//driver.findElementByXPath("//*[@text='Female']").click();
		
		//Click on dropdown option
		formPage.countrySelection.click();
		//driver.findElementById("android:id/text1").click();
		
		//scroll till find Argentina
		Utilities utilities = new Utilities(driver);
		utilities.scrollToText("Argentina");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");

		//Select Argentina from dropdown list
		formPage.selectArgentina.click();
		//driver.findElementByXPath("//*[@text='Argentina']").click();
		
		//Click button to submit the form
		formPage.letsShopButton.click();
		//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		service.stop();
	}
	
	@BeforeTest
	public void killAllNotes() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
