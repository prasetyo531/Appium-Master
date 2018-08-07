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
import pageObject.home;
import pageObject.productCategory;
import resources.assertions;

public class makeupMatches {
	
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
	        
	        pc.clickMakeupCat();
	        asser.waitProductAppearOnSub();
	        
	        //face
	        //concealar 33
	        //cek 1
	        String namaProductFace = pc.subCatProductName1();
	        System.out.println(namaProductFace);
	        
	        String itemNamaProductFace = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=33 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 33
	        System.out.println(itemNamaProductFace);
	        
	        Assert.assertEquals(itemNamaProductFace, namaProductFace);
	        
	        //cek 2
	        String namaProductFace1 = pc.subCatProductName2();
	        System.out.println(namaProductFace1);
	        
	        String itemNamaProductFace1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=33 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 33
	        System.out.println(itemNamaProductFace1);
	        
	        Assert.assertEquals(itemNamaProductFace1, namaProductFace1);
	        
	        //cek 3
	        String namaProductFace2 = pc.subCatProductName3();
	        System.out.println(namaProductFace2);
	        
	        String itemNamaProductFace2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=33 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 33
	        System.out.println(itemNamaProductFace2);
	        
	        Assert.assertEquals(itemNamaProductFace2, namaProductFace2);
	        
	        //lips
	        //all 6
	        //cek 1
	        pc.clickTabLips();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductLips = pc.subCatProductName1();
	        System.out.println(namaProductLips);
	        
	        String itemNamaProductLips = connection.getDataMatchesProduct("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=6 AND nubr_products.prod_item LIKE'%"+namaProductLips+"' ORDER BY nubr_reviews.review_num DESC LIMIT 1", "staging"); // 33
	        System.out.println(itemNamaProductLips);
	        
	        Assert.assertEquals(itemNamaProductLips, namaProductLips);
	        
	        //cek 2
	        String namaProductLips1 = pc.subCatProductName2();
	        System.out.println(namaProductLips1);
	        
	        String itemNamaProductLips1 = connection.getDataMatchesProduct("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=6 AND nubr_products.prod_item LIKE'%"+namaProductLips1+"' ORDER BY nubr_reviews.review_num DESC LIMIT 1", "staging"); // 33
	        System.out.println(itemNamaProductLips1);
	        
	        Assert.assertEquals(itemNamaProductLips1, namaProductLips1);
	        
	        //cek 3
	        String namaProductLips2 = pc.subCatProductName3();
	        System.out.println(namaProductLips2);
	        
	        String itemNamaProductLips2 = connection.getDataMatchesProduct("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=6 AND nubr_products.prod_item LIKE'%"+namaProductLips2+"' ORDER BY nubr_reviews.review_num DESC LIMIT 1", "staging"); // 33
	        System.out.println(itemNamaProductLips2);
	        
	        Assert.assertEquals(itemNamaProductLips2, namaProductLips2);
	        
	        //eyes
	        //all 3
	        //cek 1
	        pc.clickTabEyes();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductEyes = pc.subCatProductName1();
	        System.out.println(namaProductEyes);
	        
	        String itemNamaEyes = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (3) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaEyes);
	        
	        Assert.assertEquals(itemNamaEyes, namaProductEyes);
	        
	        //cek 2
	        String namaProductEyes1 = pc.subCatProductName2();
	        System.out.println(namaProductEyes1);
	        
	        String itemNamaEyes1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (3) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaEyes1);
	        
	        Assert.assertEquals(itemNamaEyes1, namaProductEyes1);
	        
	        //cek 3
	        String namaProductEyes2 = pc.subCatProductName3();
	        System.out.println(namaProductEyes2);
	        
	        String itemNamaEyes2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (3) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaEyes2);
	        
	        Assert.assertEquals(itemNamaEyes2, namaProductEyes2);
	        
	        //cheeck
	        //bronzer
	        //cek 1
	        pc.clickTabCheeck();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductCheeck = pc.subCatProductName1();
	        System.out.println(namaProductCheeck);
	        
	        String itemNamaCheeck = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (32) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaCheeck);
	        
	        Assert.assertEquals(itemNamaCheeck, namaProductCheeck);
	        
	        //cek 2
	        String namaProductCheeck1 = pc.subCatProductName2();
	        System.out.println(namaProductCheeck1);
	        
	        String itemNamaCheeck1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (32) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaCheeck1);
	        
	        Assert.assertEquals(itemNamaCheeck1, namaProductCheeck1);
	        
	        //cek 3
	        String namaProductCheeck2 = pc.subCatProductName3();
	        System.out.println(namaProductCheeck2);
	        
	        String itemNamaCheeck2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (32) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaCheeck2);
	        
	        Assert.assertEquals(itemNamaCheeck2, namaProductCheeck2);
	        
	    }

	    @AfterMethod
	    public void tearDown() {
//	        driver.quit();

	    }
}
