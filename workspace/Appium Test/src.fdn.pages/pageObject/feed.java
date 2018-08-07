package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class feed {
	
protected static AppiumDriver driver=null;
	
	public feed(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	//sugeseted on feed
	@AndroidFindBy(id = "com.fdbr.android.debug:id/tv_sug_username_1")
    private WebElement usernamesugested1;
	
	@AndroidFindBy(id = "com.fdbr.android.debug:id/tv_sug_follow_1")
    private WebElement followsugested1;
	
	@AndroidFindBy(id = "com.fdbr.android.debug:id/iv_sug_1")
	private WebElement profilesuggested;
	
	//feed
    @AndroidFindBy(id = "com.fdbr.android.debug:id/iv_user")
    private WebElement profilefeed;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/tv_name")
    private WebElement usernamefeed;
    
    @AndroidFindBy(id = "com.fdbr.android:id/ll_tag_post")
    private WebElement tagpostfeed;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/tv_follow")
    private WebElement followfeed;
    
    @AndroidFindBy(id = "com.fdbr.android:id/tv_read_full_review")
    private WebElement readfullreviewfeed;
    
    @AndroidFindBy(id = "com.fdbr.android:id/rl_like")
    private WebElement likefeed;
  
    @AndroidFindBy(id = "com.fdbr.android:id/rl_comment")
    private WebElement commentfeed;
	
    @AndroidFindBy(id = "com.fdbr.android:id/rl_more")
    private WebElement morefeed;
    
    @AndroidFindBy(id = "com.fdbr.android:id/rl_btn")
    private WebElement viewproductdetailfeed;
    
    @AndroidFindBy(id = "com.fdbr.android:id/img_close")
    private WebElement closeImageClosefeed;
    
    //alement after option
    
    //suggested
    public String getUsernameSuggested1(){
    	return usernamesugested1.getText();
    }
    
    public void clickFollowSugested1(){
    	followsugested1.click();
    }
    
    public String getTextFollowSuggest(){
    	return followsugested1.getText();
    }
    
    //feed
    public String getUsernameFeed1(){
    	return usernamefeed.getText();
    }
    
    public String getTextFollowFeed1(){
    	return followfeed.getText();
    }
    
    public void clickTextFollowFeed1(){
    	followfeed.click();
    }
    
    public void clickTagPost(){
    	tagpostfeed.click();
	}
    
    public void clickFollow(){
    	followfeed.click();
	}
    
    public void clickViewProfileFeed(){
    	profilefeed.click();
	}
    
    public void clickViewProfilSuggested(){
    	profilesuggested.click();
	}
    
    public void clickViewFullReview(){
    	readfullreviewfeed.click();
	}
    
    public void clickLikeReview(){
    	likefeed.click();
	}
    
    public void clickCommentReview(){
    	commentfeed.click();
	}
    
    public void clickMoretoShare(){
    	morefeed.click();
	}
 
    public void clickViewProductDetail(){
    	viewproductdetailfeed.click();
	}
    
    public void clickCloseImage(){
    	closeImageClosefeed.click();
	}
}
