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

public class fragranceMatches {

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
	        
	        pc.clickFragranceCat();
	        asser.waitProductAppearOnSub();
	        
	        //perfurme oil 22
	        //cek 1
	        String namaProductPerfurme = pc.subCatProductName1();
	        System.out.println(namaProductPerfurme);
	        
	        String itemNamaHandPerfurme = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=22 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurme);
	        
	        Assert.assertEquals(itemNamaHandPerfurme, namaProductPerfurme);
	        
	        //cek 2
	        String namaProductPerfurme1 = pc.subCatProductName2();
	        System.out.println(namaProductPerfurme1);
	        
	        String itemNamaHandPerfurme1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=22 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurme1);
	        
	        Assert.assertEquals(itemNamaHandPerfurme1, namaProductPerfurme1);
	        
	        //cek 3
	        String namaProductPerfurme2 = pc.subCatProductName3();
	        System.out.println(namaProductPerfurme2);
	        
	        String itemNamaHandPerfurme2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=22 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurme2);
	        
	        Assert.assertEquals(itemNamaHandPerfurme2, namaProductPerfurme2);
	        
	        //perfurme solid 23
	        //cek 1
	        pc.clickTabPerfumeSolid();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductPerfurmeSolid = pc.subCatProductName1();
	        System.out.println(namaProductPerfurmeSolid);
	        
	        String itemNamaHandPerfurmeSolid = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=23 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurmeSolid);
	        
	        Assert.assertEquals(itemNamaHandPerfurmeSolid, namaProductPerfurmeSolid);
	        
	        //cek 2
	        String namaProductPerfurmeSolid1 = pc.subCatProductName2();
	        System.out.println(namaProductPerfurmeSolid1);
	        
	        String itemNamaHandPerfurmeSolid1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=23 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurmeSolid1);
	        
	        Assert.assertEquals(itemNamaHandPerfurmeSolid1, namaProductPerfurmeSolid1);
	        
	        //cek 3
	        String namaProductPerfurmeSolid2 = pc.subCatProductName3();
	        System.out.println(namaProductPerfurmeSolid);
	        
	        String itemNamaHandPerfurmeSolid2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=23 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPerfurmeSolid2);
	        
	        Assert.assertEquals(itemNamaHandPerfurmeSolid2, namaProductPerfurmeSolid2);
	        
	        //EDP 24
	        //cek 1
	        pc.clickTabEDP();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductEDP = pc.subCatProductName1();
	        System.out.println(namaProductEDP);
	        
	        String itemNamaHandEDP = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=24 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDP);
	        
	        Assert.assertEquals(itemNamaHandEDP, namaProductEDP);
	        
	        //cek 2
	        String namaProductEDP1 = pc.subCatProductName2();
	        System.out.println(namaProductEDP1);
	        
	        String itemNamaHandEDP1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=24 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDP1);
	        
	        Assert.assertEquals(itemNamaHandEDP1, namaProductEDP1);
	        
	        //cek 3
	        String namaProductEDP2 = pc.subCatProductName3();
	        System.out.println(namaProductEDP2);
	        
	        String itemNamaHandEDP2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=24 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDP2);
	        
	        Assert.assertEquals(itemNamaHandEDP2, namaProductEDP2);
	        
	        //EDT 25
	        //cek 1
	        pc.clickTabEDT();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductEDT = pc.subCatProductName1();
	        System.out.println(namaProductEDT);
	        
	        String itemNamaHandEDT = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=25 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDT);
	        
	        Assert.assertEquals(itemNamaHandEDT, namaProductEDT);
	        
	        //cek 2
	        String namaProductEDT1 = pc.subCatProductName2();
	        System.out.println(namaProductEDT1);
	        
	        String itemNamaHandEDT1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=25 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDT1);
	        
	        Assert.assertEquals(itemNamaHandEDT1, namaProductEDT1);
	        
	        //cek 3
	        String namaProductEDT2 = pc.subCatProductName3();
	        System.out.println(namaProductEDT2);
	        
	        String itemNamaHandEDT2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=25 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandEDT2);
	        
	        Assert.assertEquals(itemNamaHandEDT2, namaProductEDT2);
	        
	        //EDT 25
	        //cek 1
	        pc.clickTabBodyMist();;
	        asser.waitProductAppearOnSub();
	      
	        String namaProductBodyMist = pc.subCatProductName1();
	        System.out.println(namaProductBodyMist);
	        
	        String itemNamaBodyMist = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=95 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBodyMist);
	        
	        Assert.assertEquals(itemNamaBodyMist, namaProductBodyMist);
	        
	        //cek 2
	        String namaProductBodyMist1 = pc.subCatProductName2();
	        System.out.println(namaProductBodyMist1);
	        
	        String itemNamaBodyMist1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=95 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBodyMist1);
	        
	        Assert.assertEquals(itemNamaBodyMist1, namaProductBodyMist1);
	        
	        //cek 3
	        String namaProductBodyMist2 = pc.subCatProductName3();
	        System.out.println(namaProductBodyMist2);
	        
	        String itemNamaBodyMist2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=95 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBodyMist2);
	        
	        Assert.assertEquals(itemNamaBodyMist2, namaProductBodyMist2);
	        
	    }
	    
	    public void tearDown() {
	        driver.quit();

	    }
	
}
