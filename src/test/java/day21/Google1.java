package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("http://google.com");

            System.out.println("Current URL: " + driver.getCurrentUrl());

            driver.navigate().refresh();

            Thread.sleep(4000);
        }
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            driver.quit();
        }
    }

}


