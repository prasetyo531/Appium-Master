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

public class toolsMatches {

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
	        
	        pc.clickToolsCat();
	        asser.waitProductAppearOnSub();
	        
	        //hair tools 61
	        //cek 1
	        String namaProductToolsHair = pc.subCatProductName1();
	        System.out.println(namaProductToolsHair);
	        
	        String itemNamaProductToolsHair = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=61 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsHair);
	        
	        Assert.assertEquals(itemNamaProductToolsHair, namaProductToolsHair);
	        
	        //cek 2
	        String namaProductToolsHair1 = pc.subCatProductName2();
	        System.out.println(namaProductToolsHair1);
	        
	        String itemNamaProductToolsHair1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=61 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsHair1);
	        
	        Assert.assertEquals(itemNamaProductToolsHair1, namaProductToolsHair1);
	        
	        //cek 3
	        String namaProductToolsHair2 = pc.subCatProductName3();
	        System.out.println(namaProductToolsHair2);
	        
	        String itemNamaProductToolsHair2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=61 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsHair2);
	        
	        Assert.assertEquals(itemNamaProductToolsHair2, namaProductToolsHair2);
	        
	        //make up tools 62
	        //cek 1
	        pc.clickTabMakeUp();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductToolsMakeUp = pc.subCatProductName1();
	        System.out.println(namaProductToolsMakeUp);
	        
	        String itemNamaProductToolsMakeUp = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=62 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsMakeUp);
	        
	        Assert.assertEquals(itemNamaProductToolsMakeUp, namaProductToolsHair);
	        
	        //cek 2
	        String namaProductToolsMakeUp1 = pc.subCatProductName2();
	        System.out.println(namaProductToolsMakeUp1);
	        
	        String itemNamaProductToolsMakeUp1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=62 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsMakeUp1);
	        
	        Assert.assertEquals(itemNamaProductToolsMakeUp1, namaProductToolsHair1);
	        
	        //cek 3
	        String namaProductToolsMakeUp2 = pc.subCatProductName3();
	        System.out.println(namaProductToolsMakeUp2);
	        
	        String itemNamaProductToolsMakeUp2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=62 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsMakeUp2);
	        
	        Assert.assertEquals(itemNamaProductToolsMakeUp2, namaProductToolsHair2);
	        
	        //skincare tools 63
	        //cek 1
	        pc.clickTabSkincare();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductToolsSkincare = pc.subCatProductName1();
	        System.out.println(namaProductToolsSkincare);
	        
	        String itemNamaProductToolsSkincare = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=63 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsSkincare);
	        
	        Assert.assertEquals(itemNamaProductToolsSkincare, namaProductToolsSkincare);
	        
	        //cek 2
	        String namaProductToolsSkincare1 = pc.subCatProductName2();
	        System.out.println(namaProductToolsSkincare1);
	        
	        String itemNamaProductToolsSkincare1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=63 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsSkincare1);
	        
	        Assert.assertEquals(itemNamaProductToolsSkincare1, namaProductToolsSkincare1);
	        
	        //cek 3
	        String namaProductToolsSkincare2 = pc.subCatProductName3();
	        System.out.println(namaProductToolsSkincare2);
	        
	        String itemNamaProductToolsSkincare2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=63 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsSkincare2);
	        
	        Assert.assertEquals(itemNamaProductToolsSkincare2, namaProductToolsSkincare2);
	        
	        //body tools 64
	        //cek 1
	        pc.clickTabToolBody();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductToolsBody = pc.subCatProductName1();
	        System.out.println(namaProductToolsBody);
	        
	        String itemNamaProductToolsBody = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=64 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsBody);
	        
	        Assert.assertEquals(itemNamaProductToolsBody, namaProductToolsBody);
	        
	        //cek 2
	        String namaProductToolsBody1 = pc.subCatProductName2();
	        System.out.println(namaProductToolsBody1);
	        
	        String itemNamaProductToolsBody1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=64 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsBody1);
	        
	        Assert.assertEquals(itemNamaProductToolsBody1, namaProductToolsBody1);
	        
	        //cek 3
	        String namaProductToolsBody2 = pc.subCatProductName3();
	        System.out.println(namaProductToolsBody2);
	        
	        String itemNamaProductToolsBody2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=64 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaProductToolsBody2);
	        
	        Assert.assertEquals(itemNamaProductToolsBody2, namaProductToolsBody2);
	        
	        
	        
	    }
	
}
