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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.home;
import resources.assertions;
import database.connection;

public class productMatches {
	
	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 assertions asser;
	 home hm;
	 
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
	        
	        //check 1
	        //brand
	        String MatchProd0 = hm.getProductNameProductMatches1();
	        System.out.println(MatchProd0);
	        	        
	        String itemMatchProd0 = connection.getDataMatchesProduct("SELECT nubr_products.prod_item FROM nubr_reviews INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 7 OR prodskiton_skiton_id = 7 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 3) AND nubr_products.prod_item LIKE'%"+MatchProd0+"%' LIMIT 1", "staging");
	        System.out.println("database"+" "+itemMatchProd0);

	        Assert.assertEquals(MatchProd0, itemMatchProd0);
	        
	        //check 2
	        String MatchProd1 = hm.getProductNameProductMatches2();
	        System.out.println(MatchProd1);
	        
	        String itemMatchProd1 = connection.getDataMatchesProduct("SELECT nubr_products.prod_item FROM nubr_reviews INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 7 OR prodskiton_skiton_id = 7 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 3) AND nubr_products.prod_item LIKE'%"+MatchProd1+"%' LIMIT 1", "staging");
	        System.out.println("database"+" "+itemMatchProd1);

	        Assert.assertEquals(MatchProd1, itemMatchProd1);
	        	
	        //check3
	        String MatchProd2 = hm.getProductNameProductMatches3();
	        System.out.println(MatchProd2);
	        
	        String itemMatchProd2 = connection.getDataMatchesProduct("SELECT nubr_products.prod_item FROM nubr_reviews INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id LEFT JOIN nubr_products_skintype ON nubr_products.prod_id=nubr_products_skintype.prodskityp_prod_id LEFT JOIN nubr_products_skintone ON nubr_products.prod_id=nubr_products_skintone.prodskiton_prod_id LEFT JOIN nubr_products_skinundertone ON nubr_products.prod_id=nubr_products_skinundertone.prodskiund_prod_id LEFT JOIN nubr_products_hairtexture ON nubr_products.prod_id=nubr_products_hairtexture.prodhaitex_prod_id LEFT JOIN nubr_products_hairtype ON nubr_products.prod_id=nubr_products_hairtype.prodhaityp_prod_id LEFT JOIN nubr_products_skinconcern ON nubr_products.prod_id=nubr_products_skinconcern.prodskicon_prod_id LEFT JOIN nubr_products_bodyconcern ON nubr_products.prod_id=nubr_products_bodyconcern.prodbodcon_prod_id LEFT JOIN nubr_products_hairconcern ON nubr_products.prod_id=nubr_products_hairconcern.prodhaicon_prod_id  WHERE  review_cat_id IN(120,178,177,118,119,126,175,49,51,121,123,48,50,124,58,57,60,147,148,92,93,105,106,170,104,169,11,18,13,107,171,15,16,17,108,10,109,101,12,14,94,98,71,72,134,135,136,68,158,70,74,76,79,138,140,73,75,96,67,160,161,188,69,144,145,146,33,36,37,38,39,41,35,40,42,44,46,47,112,189,53,54,55,56,97,114,26,27,28,29,30,110,111,166,32,43,113,31,164,165)  AND (prodskityp_skityp_id= 7 OR prodskiton_skiton_id = 7 OR prodskiund_skiund_id = 2 OR prodhaityp_haityp_id= 3) AND nubr_products.prod_item LIKE'%"+MatchProd2+"%' LIMIT 1", "staging");
	        System.out.println("database"+" "+itemMatchProd2);

	        Assert.assertEquals(MatchProd1, itemMatchProd2);
	        
	        System.out.println("test product matches pass");
	        
	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();

	    }
}
