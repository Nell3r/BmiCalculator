import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BmiCalculatorTest {

    @Test
    public void starvationTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10.1");
        browser.findElement(By.name("ht")).sendKeys("100");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Категория неверная");
        browser.quit();
    }

    @Test
    public void underweightTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("15.1");
        browser.findElement(By.name("ht")).sendKeys("100");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Underweight", "Категория неверная");
        browser.quit();
    }

    @Test
    public void alertTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("11");
        browser.findElement(By.name("cc")).click();
        browser.switchTo().alert().accept();
        browser.quit();
    }

    @Test
    public void selectTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("23");
        WebElement element = browser.findElement(By.name("opt1"));
        new Select(element).selectByIndex(0);
        WebElement element1 = browser.findElement(By.name("opt2"));
        new Select(element1).selectByIndex(2);
        WebElement element2 = browser.findElement(By.name("opt3"));
        new Select(element2).selectByIndex(1);
        browser.findElement(By.name("cc")).click();
        browser.quit();
    }
}
