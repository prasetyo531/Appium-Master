 package testcase.android;
import org.testng.annotations.Test;

import com.mysql.jdbc.Statement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pageObject.home;
import pageObject.profile;
import resources.assertions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import database.connection;

	//test pake myjne002@gmail.com
public class productMatchesAfterChangesSkinType {
	
	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 assertions asser;
	 home hm;
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
//	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testtestFollow() throws InterruptedException {
	    	
	    	asser = new assertions(driver);
	    	hm = new home(driver);
	    	pf = new profile(driver);
	    	
	    	//testcase
	    	asser.waitAppsOpenned();
	    	hm.clickIntroLogin();
	    	
	        asser.waitFieldUsername();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_username")).sendKeys("Myjne002@gmail.com");
	        asser.waitFieldPassword();
	        driver.findElement(By.id("com.fdbr.android.debug:id/edt_password")).sendKeys("test123");
	        driver.hideKeyboard();
	        asser.waitButtonLogin();
	        driver.findElement(By.id("com.fdbr.android.debug:id/rel_signin")).click();
	       
	        asser.waitSearchElement();
	        
	        //edit profile
	        hm.clickProfile();

	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/ll_beauty_id")));
	        
	        pf.clickSetting();

	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_editprofile")));
	        
	        pf.clickEditProfile();
	        
	        //scroll beauty prof
	        for (int i=0;i<3;i++)
		    {
	        	  new TouchAction(driver).press(662, 1328).waitAction(Duration.ofMillis(800)).moveTo(662, 689).release().perform();
	        	  
		    }
	        
	        pf.clickUpdateBeautyProf();
	        
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/toolbar_title")));
	        
	        
	        pf.clickOily();
	        pf.clickDark();
	        pf.clickWarm();
	        
	        //scroll hair type
	        for (int i=0;i<3;i++)
		    {
	        	  new TouchAction(driver).press(662, 1328).waitAction(Duration.ofMillis(800)).moveTo(662, 689).release().perform();
	        	  
		    }
	        
	        pf.clickHairTypeCurly();
	        pf.clickSaveBeautyProfile();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/txt_save")));	
	        pf.clickSave();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_editprofile")));
	        
	        //tambahin assert detail profile should not same
	        pf.clickBackToProfile();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/ll_beauty_id")));
	        String getSkinTypeProf = driver.findElement(By.id("com.fdbr.android.debug:id/tv_skin_type")).getText();
	        String getSkinToneProf = driver.findElement(By.id("com.fdbr.android.debug:id/tv_skin_tone")).getText();
	        String getSkinUnderToneProf= driver.findElement(By.id("com.fdbr.android.debug:id/tv_skin_undertone")).getText();
	        
	        Assert.assertEquals(getSkinTypeProf, "Oily");
	        Assert.assertEquals(getSkinToneProf, "Dark");
	        Assert.assertEquals(getSkinUnderToneProf, "Warm");
	        
	        
	        hm.clickHome();
	        asser.waitSearchElement();

	        //check 1
	        String MatchProd0 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
	        System.out.println(MatchProd0);
	        
	        String itemMatchProd0 = connection.getDataAsArrayFirst("SELECT nubr_brands.brands_item FROM nubr_reviews  INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_reviewpic ON nubr_reviews.review_id=nubr_reviewpic.rvwpic_review_id  INNER JOIN nubr_categories ON nubr_reviews.review_cat_id=nubr_categories.cat_id  INNER JOIN nubr_brands ON nubr_reviews.review_brand_id=nubr_brands.brands_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 4 OR prodskiton_skiton_id = 3 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 2) AND nubr_brands.brands_item LIKE'%"+MatchProd0+"' ORDER BY review_num DESC LIMIT 3;", "staging");
	        System.out.println("database"+" "+itemMatchProd0);

	        Assert.assertEquals(MatchProd0, itemMatchProd0);
	        
	        //check 2
	        String MatchProd1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
	        System.out.println(MatchProd1);
	        
	        String itemMatchProd1 = connection.getDataAsArrayTwo("SELECT nubr_brands.brands_item FROM nubr_reviews  INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_reviewpic ON nubr_reviews.review_id=nubr_reviewpic.rvwpic_review_id  INNER JOIN nubr_categories ON nubr_reviews.review_cat_id=nubr_categories.cat_id  INNER JOIN nubr_brands ON nubr_reviews.review_brand_id=nubr_brands.brands_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 4 OR prodskiton_skiton_id = 3 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 2) AND nubr_brands.brands_item LIKE'%"+MatchProd1+"' ORDER BY review_num DESC LIMIT 3;", "staging");
	        System.out.println("database"+" "+itemMatchProd1);

	        Assert.assertEquals(MatchProd1, itemMatchProd1);
	        
	        
	        //check3
	        String MatchProd2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
	        System.out.println(MatchProd2);
	        
	        String itemMatchProd2 = connection.getDataAsArrayThree("SELECT nubr_brands.brands_item FROM nubr_reviews  INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_reviewpic ON nubr_reviews.review_id=nubr_reviewpic.rvwpic_review_id  INNER JOIN nubr_categories ON nubr_reviews.review_cat_id=nubr_categories.cat_id  INNER JOIN nubr_brands ON nubr_reviews.review_brand_id=nubr_brands.brands_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 4 OR prodskiton_skiton_id = 3 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 2) AND nubr_brands.brands_item LIKE'%"+MatchProd2+"' ORDER BY review_num DESC LIMIT 3;", "staging");
	        System.out.println("database"+" "+itemMatchProd2);

	        Assert.assertEquals(MatchProd2, itemMatchProd2);
	        
	        System.out.println("test product matches after change beauty profile pass");
	        
	        
	    }
 
	    @AfterMethod
	    public void tearDown() {
	        driver.quit();

	    }
}
