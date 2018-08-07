package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class filterSort {
	
	protected static AppiumDriver driver=null;
	
	public filterSort(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
    //filter
    @AndroidFindBy(id = "com.fdbr.android:id/fl_filter_by")
    private WebElement filter;
    
    @AndroidFindBy(id = "com.fdbr.android:id/rel_brand")
    private WebElement filterbrand;
    
    @AndroidFindBy(id = "com.fdbr.android:id/toolbar_action_button")
    private WebElement filterSearchBrand;
    
    @AndroidFindBy(id = "com.fdbr.android:id/rl_no_filter")
    private WebElement noFilter;
  
    @AndroidFindBy(id = "com.fdbr.android:id/rl_add_filter")
    private WebElement saveFilter;
    
    
    //sort
    @AndroidFindBy(id = "com.fdbr.android:id/fl_sort_by")
    private WebElement sort;
    
    @AndroidFindBy(id = "com.fdbr.android:id/fl_popular")
    private WebElement sortpopular;

    @AndroidFindBy(id = "com.fdbr.android:id/fl_highest_rating")
    private WebElement sorthighestrating;
    
    @AndroidFindBy(id = "com.fdbr.android:id/fl_newest")
    private WebElement newest;
    
    @AndroidFindBy(id = "com.fdbr.android:id/fl_lowest_price")
    private WebElement pricelowhigh;
    
    @AndroidFindBy(id = "com.fdbr.android:id/fl_highest_price")
    private WebElement pricehighlow;
    
    @AndroidFindBy(id = "com.fdbr.android:id/acb_cancel")
    private WebElement cancelsort;
    
    //filter
    public void clickFilter(){
    	filter.click();
	}
    
    public void clickBrandOnFilter(){
    	filterbrand.click();
	}
    
    public void clickSearchBrandOnFilter(){
    	filterSearchBrand.click();
	}
    
    public void clickNoFilter(){
    	noFilter.click();
	}
    
    public void clickSaveFilter(){
    	saveFilter.click();
	}
    
    //sort
    public void clickSort(){
    	sort.click();
	}
    
    public void clickSortPopular(){
    	sortpopular.click();
	}
    
    public void clickSortHighestRating(){
    	sorthighestrating.click();
	}
    
    public void clickSortNewest(){
    	newest.click();
	}
    
    public void clickSortLowestPrice(){
    	pricelowhigh.click();
	}
    
    public void clickSortHighestPrice(){
    	pricehighlow.click();
	}
    
    public void clickCanceSort(){
    	cancelsort.click();
	}
}
