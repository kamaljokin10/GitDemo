package practice.AppiumFramework;


import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.FormPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC_3 extends base {

	@Test
	public void totalvalidation() throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		// Import Capabilities
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Filling the form
		// username
		FormPage formPage = new FormPage(driver);
		formPage.nameField.sendKeys("Hello");
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

		// hiding keyboard
		driver.hideKeyboard();

		// Select radio button by female option
		formPage.femaleOption.click();
		//driver.findElementByXPath("//*[@text='Female']").click();

		// Click on dropdown option
		formPage.countrySelection.click();
		//driver.findElementById("android:id/text1").click();

		// scroll till find Argentina
		//formPage.scroll.getLocation();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");

		// Select Argentina from dropdown list
		formPage.selectArgentina.click();
		driver.findElementByXPath("//*[@text='Argentina']").click();

		// Click button to submit the form
		formPage.letsShopButton.click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		// Select 2 products in one view
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

		// Click on list of items purchased image at the top
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(4000);
		
		// Get amount value of product 1
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/ProductPrice").get(0).getText();
		// excluding dollar symbol
		amount1 = amount1.substring(1);
		// Converting value into double data because it has decimal value
		double amount1value = Double.parseDouble(amount1);

		
		// Get amount value of product 2
		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/ProductPrice").get(1).getText();
		// excluding dollar symbol
		amount2 = amount2.substring(1);
		// Converting value into double data because it has decimal value
		double amount2value = Double.parseDouble(amount2);
		
		//Sum of 2 product values
		double sumOfProducts = amount1value+amount2value;
		System.out.println(sumOfProducts+ "sum of products");
		
		//Get total amount value
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		
		total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		System.out.println(totalvalue+ "Total value of products");
		
		//Tap the checkbox
		TouchAction touch = new TouchAction(driver);
		WebElement checkBox = driver.findElementByClassName("android.widget.CheckBox");
		touch.tap(tapOptions().withElement(element(checkBox))).perform();
		
		//Long press TC link
		WebElement termsConditions = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		touch.longPress(longPressOptions().withElement(element(termsConditions)).withDuration(ofSeconds(2))).release().perform();
		
		//Click button
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
	}

}
