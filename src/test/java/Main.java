import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    @Test
    public void main() {

        System.setProperty("webdriver.chrome.driver", "F:\\Programs\\Install\\MyPrograms\\Programming\\Settings\\IntelliJIDEA\\IdeaProjects\\JAVASelenium\\src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://gmatclub.com/forum/ucp.php?mode=login&cb=SLCd2v7DH8pUsyan9EtB");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("#email")));
        WebElement passwordElement = driver.findElement(By.cssSelector("#password"));
        WebElement formElement = driver.findElement(By.cssSelector("body.ltr.ng-scope:nth-child(2) div.contentBox div.main div.right form.ng-pristine.ng-valid div.buttonBox > input.button:nth-child(3)"));

        usernameElement.sendKeys("nazar333");
        passwordElement.sendKeys("resident");

        formElement.click();

        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"forums\"]/h1")));

        String message = messageElement.getText();
        String successMsg = "Forum Home";

        Assert.assertEquals(successMsg, message);

        driver.quit();

    }
}
