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
import pageObject.home;
import pageObject.productCategory;
import resources.assertions;

public class bodyMatches {

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
	        
	        //wait personal beauty
//	        asser.waitpersonalbeauty();
//	        if (driver.findElement(By.id("com.fdbr.android.debug:id/rel_content")).isDisplayed()) {
//	    		hm.closeWaitPersonalBeauty();
//	    	}
	        
	        asser.waitSearchElement();
	        
	        hm.clickCategory();
	        asser.waitProductAppear();
	        
	        pc.clickBodyCat();
	        asser.waitProductAppearOnSub();
	        
	        //hand & foot
	        //hand cream 92
	        //cek 1
	        String namaProductHandFoot = pc.subCatProductName1();
	        System.out.println(namaProductHandFoot);
	        
	        String itemNamaHandFoot = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=92 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandFoot);
	        
	        Assert.assertEquals(itemNamaHandFoot, itemNamaHandFoot);
	        
	        //cek 2
	        String namaProductHandFoot1 = pc.subCatProductName2();
	        System.out.println(namaProductHandFoot);
	        
	        String itemNamaHandFoot1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=92 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandFoot1);
	        
	        Assert.assertEquals(itemNamaHandFoot1, itemNamaHandFoot1);
	        
	        //cek 3
	        String namaProductHandFoot2 = pc.subCatProductName3();
	        System.out.println(namaProductHandFoot2);
	        
	        String itemNamaHandFoot2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=92 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaHandFoot2);
	        
	        Assert.assertEquals(itemNamaHandFoot2, itemNamaHandFoot2);
	        
	        //bath & shower
	        //bath treatement 11
	        //cek 1
	        pc.clickTabBath();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductBathShower = pc.subCatProductName1();
	        System.out.println(namaProductBathShower);
	        
	        String itemNamaBathShower = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=11 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBathShower);
	        
	        Assert.assertEquals(itemNamaBathShower, namaProductBathShower);
	        
	        //cek 2
	        String namaProductBathShower1 = pc.subCatProductName2();
	        System.out.println(namaProductBathShower1);
	        
	        String itemNamaBathShower1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=11 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBathShower1);
	        
	        Assert.assertEquals(itemNamaBathShower1, itemNamaBathShower1);
	        
	        //cek 3
	        String namaProductBathShower2 = pc.subCatProductName3();
	        System.out.println(namaProductBathShower);
	        
	        String itemNamaBathShower2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=11 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaBathShower);
	        
	        Assert.assertEquals(itemNamaBathShower2, namaProductBathShower2);
	        
	        //moisturizer
	        //lotion
	        //cek 1
	        pc.clickTabMois();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductMois = pc.subCatProductName1();
	        System.out.println(namaProductMois);
	        
	        String itemNamaMois = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=15 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaMois);
	        
	        Assert.assertEquals(itemNamaMois, namaProductMois);
	        
	        //cek 2
	        String namaProductMois1 = pc.subCatProductName2();
	        System.out.println(namaProductMois1);
	        
	        String itemNamaMois1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=15 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaMois1);
	        
	        Assert.assertEquals(itemNamaMois1, namaProductMois1);
	        
	        //cek 3
	        String namaProductMois2 = pc.subCatProductName3();
	        System.out.println(namaProductMois2);
	        
	        String itemNamaMois2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=15 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaMois2);
	        
	        Assert.assertEquals(itemNamaMois2, namaProductMois2);
	        
	        //sun 101
	        //cek 1
	        pc.clickTabSun();
	        asser.waitProductAppearOnSub();
	        
	        String namaProductSun = pc.subCatProductName1();
	        System.out.println(namaProductSun);
	        
	        String itemNamaSun = connection.getDataCategoryArrayFirst("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=101 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaSun);
	        
	        Assert.assertEquals(itemNamaMois, namaProductMois);
	        
	        //cek 2
	        String namaProductSun1 = pc.subCatProductName2();
	        System.out.println(namaProductSun1);
	        
	        String itemNamaSun1 = connection.getDataCategoryArraySecond("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=101 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaSun1);
	        
	        Assert.assertEquals(itemNamaSun1, namaProductSun1);
	        
	        //cek 3
	        String namaProductSun2 = pc.subCatProductName3();
	        System.out.println(namaProductSun2);
	        
	        String itemNamaSun2 = connection.getDataCategoryArrayThird("select nubr_products.prod_item from nubr_products INNER JOIN nubr_reviews ON nubr_products.prod_id=nubr_reviews.review_prod_id INNER JOIN nubr_categories ON nubr_categories.cat_id=nubr_reviews.review_cat_id WHERE nubr_reviews.review_cat_id=101 ORDER BY nubr_reviews.review_num DESC LIMIT 5", "staging"); // 92
	        System.out.println(itemNamaSun2);
	        
	        Assert.assertEquals(itemNamaSun2, namaProductSun2);
	        
	        //need verify
	        //only one product
	    	
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	       // driver.quit();

	    }
}
