package POM_proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardSum {
    private static String URL = "http://automationpractice.com/index.php?controller=order";
    @FindBy(xpath = "//*[@class='cart_total'][1]//*[@class='price']")
    private WebElement PRODUCT_TOTAL;
    @FindBy(xpath = "//*[@id='total_product'][1]")
    private WebElement TOTAL_PRODUCTS;
    @FindBy(xpath = "//*[@id='total_shipping'][1]")
    private WebElement TOTAL_SHIPPING;
    @FindBy(xpath = "//*[@id='total_price_without_tax'][1]")
    private WebElement TOTAL_ALL;
    @FindBy(xpath = "//*[@id='total_tax'][1]")
    private WebElement TAX;
    @FindBy(xpath = "//*[@id='total_price'][1]")
    private WebElement TOTAL_COMMON;
    @FindBy(xpath = "//*[@id='cart_quantity_up_2_7_0_0'][1]")
    private WebElement ADD_BTN;
    private static By DELETE_BTN = By.xpath("//*[@id='2_7_0_0'][1]");
    private static By EMPTY_CARD_MSG = By.xpath("//*[@class='alert alert-warning'][1]");
    private WebDriver driver;
    private String productTotal, totalProducts,totalShipping, total_all, tax, total_common;

    public ShoppingCardSum(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("main page constructor");
    }

    public ShoppingCardSum clickAddBtn(){
        ADD_BTN.click();
        return this;
    }
    public ShoppingCardSum clickDeleteBtn(){
        driver.findElement(DELETE_BTN).click();
        return this;
    }
    public By getEmptyCardMsg(){
        return EMPTY_CARD_MSG;
    }

    public By getDeleteBtn(){
        return DELETE_BTN;
    }

    public String getProductTotalText(){
        return PRODUCT_TOTAL.getText();
    }
    public String getTotalProductsText(){
        return TOTAL_PRODUCTS.getText();
    }
    public String getTotalShippingText(){
        return TOTAL_SHIPPING.getText();
    }
    public String getTotalAllText(){
        return TOTAL_ALL.getText();
    }
    public String getTAXText(){
        return TAX.getText();
    }
    public String getTotalCommonText(){
        return TOTAL_COMMON.getText();
    }

}
