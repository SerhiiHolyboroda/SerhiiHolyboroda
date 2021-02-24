package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        searchInput.sendKeys("dress");

        searchInput.sendKeys(Keys.ENTER);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 600);
        wait.until(
                ExpectedConditions
                        .presenceOfNestedElementsLocatedBy(By.id("selectProductSort"), By.tagName("option")));
        Select dropdown = new Select(driver.findElement(By.id("selectProductSort")));
//        dropdown.selectByIndex(1);
        dropdown.selectByIndex(2);

//        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Sleeve')]")).click();

//        $browser.execute_script('$("span.info").click();')
        driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();

        driver.quit();
    }
}
