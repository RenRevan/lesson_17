package POM_proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{


        private WebDriver driver ;
        private MainPage mainpage;
        private SearchPage searchPage;
        private String searchPageURL, cardURL;
        private ShoppingCardSum cardPage;
        private String productToSearch = "blouse";
        private String searchurl= "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query="+productToSearch.toLowerCase()+"&submit_search=";


    @BeforeClass
    private void initmainTest(){
        driver = super.getDriver();
    }

        @Test
        public void productSearch() {
            mainpage =   new MainPage(driver);
            mainpage.findProduct("Blouse");
            Assert.assertNotEquals(mainpage.getURL(), driver.getCurrentUrl(), "Find Blouse");
        }

        @Test(priority = 2)
        public void addToCardProduct() {
            addToCard();
            Assert.assertNotEquals(searchurl, driver.getCurrentUrl());
        }

        @Test(priority = 3)
        public void checkCardProductTotal() {
            checkCard();
            Assert.assertTrue(cardPage.getProductTotalText().equals("$54.00"), "ProductTotal ok " + cardPage.getProductTotalText());
        }
        @Test(priority = 4)
        public void checkCardTotalProduct() {
            Assert.assertEquals(cardPage.getTotalProductsText(),"$54.00", "total product ok");
        }
        @Test(priority = 4)
        public void checkCardTotalShipping() {
            Assert.assertEquals(cardPage.getTotalShippingText(),"$2.00","TotalShipping ok" );
        }
        @Test(priority = 4)
        public void checkCardTotalAll() {
            Assert.assertEquals(cardPage.getTotalAllText(),"$56.00", "TotalAll ok");
        }
        @Test(priority = 4)
        public void checkCardTAX() {
            Assert.assertEquals(cardPage.getTAXText(),"$0.00", "tax ok");
        }
        @Test(priority = 4)
        public void checkCardTotalCommon() {
            Assert.assertEquals(cardPage.getTotalCommonText(),"$56.00", "total common ok");
        }

        @Test(priority = 6)
        public void deleteProductCheck() {
            deleteProduct();
            Assert.assertTrue(driver.findElement(cardPage.getEmptyCardMsg()).isDisplayed());
        }



        public void addToCard() {
            searchPage =  new SearchPage(driver);
            searchPage.clickBtnList()
                    .clickBtnAddToCard();
             dynamicElement.until(ExpectedConditions.visibilityOf(driver.findElement(searchPage.getProductAddtocardWindow())));
            searchPage.clickBtnCheckOut();
            cardURL = driver.getCurrentUrl();
             dynamicElement.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@name='quantity_2_7_0_0']"), "1"));
        }


        public void checkCard() {
            cardPage = new ShoppingCardSum(driver);
            cardPage.clickAddBtn();
            dynamicElement.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@name='quantity_2_7_0_0']"), "2"));
        }


        public void deleteProduct() {
           if ( cardPage==null){cardPage = new ShoppingCardSum(driver);}
            dynamicElement.until(ExpectedConditions.visibilityOfElementLocated(cardPage.getDeleteBtn()));
            cardPage.clickDeleteBtn();
            dynamicElement.until(ExpectedConditions.visibilityOfElementLocated(cardPage.getEmptyCardMsg()));

        }





}
