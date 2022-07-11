import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class OnlinerTV {
    @Test
    public void checkSamsungManufacturerFilter(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://catalog.onliner.by/tv");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.xpath("//span[contains(text(), 'Sony')]")).click();

        List<WebElement> models = driver.findElements(By.id("js-product-title-link"));
        for (WebElement model: models) {
            Assert.assertTrue(model.getText().contains("Sony"));
        }
        driver.quit();
    }
}


