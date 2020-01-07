package POM_proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    protected BasePage(WebDriver driver){
        this.driver=driver;
    }
    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clearAndSendKeys(WebElement input, String value) {
        waitForVisibility(input);
        input.clear();
        input.sendKeys(value);
    }

    public void click(WebElement button) {
        waitForVisibility(button);
        button.click();
    }
}
