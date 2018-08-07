package testcase.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import database.connection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pageObject.home;
import pageObject.productCategory;
import resources.assertions;

public class hairMatches {

	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 assertions asser;
	 home hm;
	 productCategory pc;
	 
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
	    	
	    	//testcase
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
	        
	        hm.clickCategory();
	        asser.waitProductAppear();
	        
	        pc.clickHairCat();
	        asser.waitProductAppearOnSub();
	        
	        //treatment
	        //vitamin & serum 52
	        //cek 1
	        //need verify
	        String namaProductVitamin = pc.subCatProductName1();
	        System.out.println(namaProductVitamin);
	        
	        String itemNamaHandVitamin = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=52 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitamin);
	        
	        Assert.assertEquals(itemNamaHandVitamin, namaProductVitamin);
	        
	        //cek 2
	        //need verify
	        String namaProductVitamin1 = pc.subCatProductName2();
	        System.out.println(namaProductVitamin1);
	        
	        String itemNamaHandVitamin1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=52 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitamin1);
	        
	        Assert.assertEquals(itemNamaHandVitamin1, namaProductVitamin1);
	        
	        //cek 3
	        //need verify
	        String namaProductVitamin2 = pc.subCatProductName3();
	        System.out.println(namaProductVitamin2);
	        
	        String itemNamaHandVitamin2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=52 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitamin2);
	        
	        Assert.assertEquals(itemNamaHandVitamin2, namaProductVitamin2);
	        
	        //styling & colour
	        //vitamin & serum 52
	        //cek 1
	        
	    }
	
	    public void tearDown() {
	        driver.quit();

	    }
}
