package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class profile {
	
	protected static AppiumDriver driver=null;
	
	public profile(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	//profile page
	@AndroidFindBy(id = "com.fdbr.android.debug:id/toolbar_facebook_friend_image")
	private WebElement findfriends;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/toolbar_title")
    private WebElement usernameprofile;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/toolbar_settings_image")
    private WebElement setting;
    
    //---------------------------------------------- setting page
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/toolbar_back_button_image")
    private WebElement back;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_editprofile")
    private WebElement editprofile;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_invitefriend")
    private WebElement invfriends;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_cs")
    private WebElement feedbacksetting;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_rate")
    private WebElement rateourapp;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_ppo")
    private WebElement privacypolicy;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_logout")
    private WebElement logout;
    
    //---------------------------------------------- edit profile
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/txt_save")
    private WebElement save;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_dob")
    private WebElement dob;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/edt_name")
    private WebElement fullname;
     
     @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_location")
     private WebElement location;
     
     @AndroidFindBy(id = "com.fdbr.android.debug:id/edt_phone_number")
     private WebElement nohp;
     
     @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_bio")
     private WebElement bio;
     
     @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_beauty_id")
     private WebElement updatebbeautyprof;
     
     @AndroidFindBy(id = "com.fdbr.android.debug:id/rel_beauty_concern")
     private WebElement updatebbeautyconcern;
     
     //---------------------------------------------- your beauty profile
     @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[4]/android.widget.ImageView[2]")
     private WebElement skintypeOily;
     
     @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.ImageView[2]")
     private WebElement skintoneDark;
     
     @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.ImageView[2]")
     private WebElement skintundertoneWarm;
     
     @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.ImageView[2]")
     private WebElement hairtypeCurly;
     
     @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout")
     private WebElement savebutton;
     
    //get
    public String getTextHeaderUsername(){
    	return usernameprofile.getText();
    }
     
    //action 
    public void clickFindFriend(){
    	findfriends.click();
    }

    public void clickSetting(){
    	setting.click();
    }
    
    //setting page
    public void clickBackToProfile(){
    	back.click();
    }
    
    public void clickEditProfile(){
    	editprofile.click();
    }
    
    //edit profile
    public void clickSave(){
    	save.click();	
    }
    
    public void clickUpdateBeautyProf(){
    	updatebbeautyprof.click();
    }
    
    //edit beauty profile
    public void clickOily(){
    	skintypeOily.click();
    }

    public void clickDark(){
    	skintoneDark.click();
    }
    
    public void clickWarm(){
    	skintundertoneWarm.click();
    }
    
    public void clickHairTypeCurly(){
    	hairtypeCurly.click();
    }
    
    public void clickSaveBeautyProfile(){
    	savebutton.click();
    }
}
