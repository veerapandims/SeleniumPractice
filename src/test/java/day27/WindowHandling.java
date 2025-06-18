package day27;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import java.util.Set;

	public class WindowHandling {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver(); 

	        try {
	            driver.get("https://the-internet.herokuapp.com/windows");

	            String originalWindow = driver.getWindowHandle();

	            driver.findElement(By.linkText("Click Here")).click();

	            Set<String> windowHandles = driver.getWindowHandles();
	            for (String window : windowHandles) 
	            {
	                if (!window.equals(originalWindow))
	                {
	                    driver.switchTo().window(window);
	                    break;
	                }
	            }

	            String bodyText = driver.findElement(By.tagName("body")).getText();
	            if (bodyText.contains("New Window"))
	            {
	                System.out.println("Verified: 'New Window' text is present.");
	            }
	            else 
	            {
	                System.out.println("New Window' text not found!");
	            }

	            driver.close();

	            driver.switchTo().window(originalWindow);
	            if (driver.getTitle().equals("The Internet")) 
	            {
	                System.out.println("Back to original window.");
	            } 
	            else
	            {
	                System.out.println("Not in the original window.");
	            }

	        }
	        finally 
	        {
	            driver.quit();
	        }
	    }
	}
