package day26;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;

	public class GuviSignupLogin {
	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            driver.get("https://www.guvi.in");

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement signupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));
	            signupBtn.click();

	            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
	            nameField.sendKeys("Dummy User");

	            WebElement emailField = driver.findElement(By.id("email"));
	            String dummyEmail = "dummyuser" + System.currentTimeMillis() + "@mail.com"; // unique
	            emailField.sendKeys(dummyEmail);

	            WebElement passwordField = driver.findElement(By.id("password"));
	            String dummyPassword = "DummyPass123";
	            passwordField.sendKeys(dummyPassword);

	            WebElement submitSignup = driver.findElement(By.id("signup-btn"));
	            submitSignup.click();

	            wait.until(ExpectedConditions.or(
	                    ExpectedConditions.titleContains("GUVI"),
	                    ExpectedConditions.urlContains("dashboard")
	            ));

	            System.out.println("Signup attempted. Page title: " + driver.getTitle());


	            driver.get("https://www.guvi.in");
	            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
	            loginBtn.click();

	            WebElement loginEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	            loginEmail.sendKeys(dummyEmail);

	            WebElement loginPassword = driver.findElement(By.id("password"));
	            loginPassword.sendKeys(dummyPassword);

	            WebElement loginSubmit = driver.findElement(By.id("login-btn"));
	            loginSubmit.click();

	            wait.until(ExpectedConditions.or(
	                    ExpectedConditions.titleContains("GUVI"),
	                    ExpectedConditions.urlContains("dashboard")
	            ));

	            System.out.println("Login attempted. Page title: " + driver.getTitle());

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        } 
	        finally
	        {
	            driver.quit();
	        }
	    }
	}
