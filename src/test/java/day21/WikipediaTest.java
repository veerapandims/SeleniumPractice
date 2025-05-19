package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class WikipediaTest {
	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();

	            driver.get("https://www.wikipedia.org/");

	            WebElement searchBox = driver.findElement(By.id("searchInput"));
	            searchBox.sendKeys("Artificial Intelligence");

	            searchBox.submit();

	            Thread.sleep(3000);

	            WebElement historyLink = driver.findElement(By.cssSelector("a[href='#History']"));
	            historyLink.click();

	            Thread.sleep(1500);

	            WebElement historyHeading = driver.findElement(By.id("History"));
	            System.out.println("Section Title: " + historyHeading.getText());

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


