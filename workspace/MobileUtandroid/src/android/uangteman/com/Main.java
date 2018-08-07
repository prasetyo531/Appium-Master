package android.uangteman.com;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.*;



public class Main {
	AndroidDriver ut;
	boolean output = false;
    

	@BeforeClass
	 public void setUp() throws MalformedURLException {
	  // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  capabilities.setCapability("appium-version", "1.0");
	  capabilities.setCapability("platformName", "Android"); // Set android platformName desired capability. It's Android in our case here.
	  capabilities.setCapability("platformVersion", "5.1.1"); // Set android VERSION desired capability. Set your mobile device's OS version.
	  capabilities.setCapability("deviceName", "4b1341ecb3b7624e"); // Set android deviceName desired capability. Set your device name.
	  capabilities.setCapability("app", "/Users/prasetyo/Documents/apk/UangTeman-Dev-22.apk");
	  capabilities.setCapability("appPackage", "com.dai.uangteman.debug");
	  capabilities.setCapability("appActivity", "com.dai.uangteman.ui.MainActivity");

	  ut = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  ut.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	 }

	 @Test
	    public void Testsuites() throws ClassNotFoundException, InterruptedException {
		 
		 ut.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
//		 ut.swipe(000, -100, -310, -614, 4000);//ut.swipe(485, 550, 485, 200, 4000);
	     ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[8]/android.widget.TextView[1]")).click();
	       // ut.findElement(By.name("Open navigation drawer")).click();
	     ut.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]")).click();
//	     ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[3]/android.widget.FrameLayout[4]/android.widget.FrameLayout[5]/android.widget.LinearLayout[1]/android.widget.EditText[1]")).sendKeys("uttestacount8@gmail.com");
	     ut.findElement(By.xpath("//android.widget.EditText[@text='Alamat Email']")).sendKeys("myjne001@gmail.com");
	     ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.CheckBox[1]")).click();
	     ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).click();
	    
	       
	     ut.findElement(By.id("com.dai.uangteman.debug:id/medical_bills")).click();
	     
	     String strsatu="Pilih Source";
	     ut.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+strsatu+"\").instance(0))").click();
         
//	     ut.findElementByAndroidUIAutomator("new UiScrollable(new Uiselector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();
//	     ut.scrollTo("Pilih Source");
//	     ut.scrollTo("Views");
//	     ut.swipe(0, 0, 35, -622, 4000);
	     
//	     ut.findElement(By.id("com.dai.uangteman.debug:text/Pilih Source")).click();
//	     ut.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Billboard\")").click();
	     ut.hideKeyboard();
//	     ut.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Lanjut Isi Detail Data\")").click();
	     ut.findElement(By.xpath("//android.widget.ListView[1]/android.widget.TextView[2]")).click();
//	     ut.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]")).click();
	     ut.findElement(By.id("com.dai.uangteman.debug:id/next_detail_data_button")).click();
	     
	     //personal detail
	     ut.findElement(By.id("com.dai.uangteman.debug:id/full_name")).sendKeys("DORA DEBORA");
//	     ut.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[5]")).sendKeys("Dora");
	     ut.findElement(By.id("com.dai.uangteman.debug:id/female")).click();
	     
	     String strdua="Tempat Lahir";
	     ut.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+strdua+"\").instance(0))").click();
         
//	     ut.swipe(403, 500, 403, 200, 500);
//	     ut.scrollTo("Tempat Lahir*");
//	     ut.scrollToExact("Tempat Lahir*");
	     ut.findElement(By.id("com.dai.uangteman.debug:id/birth_place")).sendKeys("Medan");
	     //List<WebElement> date = (List<WebElement>) ut.findElement(By.id("com.dai.uangteman.debug:id/birth_date"));
	     ut.findElement(By.id("com.dai.uangteman.debug:id/birth_date")).click();
//	     ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
//	     ut.findElement(By.id("com.dai.uangteman.debug:id/birth_place")).sendKeys("20/11/1997");
	     	     
	    ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();

	     for (int i=0;i<33;i++)
	    {
	    	 ut.swipe(350,511,350,577,0); 
	    }
	    
	    String strtiga="1990";
	    ut.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+strtiga+"\").instance(0))").click();
	    
//	    ut.findElement(By.name("1990")).click();
//	    ut.findElement(By.id("android:id/button1")).click();

//	    ut.swipe(403, 500, 403, 200, 500);
		ut.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.ViewAnimator[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[15]")).click();
		ut.findElement(By.id("android:id/button1")).click();
		
		ut.findElement(By.id("com.dai.uangteman.debug:id/last_education")).click();
	    ut.findElement(By.xpath("//android.widget.ListView[1]/android.widget.TextView[7]")).click();
	    ut.findElement(By.id("com.dai.uangteman.debug:id/marriage_status")).click();
	    ut.findElement(By.xpath("//android.widget.ListView[1]/android.widget.TextView[2]")).click();
	    
	    ut.findElement(By.id("com.dai.uangteman.debug:id/dependent")).sendKeys("0");
//	    ut.hideKeyboard();
	    
	    
//	    Thread.sleep(2000);
	  
	    
//	    ut.swipe(403, 500, 403, 200, 500);
	    

	      
	     }

/*	    
	 public void Sum() {
	  // Click on DELETE/CLR button to clear result text box before running test.
	  driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

	  // Click on number 2 button.
	  driver.findElement(By.name("2")).click();

	  // Click on + button.
	  driver.findElement(By.name("+")).click();

	  // Click on number 5 button.
	  driver.findElement(By.name("5")).click();

	  // Click on = button.
	  driver.findElement(By.name("=")).click();

	  // Get result from result text box.
	  String result = driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number sum result is : " + result);

	 }
	 */

	 
	    @AfterClass
	    public static void tearDownClass() throws Exception {
	    }

	    @BeforeMethod
	    public void setUpMethod() throws Exception {
	    }

	    @AfterMethod
	    public void tearDownMethod() throws Exception {
	    }

	public boolean isElementExit(By by) {
	        try {
	            ut.findElement(by);
	        } catch (Exception e) {
	            return false;
	        }
	        return true;
	    }

	@AfterTest
	 public void End() {
	  ut.quit();
	 }
}
