package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class brand {
	
	protected static AppiumDriver driver=null;
	
	public brand(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	@AndroidFindBy(id = "com.fdbr.android:id/search_src_text")
	private WebElement searchbrand;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_1")
	private WebElement topbrand1;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_2")
	private WebElement topbrand2;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_3")
	private WebElement topbrand3;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_4")
	private WebElement topbrand4;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_5")
	private WebElement topbrand5;
	
	@AndroidFindBy(id = "com.fdbr.android:id/iv_brand_6")
	private WebElement topbrand6;
	
	public void clickSearchBrand(){
		searchbrand.click();
	}
	
	public void clickBrand1(){
		topbrand1.click();
	}
	
	public void clickBrand2(){
		topbrand2.click();
	}
	
	public void clickBrand3(){
		topbrand3.click();
	}
	
	public void clickBrand4(){
		topbrand4.click();
	}
	
	public void clickBrand5(){
		topbrand5.click();
	}
	
	public void clickBrand6(){
		topbrand6.click();
	}
	
}
