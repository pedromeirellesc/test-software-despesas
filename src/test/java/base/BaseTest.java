package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public String driverPath;
    public String url;
    public WebDriver driver;

    public BaseTest(String driverPath) {
        this.driverPath = driverPath;
    }

    @BeforeClass
    public void preCond() {
        url = System.getProperty("user.dir") + driverPath;
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
