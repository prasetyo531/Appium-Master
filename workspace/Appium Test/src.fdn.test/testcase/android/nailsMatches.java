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

public class nailsMatches {
	
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
	        
	        pc.clickNailsCat();
	        asser.waitProductAppearOnSub();
	        
	        //polish
	        //cek 1
	        String namaProductPolish = pc.subCatProductName1();
	        System.out.println(namaProductPolish);
	        
	        String itemNamaHandPolish = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=58 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPolish);
	        
	        Assert.assertEquals(itemNamaHandPolish, namaProductPolish);
	        
	        //cek 2
	        String namaProductPolish1 = pc.subCatProductName2();
	        System.out.println(namaProductPolish1);
	        
	        String itemNamaHandPolish1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=58 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPolish1);
	        
	        Assert.assertEquals(itemNamaHandPolish1, namaProductPolish1);
	        
	        //cek 3
	        String namaProductPolish2 = pc.subCatProductName3();
	        System.out.println(namaProductPolish2);
	        
	        String itemNamaHandPolish2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=58 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandPolish2);
	        
	        Assert.assertEquals(itemNamaHandPolish2, namaProductPolish2);
	        
	        //top & base coat 57
	        //cek 1
	        pc.clickTabCoat();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductTopBaseCoat = pc.subCatProductName1();
	        System.out.println(namaProductTopBaseCoat);
	        
	        String itemNamaTopBaseCoat = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=57 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaTopBaseCoat);
	        
	        Assert.assertEquals(itemNamaTopBaseCoat, namaProductTopBaseCoat);

	        //cek 2
	        String namaProductTopBaseCoat1 = pc.subCatProductName2();
	        System.out.println(namaProductTopBaseCoat1);
	        
	        String itemNamaTopBaseCoat1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=57 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaTopBaseCoat1);
	        
	        Assert.assertEquals(itemNamaTopBaseCoat1, namaProductTopBaseCoat1);
	        
	        //cek 3
	        String namaProductTopBaseCoat2 = pc.subCatProductName3();
	        System.out.println(namaProductTopBaseCoat2);
	        
	        String itemNamaTopBaseCoat2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=57 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaTopBaseCoat2);
	        
	        Assert.assertEquals(itemNamaTopBaseCoat2, namaProductTopBaseCoat2);
	        
	        //vitamin & treatment
	        //cek 1
	        pc.clickTabVitamin();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductVitTreat = pc.subCatProductName1();
	        System.out.println(namaProductVitTreat);
	        
	        String itemNamaHandVitTreat = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=60 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitTreat);
	        
	        Assert.assertEquals(itemNamaHandVitTreat, namaProductVitTreat);
	        
	        //cek 2
	        String namaProductVitTreat1 = pc.subCatProductName2();
	        System.out.println(namaProductVitTreat1);
	        
	        String itemNamaHandVitTreat1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=60 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitTreat1);
	        
	        Assert.assertEquals(itemNamaHandVitTreat1, namaProductVitTreat1);
	        
	        //cek 3
	        String namaProductVitTreat2 = pc.subCatProductName3();
	        System.out.println(namaProductVitTreat2);
	        
	        String itemNamaHandVitTreat2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=60 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandVitTreat2);
	        
	        Assert.assertEquals(itemNamaHandVitTreat2, namaProductVitTreat2);
	        
	        //nail polish remover 147
	        //cek 1
	        pc.clickTabNailPolish();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductNailPolish = pc.subCatProductName1();
	        System.out.println(namaProductNailPolish);
	        
	        String itemNamaHandNailPolish = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=147 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandNailPolish);
	        
	        Assert.assertEquals(itemNamaHandNailPolish, namaProductNailPolish);
	        
	        //cek 2
	        String namaProductNailPolish1 = pc.subCatProductName2();
	        System.out.println(namaProductNailPolish1);
	        
	        String itemNamaHandNailPolish1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=147 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandNailPolish1);
	        
	        Assert.assertEquals(itemNamaHandNailPolish1, namaProductNailPolish1);
	        
	        //cek 3
	        String namaProductNailPolish2 = pc.subCatProductName3();
	        System.out.println(namaProductNailPolish2);
	        
	        String itemNamaHandNailPolish2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=147 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandNailPolish2);
	        
	        Assert.assertEquals(itemNamaHandNailPolish2, namaProductNailPolish2);
	        
	        //nail sets 148
	        //cek 1
	        pc.clickTabNailSets();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductNailSets = pc.subCatProductName1();
	        System.out.println(namaProductNailSets);
	        
	        String itemNamaNailSets = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=148 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaNailSets);
	        
	        Assert.assertEquals(itemNamaNailSets, namaProductNailSets);
	        
	        //cek 2
	        String namaProductNailSets1 = pc.subCatProductName2();
	        System.out.println(namaProductNailSets1);
	        
	        String itemNamaNailSets1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=148 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaNailSets1);
	        
	        Assert.assertEquals(itemNamaNailSets1, namaProductNailSets1);
	        
	        //cek 3
	        String namaProductNailSets2 = pc.subCatProductName3();
	        System.out.println(namaProductNailSets2);
	        
	        String itemNamaNailSets2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=148 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaNailSets2);
	        
	        Assert.assertEquals(itemNamaNailSets2, namaProductNailSets2);
	        
	    }   

}
