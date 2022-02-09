package org.perfect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RemovalFromCart
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments ("start-maximized");
        options.addArguments ("--incognito");
        options.addArguments ("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys ("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys ("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
    }
}
