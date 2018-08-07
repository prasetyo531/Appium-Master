package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productCategory {

	protected static AppiumDriver driver=null;
	
	public productCategory(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	@AndroidFindBy(id = "com.fdbr.android.debug:id/item_popular")
	private WebElement popular;

   	@AndroidFindBy(id = "com.fdbr.android.debug:id/item_skincare")
   	private WebElement skincare;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_makeup")
    private WebElement makeup;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_body")
    private WebElement body;
    
   	@AndroidFindBy(id = "com.fdbr.android.debug:id/item_hair")
   	private WebElement hair;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_fragrance")
    private WebElement fragrance;
	
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_nails")
    private WebElement nails; 
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement tools;
    
    //subcategory product category
    @AndroidFindBy(id = "com.fdbr.android.debug:id/fl_category_1")
    private WebElement cat1;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/fl_category_2")
    private WebElement cat2;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/fl_category_3")
    private WebElement cat3;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/fl_category_4")
    private WebElement cat4;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/fl_category_5")
    private WebElement cat5;
    
    //get product popular
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]")
    private WebElement productname1;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")
    private WebElement productname2;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView[2]")
    private WebElement productname3;
    
    //get product sub category
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView[2]")
    private WebElement subcatproductname1;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")
    private WebElement subcatproductname2;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.TextView[2]")
    private WebElement subcatproductname3;
    
    //cleanser child
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    private WebElement scrub;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]")
    private WebElement toner;
    
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]")
    private WebElement facial;
    
    //moisturizer child
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement all;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement daycream;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement sunprotection;
    
    //treatment child
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement acne;

    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement serum;
    
    @AndroidFindBy(id = "com.fdbr.android.debug:id/item_tools")
    private WebElement peeling;
    
    public void clickPopularCat(){
    	popular.click();
    }
    
	public void clickSkincareCat(){
		skincare.click();
    }

	 public void clickMakeupCat(){
		 makeup.click();
	}
	    
	public void clickBodyCat(){
		body.click();
	}
	
	public void clickHairCat(){
		hair.click();
	}
	    
	public void clickFragranceCat(){
		fragrance.click();
	}
	
	public void clickNailsCat(){
		nails.click();
	}
	    
	public void clickToolsCat(){
		tools.click();
	}
	
	//get text
	public String findProductName1(){
		return productname1.getText();
	}
	
	public String findProductName2(){
		return productname2.getText();
	}
	
	public String findProductName3(){
		return productname3.getText();
	}
	
	public String subCatProductName1(){
		return subcatproductname1.getText();
	}
	
	public String subCatProductName2(){
		return subcatproductname2.getText();
	}
	
	public String subCatProductName3(){
		return subcatproductname3.getText();
	}

	//subcategory skincare
	public void clickTabMoisturizer(){
		cat2.click();
	}
	
	public void clickTabTreatment(){
		cat3.click();
	}
	
	public void clickTabMask(){
		cat4.click();
	}
	
	//subcategory makeup
	public void clickTabLips(){
		cat2.click();
	}
	
	public void clickTabEyes(){
		cat3.click();
	}
	
	public void clickTabCheeck(){
		cat4.click();
	}
	
	//subcategory Body
	public void clickTabBath(){
		cat2.click();
	}
	
	public void clickTabMois(){
		cat3.click();
	}
	
	public void clickTabSun(){
		cat4.click();
	}
	
	public void clickTabPersonal(){
		cat5.click();
	}
	
	//subcategory Hair
	public void clickTabStyling(){
		cat2.click();
	}
	
	public void clickTabShampoo(){
		cat3.click();
	}
	
	//subcategory Fragrance
	public void clickTabPerfumeSolid(){
		cat2.click();
	}
		
	public void clickTabEDP(){
		cat3.click();
	}
	
	public void clickTabEDT(){
		cat4.click();
	}
		
	public void clickTabBodyMist(){
		cat5.click();
	}
	
	//subcategory nails
	public void clickTabCoat(){
		cat2.click();
	}
			
	public void clickTabVitamin(){
		cat3.click();
	}
		
	public void clickTabNailPolish(){
		cat4.click();
	}
			
	public void clickTabNailSets(){
		cat5.click();
	}
	
	//subcategory tools
	public void clickTabMakeUp(){
		cat2.click();
	}
			
	public void clickTabSkincare(){
		cat3.click();
	}
		
	public void clickTabToolBody(){
		cat4.click();
	}
			
	public void clickTabNailTool(){
		cat5.click();
	}
	
}
