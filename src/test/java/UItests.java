import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class UItests {

    private WebDriver driver;

    @Before
    public void StartWebDriver() {
        // Версия браузера Google Chrome - 96.0.4664.45
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "//driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void CloseWebDriver () {
        driver.quit();
    }

    @Test
    public void Subtract() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        Select Prototype = new Select (driver.findElement(By.id("selectBuild")));
        Prototype.selectByVisibleText("Prototype");

        driver.findElement(By.id("number1Field")).sendKeys("2");
        driver.findElement(By.id("number2Field")).sendKeys("3");

        Select Subtract = new Select (driver.findElement(By.id("selectOperationDropdown")));
        Subtract.selectByVisibleText("Subtract");

        driver.findElement(By.id("calculateButton")).click();

        WebElement result = driver.findElement(By.xpath("//input[@id='numberAnswerField']"));
        assertEquals("-1",result.getAttribute("value"));
        //System.out.println(result.getAttribute("value"));
    }

    @Test
    public void Сoncatenation() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        Select Prototype = new Select (driver.findElement(By.id("selectBuild")));
        Prototype.selectByVisibleText("Prototype");

        driver.findElement(By.id("number1Field")).sendKeys("gs");
        driver.findElement(By.id("number2Field")).sendKeys("bu");

        Select Subtract = new Select (driver.findElement(By.id("selectOperationDropdown")));
        Subtract.selectByVisibleText("Concatenate");

        driver.findElement(By.id("calculateButton")).click();
        WebElement result = driver.findElement(By.xpath("//input[@id='numberAnswerField']"));
        assertEquals("gsbu",result.getAttribute("value"));
        //System.out.println(result.getAttribute("value"));
    }

    @Test
    public void StringDice()  {
        driver.get("https://testsheepnz.github.io/random-number.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        Select Demo = new Select (driver.findElement(By.id("buildNumber")));
        Demo.selectByVisibleText("Demo");

        driver.findElement(By.id("rollDiceButton")).click();
        driver.findElement(By.id("numberGuess")).sendKeys("string");
        driver.findElement(By.id("submitButton")).click();

        WebElement result = driver.findElement(By.id("feedbackLabel"));
        assertEquals("string: Not a number!",result.getText());
        //System.out.println(result.getText());
    }
}
