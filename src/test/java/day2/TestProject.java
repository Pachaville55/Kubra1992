package day2;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestProject {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriver driver = new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.htphp");
        Assert.assertEquals(driver.getTitle(), "Welcome to Duotify!");

        WebElement signupLink = driver.findElement(By.linkText("Signup here"));
        signupLink.click();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = "your_desired_username";
        String email = faker.internet().emailAddress();
        String password = "your_password";

        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys(lastName);
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement signupButton = driver.findElement(By.id("registerButton"));
        signupButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("http://duotify.us-east-2.elasticbeanstalk.com/browse.php"));

        driver.quit();
    }
    }


























    


