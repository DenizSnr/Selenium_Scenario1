package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.lang.Thread.*;

public class AppTest 
{
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://training.qastorming.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void Test() throws InterruptedException {
        WebElement shopNowButton = driver.findElement(By.cssSelector("div[data-id='ad0d123'] a.elementor-button-link"));
        shopNowButton.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("a[data-product_id='205']"));
        addToCartButton.click();
        Thread.sleep(3000);
        WebElement cartButton = driver.findElement(By.cssSelector("ul#primary-menu a.cart-page-link"));
        cartButton.click();
        WebElement quantityInput = driver.findElement(By.cssSelector("div.quantity input"));
        quantityInput.clear();
        quantityInput.sendKeys("3");
        WebElement updateCartButton = driver.findElement(By.cssSelector("[name='update_cart']"));
        updateCartButton.click();
        Thread.sleep(3000);
        WebElement removeItemButton = driver.findElement(By.cssSelector("a.remove"));
        removeItemButton.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
