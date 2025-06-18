package day26;


	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class DragAndDrop {
	    public static void main(String[] args) 
	    {
	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            driver.get("https://jqueryui.com/droppable/");

	            WebElement iframe = driver.findElement(By.className("demo-frame"));
	            driver.switchTo().frame(iframe);

	            WebElement source = driver.findElement(By.id("draggable"));
	            WebElement target = driver.findElement(By.id("droppable"));

	            String initialColor = target.getCssValue("background-color");

	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(source, target).perform();

	            Thread.sleep(1000);

	            String finalColor = target.getCssValue("background-color");
	            System.out.println("Initial Color: " + initialColor);
	            System.out.println("Final Color: " + finalColor);

	            boolean colorChanged = !initialColor.equals(finalColor);
	            System.out.println("Color changed after drop: " + colorChanged);

	            String targetText = target.getText();
	            System.out.println("Target text after drop: " + targetText);
	            boolean textChanged = "Dropped!".equals(targetText);

	            if (colorChanged && textChanged) 
	            {
	                System.out.println("Drag and drop operation successful.");
	            }
	            else
	            {
	                System.out.println("Drag and drop operation failed.");
	            }

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
