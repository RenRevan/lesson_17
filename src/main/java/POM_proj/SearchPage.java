package POM_proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;
    private  String URL ;
    @FindBy(xpath = "//*[@title='List']")
    private WebElement PRODUCT_LIST_LIST;
    @FindBy(xpath = "//*[@class='product_list row list']/li[1]//*[@title='Add to cart']")
    private WebElement PRODUCT_LIST_ADDTOCARD;
    private By PRODUCT_ADDTOCARD_WINDOW = By.xpath("//*[@id=\"layer_cart\"]/div[1]");
    @FindBy(xpath = "//*[@id='layer_cart']//a[@title='Proceed to checkout']")
    private WebElement PRODUCT_BTN_CHECKOUT ;
    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement BREAD_CRUMBS;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("main page constructor");
    }

    public String getBreadCrumbs(){
        return BREAD_CRUMBS.getText();
    }

    public SearchPage clickBtnList(){
        PRODUCT_LIST_LIST.click();
        return this;
    }

    public SearchPage clickBtnAddToCard(){
        PRODUCT_LIST_ADDTOCARD.click();
        return this;
    }
    public ShoppingCardSum clickBtnCheckOut(){
        PRODUCT_BTN_CHECKOUT.click();
        return PageFactory.initElements(driver,ShoppingCardSum.class);
    }
    public By getProductAddtocardWindow(){
        return PRODUCT_ADDTOCARD_WINDOW;
    }

}
