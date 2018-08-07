package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class subCategoryProductMakeup {
	
protected static AppiumDriver driver=null;
	
	public subCategoryProductMakeup(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
    
	//cleanser child
	
	//lips child
	
	//eyes child
	
	//cheek child
	
    //sub child face
	
}
