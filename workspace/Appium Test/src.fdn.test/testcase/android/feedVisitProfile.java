package testcase.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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
import pageObject.feed;
import pageObject.home;
import pageObject.profile;
import resources.assertions;

public class feedVisitProfile {
	
	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 assertions asser;
	 home hm;
	 feed fd;
	 profile pf;
	 
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
	    	pf= new profile(driver);
	    	
	    	//testcase
	    	asser.waitAppsOpenned();
	    	hm.clickIntroLogin();
	    	
	        asser.waitFieldUsername();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_username")).sendKeys("putwid");
	        asser.waitFieldPassword();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_password")).sendKeys("tester123");
	        driver.hideKeyboard();
	        asser.waitButtonLogin();
	        driver.findElement(By.id("com.fdbr.android.debug:id/rel_signin")).click();
	        
	        asser.waitSearchElement();
	        
	        hm.clickFeed();
	        asser.waitFeedOpened();
	        
	        //get username feed
	        //String 
	        String usernamefeed = fd.getUsernameFeed1();
	        System.out.println(usernamefeed);
	        
	        fd.clickViewProfileFeed();
	        asser.waitBeatyProfileOpened();
	        
	        String usernameprofileid= pf.getTextHeaderUsername();
	        System.out.println(usernameprofileid);
	        
	        Assert.assertEquals(usernameprofileid, usernamefeed);
	        
	        //validasi by query
	        String matchsuggestedusername = connection.getDataUsername("SELECT DISTINCT nubr_userappos.username FROM nubr_userappos INNER JOIN nubr_post ON usrapo_id = nubr_post.user_id LEFT JOIN user_haicons ON usrapo_id = usrhaicon_usrapo_id LEFT JOIN user_skicons ON usrapo_id = usrskicon_usrapo_id LEFT JOIN user_bodcons ON usrapo_id = usrbodcon_usrapo_id LEFT JOIN nubr_userpics ON usrapo_id = usrpic_usrapo_id WHERE usrapo_id <> 297163 NOT IN (select nuf_follow_id from nubr_user_follow where nuf_user_id = 297163) AND (skintype_id = 3 OR skintone_id = 1 OR skinun_id = 1 OR user_is_hijab = 1 OR user_hair_color = 1) AND user_count_post > 3 AND (MONTH(nubr_post.created_at) = MONTH(NOW()) AND YEAR(nubr_post.created_at) = YEAR(NOW())) AND nubr_userappos.username LIKE'%"+usernamefeed+"%' LIMIT 40", "staging");
	        Assert.assertEquals(matchsuggestedusername, usernameprofileid);
	        
	        hm.clickBack();
	        
	        //get username suggested
	        String nama = fd.getUsernameSuggested1();
	        String new_nama = nama.substring(1);
	        System.out.println(new_nama);
	        
	        fd.clickViewProfilSuggested();
	        asser.waitBeatyProfileOpened();
	        
	        String headernamaprofile = pf.getTextHeaderUsername();
	        System.out.println(headernamaprofile);
	        
	        Assert.assertEquals(headernamaprofile, new_nama);
	        
	        String matchfeedusername = connection.getDataUsername("SELECT DISTINCT nubr_userappos.username FROM nubr_userappos INNER JOIN nubr_post ON usrapo_id = nubr_post.user_id LEFT JOIN user_haicons ON usrapo_id = usrhaicon_usrapo_id LEFT JOIN user_skicons ON usrapo_id = usrskicon_usrapo_id LEFT JOIN user_bodcons ON usrapo_id = usrbodcon_usrapo_id LEFT JOIN nubr_userpics ON usrapo_id = usrpic_usrapo_id WHERE usrapo_id <> 297163 NOT IN (select nuf_follow_id from nubr_user_follow where nuf_user_id = 297163) AND (skintype_id = 3 OR skintone_id = 1 OR skinun_id = 1 OR user_is_hijab = 1 OR user_hair_color = 1) AND user_count_post > 3 AND (MONTH(nubr_post.created_at) = MONTH(NOW()) AND YEAR(nubr_post.created_at) = YEAR(NOW())) AND nubr_userappos.username LIKE'%"+usernamefeed+"%' LIMIT 40", "staging");
	        Assert.assertEquals(matchfeedusername, new_nama);  
	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();

	    }

}
