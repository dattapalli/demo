package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class Blue {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      /* boolean isDisplayedElement = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();

       Assert.assertTrue(isDisplayedElement,"title is not visible");*/
      // System.out.println("Is the "company branding visible? " + isDisplayedElement);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        String expectedValue = "Dashboard";
        String actualValue  = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals(actualValue,expectedValue,"Expacted value is not matched");



    }


}
