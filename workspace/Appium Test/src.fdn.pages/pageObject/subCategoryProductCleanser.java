package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class subCategoryProductCleanser {
	
	protected static AppiumDriver driver=null;
	
	public subCategoryProductCleanser(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//cleanser child
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    private WebElement scrub;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]")
    private WebElement toner;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]")
    private WebElement facial;
    
    //moisturizer child
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement allmois;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement daycream;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement sunprotection;
    
    //treatment child
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement acne;

    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement serum;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement peeling;
    
    //mask child
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement allmask;

    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement washoff;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement sleepmask;
    
	//sub child cleanser
	public void clickTabScrubClean(){
		scrub.click();
	}
	
	public void clickTabTonerClean(){
		toner.click();;
	}
	
	public void clickTabFacialClean(){
		facial.click();
	}
	
	//sub child moisturizer
	public void clickTabAllMois(){
		allmois.click();
	}
	
	public void clickTabDayMois(){
		daycream.click();
	}
	
	public void clickTabSunMois(){
		sunprotection.click();
	}
	
	//sub child treatment
	public void clickTabAcneTreat(){
		acne.click();
	}
	
	public void clickTabSerumTreat(){
		serum.click();
	}
	
	public void clickTabPeelTreat(){
		peeling.click();
	}
	
	//sub child mask
	public void clickTabAllMask(){
		allmask.click();
	}
	
}
