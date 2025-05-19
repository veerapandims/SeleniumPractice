package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		        WebDriver driver = new ChromeDriver();

		        try {
		            driver.manage().window().maximize();

		            driver.get("https://demoblaze.com/");

		            String pageTitle = driver.getTitle();

		            if (pageTitle.equals("STORE"))
		            {
		                System.out.println("Page landed on the correct website");
		            }
		            else 
		            {
		                System.out.println("Page not Landed on the correct website");
		                System.out.println("Actual title: " + pageTitle);
		            }

		        }
		        finally
		        {
		            driver.quit();
		        }
		  }

}
