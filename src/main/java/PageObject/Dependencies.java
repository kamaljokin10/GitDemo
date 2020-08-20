package PageObject;

import java.util.List;

import javax.sound.sampled.LineListener;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dependencies {
	
	public Dependencies(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement Checkbox;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement Popup;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement Text;
	
	@AndroidFindBy(className = "android.widget.Button")
	public List<WebElement> OkButton;

}
