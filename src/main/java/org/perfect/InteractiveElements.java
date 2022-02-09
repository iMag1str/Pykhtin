package org.perfect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class InteractiveElements
{
    public static void main( String[] args ) throws InterruptedException
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

        WebElement webElement = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
        webElement.click();
        Thread.sleep(2500);

        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/saucelabs']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']")).click();
        Thread.sleep(1500);
        driver.quit();
    }
}
