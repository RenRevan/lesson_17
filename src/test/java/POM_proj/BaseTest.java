package POM_proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest  {

        private WebDriver driver;
     WebDriverWait dynamicElement;
    private CreateDriver newdriver ;

    public WebDriver getDriver(){
        return  this.driver;
    }

        @BeforeClass
        public void newDriver()  {
            newdriver = new CreateDriver();
             this.driver = newdriver.runDriver(DriverType.CHROME);
             dynamicElement = new WebDriverWait(driver, 10);
             driver.manage().window().maximize();
        }



        @AfterClass
        public void closeDriver() {
//            driver.close();
            driver.quit();
        }

}
