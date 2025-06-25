package org.example;
import junit.framework.Assert;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.chrome.ChromeDriver;import java.util.ArrayList;import java.util.List;

    public class TestAdd  {
        public static void main(String[] args) throws InterruptedException {

            //WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
            int paginationSize = driver.findElements(By.xpath("//nav[@aria-label='pagination']/button")).size();
            List<String> Names = new ArrayList<>();
            for (int i = 1; i <= paginationSize - 4; i++) {
                String paginationSelector = "//nav[@aria-label='pagination']/button[text()=" + i + "]";
                driver.findElement(By.xpath(paginationSelector)).click();
                List<WebElement> namesElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));          /*  for(WebElement namesElement : namesElements){               Names.add(namesElement.getText());           }*/
                System.out.println("table size at index: " + i + " is " + namesElements.size());
                for (int j = 1; j <= namesElements.size(); j++) {
                    WebElement ele = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[1]"));
                    Names.add(ele.getText());
                }
            }
            for (String name : Names) {
                System.out.println(name);
            }
            int totalNames = Names.size();
            System.out.println("Total no of Names  : " + totalNames);
            String displayCounts = driver.findElement(By.id("example_info")).getText().split(" ")[5];
            System.out.println("Total no of displayedcount :" + displayCounts);
            Assert.assertEquals(displayCounts, String.valueOf(totalNames));
            Thread.sleep(5000);
        }
    }

