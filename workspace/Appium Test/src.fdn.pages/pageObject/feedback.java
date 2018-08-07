package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class feedback {
	
protected static AppiumDriver driver=null;
	
	public feedback(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	@AndroidFindBy(id = "com.fdbr.android.debug:id/item_popular")
	private WebElement fieldFeedback;
	
	@AndroidFindBy(id = "com.fdbr.android.debug:id/rl_send")
	private WebElement send;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement ok;

	public void clickfieldFeedback(String feedback){
		fieldFeedback.sendKeys(feedback);;
	}
	
	public void clickSendFeedback(){
		send.click();
	}
	
	public void clickOk(){
		ok.click();
	}
}
