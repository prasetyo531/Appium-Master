package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class assertions {
	
	protected static AppiumDriver driver=null;
	
	public assertions(AppiumDriver<WebElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void waitpdateoption(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_content")));
	}
	
	public void waitpersonalbeauty(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_btn")));
	}
	
	public void waitAppsOpenned(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_login")));
	}
	
	public void waitFieldUsername(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/edt_username")));
	}
	
	public void waitFieldPassword(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/edt_password")));
	}
	
	public void waitButtonLogin(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rel_signin")));
	}
	
	public void waitSearchElement(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/tv_search")));
	}
	
	//product category
	public void waitProductAppear(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]"))); //product name
	}
	
	public void waitProductAppearOnSub(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]")));
	}
	
	//feedback
	public void waitFeedbackOpened(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/tv_questions")));
	}
	
	//feed
	public void waitFeedOpened(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/rl_sug_1")));
	}
	
	//beauty profile page
	public void waitBeatyProfileOpened(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/ll_beauty_id")));
	}

	public void waitFeedbackSended(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.fdbr.android.debug:id/contentPanel")));
	}
	
}
