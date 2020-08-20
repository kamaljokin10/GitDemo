package practice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Dependencies;
import PageObject.HomePage;
import PageObject.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTest extends base {

	@Test(dataProvider="Input Data", dataProviderClass=TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		service = startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		
		HomePage homepage = new HomePage(driver);
		homepage.Preference.click();		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		Preferences preferences = new Preferences(driver);
		preferences.preferenceDependencies.click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		Dependencies dependencies = new Dependencies(driver);
		dependencies.Checkbox.click();
		//driver.findElementById("android:id/checkbox").click();
		
		dependencies.Popup.click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		dependencies.Text.sendKeys("Hello");
		//driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		
		dependencies.OkButton.get(1).click();
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		service.stop();
	}
	
	@BeforeTest
	public void killAllNotes() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
