package POM_proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends BasePage {
    private WebDriver driver;
    private static String URL = "http://automationpractice.com/index.php";
    @FindBy(id = "search_query_top")
     WebElement SEARCH_FIELD;
    @FindBy(xpath = "//*[@name='submit_search']")
    private WebElement SEARCH_BTN;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("main page constructor");

    }

    public String getURL(){
        return URL;
    }

    public SearchPage clickSearchBtn(){
        SEARCH_BTN.click();
        return new SearchPage(driver);
    }

    public MainPage typeSearchField(String find){
        SEARCH_FIELD.clear();
        //System.out.println(SEARCH_FIELD.+"         "+find);
        SEARCH_FIELD.sendKeys(find);
        return this;
    }

    public SearchPage findProduct(String product){
        super.clearAndSendKeys(SEARCH_FIELD,product);
        super.click(SEARCH_BTN);
        return new SearchPage(driver);
    }

}
