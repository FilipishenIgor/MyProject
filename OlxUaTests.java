package web_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlxUaTests {

    WebDriver driver;

    @Before

    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.olx.ua/");
    }

    @Test

    public void LoginSuccessTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//a[@id='topLoginLink']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='userEmail']")).sendKeys("filipishen@gmail.com");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys("666999333igor");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        Assert.assertNotNull(driver.findElement(By.xpath("/html//div[@id='usertabs']//a[@href='https://www.olx.ua/payment/wallet/topupaccount/']/span[.='Пополнить счет']") ));
        System.out.println("---Login completed---");
    }

    @Test

    public void LoginErrorTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//a[@id='topLoginLink']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='userEmail']")).sendKeys("filipishen@gmail.com");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys("666999333");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        Assert.assertNotNull(driver.findElement(By.xpath("/html//form[@id='loginForm']//p[.='Неверный пароль']")));
        System.out.println("---Login error popup shown---");

    }

    @Test

    public void FavouritsTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//a[@id='topLoginLink']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='userEmail']")).sendKeys("filipishen@gmail.com");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys("666999333igor");
        driver.findElement(By.xpath("/html//input[@id='userPass']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='observed-search-link']/i")).click();
        Thread.sleep(2000);
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@id='usertabs']/ul/li[2]/span/span[@class='fbold']") ));
        System.out.println("---Favourits showed---");
    }


    @Test
    public void OlxSearchTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//input[@id='headerSearch']")).clear();
        driver.findElement(By.xpath("/html//input[@id='headerSearch']")).sendKeys("ipad");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='headerSearch']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        Assert.assertNotNull(driver.findElement(By.xpath("/html//section[@id='body-container']/div[3]/div[@class='content']/div[1]/table[1]//a[@href='https://www.olx.ua/list/q-ipad/?search%5Bpaidads_listing%5D=1']/span[.='Посмотреть все']") ));
        System.out.println("---Ipad's results shown---");
    }

    @Test
    public void OlxSearchKyivTest() throws InterruptedException {
            driver.findElement(By.xpath("/html//input[@id='headerSearch']")).clear();
            driver.findElement(By.xpath("/html//input[@id='headerSearch']")).sendKeys("iphone");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html//input[@id='headerSearch']")).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html//input[@id='cityField']")).click();
            driver.findElement(By.xpath("//div[@id='regionslinks']/ul[2]//span[.='Киевская область']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@id='subregionslinks']/ul[3]/li[1]/a/span[.='Киев']")).click();
            Thread.sleep(3000);

        Assert.assertNotNull(driver.findElement(By.xpath("/html//section[@id='body-container']/div[3]/div[@class='content']/div[1]/table[1]//a[@href='https://www.olx.ua/kiev/q-iphone/?search%5Bpaidads_listing%5D=1']/span[.='Посмотреть все']") ));
        System.out.println("---Iphone's results shown---");


    }

    @Test
    public void ResetPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//a[@id='topLoginLink']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//form[@id='loginForm']//a[@href='https://www.olx.ua/account/forgotpassword/?bs=login_page_forgot_password_button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("test@mail.ru");
        driver.findElement(By.xpath("/html//button[@id='se_userSignIn']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        Assert.assertNotNull(driver.findElement(By.xpath("/html//button[@id='resend-code-button']") ));
        System.out.println("---Password send to e-mail---");

    }

    @Test
    public void LocationChangeTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//input[@id='cityField']")).click();
        driver.findElement(By.xpath("//div[@id='regionslinks']/ul[3]//span[.='Одесская область']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='subregionslinks']/ul[3]/li[1]/a/span[.='Любашевка']")).click();
        Thread.sleep(2000);

        Assert.assertNotNull(driver.findElement(By.xpath("//div[@id='locationBox']/div[@class='clr rel']/div")));
        System.out.println("---Lubashovka ads showed---");

    }

    @Test
    public void LanguageChangeTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//a[@id='changeLang']")).click();
        Thread.sleep(2000);

        Assert.assertNotNull(driver.findElement(By.xpath("/html//a[@id='changeLang']")));
        System.out.println("---Language changed to Ukrainian---");

    }


    @After
    public void quit(){
        driver.quit();

    }
}
