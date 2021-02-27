package com.test.dress;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DressTest {

    String url = "http://automationpractice.com/index.php";
    WebDriver driver;

//    @BeforeMethod
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }


 @Test(dependsOnMethods = "addToBucket")
    @Description("add it here!")
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void openPage() {
        setupDriver();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, url );

    }
        @Test(dependsOnMethods = "openPage")
        public void checkForDress() throws Exception {


            WebElement searchInput = driver.findElement(By.xpath("//input[@id='search_query_top']"));
            searchInput.sendKeys("dress");

            searchInput.sendKeys(Keys.ENTER);
            WebDriverWait wait;
            wait = new WebDriverWait(driver, 600);
            wait.until(
                    ExpectedConditions
                            .presenceOfNestedElementsLocatedBy(By.id("selectProductSort"), By.tagName("option")));

            Select dropdown = new Select(driver.findElement(By.id("selectProductSort")));

            dropdown.selectByIndex(2);
            List<WebElement> searchResults = driver.findElements(By.xpath("//li[contains(@class, 'ajax_block_product')]"));
            WebElement tshirt = searchResults
                    .stream()
                    .filter(element -> element.getText().contains("T-shirts"))
                    .findAny()
                    .orElseThrow(() -> new Exception("Product not found"));
            driver.findElement(By.xpath("//*[contains(text(), 'Sleeve')]")).click();

//
//            driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
//            driver.navigate().refresh();

            WebElement price =  driver.findElement(By.id("our_price_display"));
            String expectedPrice = "$16.51";
            assertEquals(expectedPrice , price.getText());
        }

            @Test(dependsOnMethods = "checkForDress")
             public void addToBucket() throws Exception
            {
            driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
            driver.navigate().refresh();

                driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
              WebElement productName =  driver.findElement(By.xpath("//p[./a[contains(text(),'T-shirts')]]"));
                System.out.println(productName.getText());
//                driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
//                List<WebElement> productName = driver.findElements(By.xpath("//p[contains(@class, 'product-name')]"));
//                System.out.println(productName.get(0) + "wtf");
//                WebElement myOrder= productName
//                        .stream()
//                        .filter(element -> element.getText().contains("T-shirts"))
//                        .findAny()
//                        .orElseThrow(() -> new Exception("Product not found"));
//                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                driver.findElement(By.xpath("//*[contains(text(), 'Sleeve')]")).click();

                assertTrue(  !driver.findElements(By.xpath("//a[contains(text(), 'Sleeve')]")).isEmpty());

            }
        }
