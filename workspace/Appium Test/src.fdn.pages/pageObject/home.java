package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class home{
	
	protected static AppiumDriver driver=null;
	
	public home(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	 	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]")
	    private WebElement productnameproductmatches1;
	 	
	 	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")
		private WebElement productnameproductmatches2;
	 	
	 	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView[2]")
		private WebElement productnameproductmatches3;
	
		@AndroidFindBy(id = "com.fdbr.android.debug:id/btn_later")
		private WebElement updateoption;
	
		@AndroidFindBy(id = "com.fdbr.android.debug:id/btn_later")
		private WebElement closewaitpersonalbeauty;
		
		@AndroidFindBy(id = "com.fdbr.android.debug:id/img_close")
		private WebElement popup;
	
       	@AndroidFindBy(id = "com.fdbr.android.debug:id/rel_login")
       	private WebElement chooseLogin;
		
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/edt_username")
	    private WebElement usernameLoginForm;
		
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/edt_password")
	    private WebElement passwordLoginForm;
		
	    @AndroidFindBy(accessibility = "img_tab1")
	    private WebElement home;
	    
	    @AndroidFindBy(accessibility = "img_tab2")
	    private WebElement feed;
	    
	    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='view3's]/android.widget.LinearLayout/android.widget.RelativeLayout")
	    private WebElement addicon;
	    
	    @AndroidFindBy(accessibility = "img_tab4")
	    private WebElement discover;
	    
	    @AndroidFindBy(accessibility = "img_tab5")
	    private WebElement profile;
	    
	    @AndroidFindBy(id = "com.fdbr.android.deb ug:id/rel_signin")
	    private WebElement buttonLogin;
	    
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_category")
	    private WebElement category;
	    
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_editorchoice")
	    private WebElement editorchoice;
	    
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_brand")
	    private WebElement brand;
	    
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_bestofbeauty")
	    private WebElement bestofbeauty;
	    
	    @AndroidFindBy(id = "com.fdbr.android.debug:id/img_feedback")
	    private WebElement feedback;
	    
	    @AndroidFindBy(id = "com.fdbr.android:id/toolbar_back_button")
	    private WebElement back;
	    
	    @AndroidFindBy(id = "com.fdbr.android:id/txt_seemore_article")
	    private WebElement morearticles;
	    
	    @AndroidFindBy(id = "com.fdbr.android:id/txt_seemore_video")
	    private WebElement morevideos;
	    
	    //get product name priduct matches
	    public String getProductNameProductMatches1(){
	    	return productnameproductmatches1.getText();
	    }
	    
	    public String getProductNameProductMatches2(){
	    	return productnameproductmatches2.getText();
	    }
	    
	    public String getProductNameProductMatches3(){
	    	return productnameproductmatches3.getText();
	    }
		
	    public void clickLaterToUpdate(){
	    	updateoption.click();
	    }
	    
	    public void closeWaitPersonalBeauty(){
	    	closewaitpersonalbeauty.click();
	    }
	    
	    public void clickPopUpClose(){
	    	popup.click();
	    }
	    
		public void clickIntroLogin(){
	        chooseLogin.click();
	    }

	    public void fillUsernameToLogin(String nama){
	        usernameLoginForm.sendKeys(nama);
	    }

	    public void fillPasswordToLogin(String pass){
	        passwordLoginForm.sendKeys(pass);
	    }

	    public void clickLogin(){
	        buttonLogin.click();
	    }
	    
	    //dashboard home
	    public void clickHome(){
	    	home.click();
	    }
	    
	    public void clickCategory(){
	    	category.click();
	    }
	    
	    public void clickProfile(){
	    	profile.click();
	    }

	    public void clickFeedbackHome(){
	    	feedback.click();
	    }
	    
	    //dashboard feed
	    public void clickFeed(){
	    	feed.click();
	    }
	    
	    //back
		public void clickBack(){
			back.click();
		}
	    
}
