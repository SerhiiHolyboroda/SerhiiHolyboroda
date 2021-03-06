package Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    @Test
    public void searchForDress() {
        open("http://automationpractice.com/index.php");
        $(By.xpath("//*[@id=\"search_query_top\"]")).val("dress").pressEnter();


     String newPrice =   $(By.className("product-container")).shouldHave((text("Printed"))).find(By.className("product-price")).getText();
        String oldPrice =  $(By.className("product-container")).shouldHave((text("Printed"))).find(By.className("old-price")).getText();

        $(By.className("product-container")).shouldHave((text("Printed"))).find(By.tagName("a")).click();

        System.out.println(    $(By.xpath("//*[@id=\"quantity_wanted\"]")).isDisplayed() + " " + "Check if element exist");
        System.out.println(  $(By.xpath("//*[@class=\"attribute_list\"]")).isDisplayed()  + " " + "Check if element exist");


     String newPriceCheck =   $(By.id("our_price_display")).getText();
//     $(By.xpath("//*[@id=\"our_price_display\"]")).getText();

        String oldPriceCheck =   $(By.id("old_price_display")).getText();
//                $(By.xpath("//*[@id=\"old_price_display\"]")).getText();

//        System.out.println( newPrice);
//        System.out.println(oldPrice);
        System.out.println(newPriceCheck);
        System.out.println(oldPriceCheck);
//        System.out.println(newPriceCheck == newPrice);
//        System.out.println(oldPriceCheck == oldPrice);
    }
}
