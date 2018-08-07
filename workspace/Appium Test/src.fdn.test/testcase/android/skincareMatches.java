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
import pageObject.profile;
import pageObject.subCategoryProductCleanser;
import resources.assertions;

public class skincareMatches {
	
	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "testFollow";
//	 AndroidDriver<AndroidElement> driver = null;
	 static AppiumDriver<WebElement> driver;
	 assertions asser;
	 home hm;
	 profile pf;
	 productCategory pc;
	 subCategoryProductCleanser subcleanser;
	 
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
	        
	        pc.clickSkincareCat();
	        asser.waitProductAppearOnSub();
	        
	        //cleanser
	        //scrub 71
	        //cek 1
	        String namaProductScrub = pc.subCatProductName1();
	        System.out.println(namaProductScrub);
	        
	        String itemNamaProductSrub = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=71 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaProductSrub);
	        
	        Assert.assertEquals(itemNamaProductSrub, namaProductScrub);
	        
	        //cek 2
	        String namaProductScrub1 = pc.subCatProductName2();
	        System.out.println(namaProductScrub1);
	        
	        String itemNamaProductScrub1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=71 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaProductScrub1);
	        
	        Assert.assertEquals(itemNamaProductScrub1, namaProductScrub1);
	        
	        //cek 3
	        String namaProductScrub2 = pc.subCatProductName3();
	        System.out.println(namaProductScrub2);
	        
	        String itemNamaProductScrub2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=71 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaProductScrub2);
	        
	        Assert.assertEquals(itemNamaProductScrub2, namaProductScrub2);
	        
	        //Moisturizer 
	        //all 137
	        //cek 1
//	        Thread.sleep(5000);
//	        driver.findElement(By.xpath("//android.support.v7.app.ActionBar$Tab[contains(@index='1')]"));
//	        driver.findElements(By.xpath("//android.support.v7.app.ActionBar.Tab")).get(1).click();
//	        subcleanser.clickTabTonerClean();
//	        asser.waitProductAppearOnSub();
	        
	        pc.clickTabMoisturizer();
	        asser.waitProductAppearOnSub();
	        String namaProductMoisturizer = pc.subCatProductName1();
	        System.out.println(namaProductMoisturizer);
	        
	        String itemNamaMoisturizer = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (137) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaMoisturizer);
	        
	        Assert.assertEquals(itemNamaMoisturizer, namaProductMoisturizer);
	        
	        //cek 2
	        String namaProductMoisturizer1 = pc.subCatProductName2();
	        System.out.println(namaProductMoisturizer1);
	        
	        String itemNamaMoisturizer1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (137) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaMoisturizer1);
	        
	        Assert.assertEquals(itemNamaMoisturizer1, namaProductMoisturizer1);
	        
	        //cek 3
	        String namaProductMoisturizer2 = pc.subCatProductName3();
	        System.out.println(namaProductMoisturizer2);
	        
	        String itemNamaMoisturizer2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (137) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 71 = scrub & exfollator
	        System.out.println(itemNamaMoisturizer2);
	        
	        Assert.assertEquals(itemNamaMoisturizer2, namaProductMoisturizer2);
	        
	        //Treatment
	        //acne = 73
	        //cek 1
	        pc.clickTabTreatment();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductTreatment = pc.subCatProductName1()+" ";
	        System.out.println(namaProductTreatment);
	        
	        String itemNamaTreatment = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (73) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 73 = scrub & exfollator
	        System.out.println(itemNamaTreatment);
	        
	        Assert.assertEquals(itemNamaTreatment, namaProductTreatment);
	        
	        //cek 2
	        String namaProductTreatment1 = pc.subCatProductName2();
	        System.out.println(namaProductTreatment1);
	        
	        String itemNamaTreatment1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (73) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 73 = scrub & exfollator
	        System.out.println(itemNamaTreatment1);
	        
	        Assert.assertEquals(itemNamaTreatment1, namaProductTreatment1);
	        
	        //cek 3
	        String namaProductTreatment2 = pc.subCatProductName3();
	        System.out.println(namaProductTreatment2);
	        
	        String itemNamaTreatment2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (73) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 73 = scrub & exfollator
	        System.out.println(itemNamaTreatment2);
	        
	        Assert.assertEquals(itemNamaTreatment2, namaProductTreatment2);
	        
	        //mask
	        //all = 143
	        //cek 1
	        pc.clickTabMask();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductMask = pc.subCatProductName1();
	        System.out.println(namaProductMask);
	        
	        String itemNamaMask = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (143) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 143 
	        System.out.println(itemNamaMask);
	        
	        Assert.assertEquals(itemNamaMask, namaProductMask);
	        
	        //cek 2
	        String namaProductMask1 = pc.subCatProductName2();
	        System.out.println(namaProductMask1);
	        
	        String itemNamaMask1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (143) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 143 
	        System.out.println(itemNamaMask1);
	        
	        Assert.assertEquals(itemNamaMask1, namaProductMask1);
	        
	        //cek 3
	        String namaProductMask2 = pc.subCatProductName3();
	        System.out.println(namaProductMask2);
	        
	        String itemNamaMask2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id IN (143) ORDER BY nubr_reviews.review_num DESC LIMIT 3", "staging"); // 143
	        System.out.println(itemNamaMask2);
	        
	        Assert.assertEquals(itemNamaMask2, namaProductMask2);
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();

	    }

}
