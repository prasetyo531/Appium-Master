package testcase.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import database.connection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;
import pageObject.feed;
import pageObject.home;
import pageObject.productCategory;
import resources.assertions;

public class feedFollow {

	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 static WebElement main= null;
	 assertions asser;
	 home hm;
	 productCategory pc;
	 feed fd;
	 
	 DesiredCapabilities dc = new DesiredCapabilities();
	 
	 @BeforeMethod
	 public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
	        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");	//"emulator-5554");
	        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");	//"6.0");
	        dc.setCapability("appPackage", "com.fdbr.android.debug");
	        dc.setCapability("appActivity", "com.fdbr.android.view.activity.SplashScreenActivity");
			dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
	        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testtestFollow() throws Exception {
	    	
	    	//initialitations
	    	asser = new assertions(driver);	
	    	hm = new home(driver);
	    	pc = new productCategory(driver);
	    	fd = new feed(driver);
	    	
	    	//testcase
	    	asser.waitpdateoption();
	    	if (driver.findElement(By.id("com.fdbr.android.debug:id/rel_content")).isDisplayed()) {
	    		hm.clickLaterToUpdate();
	    	}
	    	
	    	asser.waitAppsOpenned();
	    	hm.clickIntroLogin();
	    	
	        asser.waitFieldUsername();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_username")).sendKeys("qapras");
	        asser.waitFieldPassword();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_password")).sendKeys("test123");
	        driver.hideKeyboard();
	        asser.waitButtonLogin();
	        driver.findElement(By.id("com.fdbr.android.debug:id/rel_signin")).click();
	        
	        asser.waitSearchElement();
	        
	        hm.clickFeed();
	        asser.waitFeedOpened();
	        
	        //query check if suggested match with skin of user
//	        
//	        /*
//	         * 
//	         */
	        	        
	        //click follow
	        fd.clickFollowSugested1();
	        
	        //get text following
	        String getTextFollowingButton =  fd.getTextFollowSuggest();
	        System.out.println(getTextFollowingButton);
	        Assert.assertEquals("Following", getTextFollowingButton);
	        
	        //suggested
	        //get text and substring the @
	        String nama = fd.getUsernameSuggested1();
	        String new_nama = nama.substring(1);
	        System.out.println(new_nama);
	        
	        //query check last record nubr_usser_follow via sugessted user
	        String checkUserFollow = connection.getDataUsername("SELECT nubr_userappos.username FROM nubr_userappos INNER JOIN nubr_user_follow ON nubr_userappos.usrapo_id = nubr_user_follow.nuf_follow_id ORDER BY nubr_user_follow.nuf_id DESC LIMIT 1","staging");
	        System.out.println(checkUserFollow);
	        
	        Assert.assertEquals(checkUserFollow, new_nama);
	        
	        //feed
	        fd.clickTextFollowFeed1();
	        String getTextFollowingButton1 =  fd.getTextFollowFeed1();
	        Assert.assertEquals("Following", getTextFollowingButton1);
	        
	        String nama2 = fd.getUsernameFeed1();
	        System.out.println(nama2);
	        
	        //query check last record nubr_usser_follow via feed user
	        String checkUserFollow1 = connection.getDataUsername("SELECT nubr_userappos.username FROM nubr_userappos INNER JOIN nubr_user_follow ON nubr_userappos.usrapo_id = nubr_user_follow.nuf_follow_id ORDER BY nubr_user_follow.nuf_id DESC LIMIT 1","staging");
	        System.out.println(checkUserFollow1);
	        
	        Assert.assertEquals(checkUserFollow1, nama2);
	        
	        
	        
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();

	    }
	
}
