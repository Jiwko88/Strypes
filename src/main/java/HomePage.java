import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage {
    WebDriver driver = new ChromeDriver();

    public void goToHomePageAndAcceptCookies() {

        driver.manage().window().maximize();
        driver.get("https://strypes.eu/");
        Assert.assertEquals("https://strypes.eu/", driver.getCurrentUrl(), "Correct url");
        implicitWait(3);
        WebElement acceptAllCookies = driver.findElement(By.xpath("//div[@class ='cky-notice-group']//button[contains(text(),'Accept All')]"));
        highLightElement(acceptAllCookies);
        acceptAllCookies.click();
    }

    public void goAndSearch(String info) {
        WebElement search = driver.findElement(By.xpath("//i[@class ='fas fa-search']"));
        search.click();
        WebElement searchField = driver.findElement(By.xpath("//input[@id= 'elementor-search-form-5295a54a']"));
        searchField.sendKeys(info);
        searchField.sendKeys(Keys.ENTER);
    }

    public void verifyResultsForAutomation() {
        WebElement result = driver.findElement(By.xpath("//a[contains(text(),'Automation')]"));
        highLightElement(result);
        result.click();
        Assert.assertEquals("https://strypes.eu/jobs/automation-quality-assurance-engineer/", driver.getCurrentUrl(), "Correct url");

    }

    public void verifyResultsForVehicule() {
        WebElement resultNotFound = driver.findElement(By.xpath("//div[contains(text(),\"It seems we can't find what you're looking for.\")]"));
        highLightElement(resultNotFound);
        System.out.println(resultNotFound.getText());

    }

    public void goToCareers() {
        WebElement careers = driver.findElement(By.xpath("//*[@id=\"menu-1-50af2d3b\"]/li[7]/a"));
        careers.click();
        Assert.assertEquals("https://strypes.eu/careers/", driver.getCurrentUrl(), "Correct url");
        WebElement hiring = driver.findElement(xpath("//h2[contains(text(),'We are hiring')]"));
        scrollToHiring();
        highLightElement(hiring);
        selectOthersFromDropDown();

    }

    public void selectOthersFromDropDown() {

        WebElement dropDownOthers = driver.findElement(By.xpath("//option[contains(text(),'Other (2)')]"));
        dropDownOthers.click();
    }

    public void scrollToHiring() {

        WebElement hiring = driver.findElement(By.xpath("//h2[contains(text(),'Take on our Challenge!')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", hiring);

    }

    public void goBackToHomePage() {

        WebElement hPage = driver.findElement(By.xpath("//div[contains(@class,'1d90d236')]"));
        hPage.click();
        Assert.assertEquals("https://strypes.eu/", driver.getCurrentUrl(), "Correct url");

    }

    public void getAllServicesFromMenu() {

        driver.findElement(By.xpath("//*[@id=\"menu-1-50af2d3b\"]/li[3]")).click();
        WebElement ulElements = driver.findElement(By.xpath("//*[@id=\"menu-1-50af2d3b\"]/li[3]"));
        List<WebElement> ListItems = ulElements.findElements(By.tagName("ul"));
        for (WebElement e : ListItems) {
            System.out.println(e.getText());

        }
    }

    public void goToCustomersPage() {

        WebElement customers = driver.findElement(By.xpath("//*[@id=\"menu-1-50af2d3b\"]/li[4]/a"));
        customers.click();
        Assert.assertEquals("https://strypes.eu/customers/", driver.getCurrentUrl(), "Correct url");

    }

    public void verifyCustomersSiteLoading(String client) {

        scrollToOurCustomers();
        WebElement customers = driver.findElement(xpath("//div[contains(text(), '" + client + "')]"));
        customers.click();
        Assert.assertEquals("https://strypes.eu/customers/arvos-group/", driver.getCurrentUrl(), "Correct url");
        WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Visit website')]"));
        button.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            System.out.printf("handle: %s, url: %s%n", handle, driver.getCurrentUrl());
        }
        Assert.assertEquals("https://www.arvos-group.com/", driver.getCurrentUrl(), "Correct url");

    }


    public void scrollToOurCustomers() {

        WebElement ourCustomers = driver.findElement(xpath("//h2[contains(text(),'Explore our Strypes customers')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ourCustomers);

    }

    public void implicitWait(int seconds) {

        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void highLightElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: lime; border: 2px solid red;');", webElement);
    }

    public WebDriver getDriver() {
        return driver;
    }
}


