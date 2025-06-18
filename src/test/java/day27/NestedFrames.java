package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class NestedFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();  

        try {
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

            List<WebElement> topFrames = driver.findElements(By.xpath("//frame"));
            if (topFrames.size() == 3)
            {
                System.out.println("Top frame contains 3 child frames.");
            } 
            else 
            {
                System.out.println(" Top frame does NOT contain 3 child frames.");
            }

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
            String leftText = driver.findElement(By.xpath("//body")).getText();
            System.out.println(leftText.equals("LEFT") ? "LEFT frame verified." : "LEFT frame mismatch.");
            driver.switchTo().parentFrame();

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
            String middleText = driver.findElement(By.xpath("//div")).getText();
            System.out.println(middleText.equals("MIDDLE") ? "MIDDLE frame verified." : "MIDDLE frame mismatch.");
            driver.switchTo().parentFrame(); 
            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
            String rightText = driver.findElement(By.xpath("//body")).getText();
            System.out.println(rightText.equals("RIGHT") ? "RIGHT frame verified." : "RIGHT frame mismatch.");
            driver.switchTo().parentFrame(); 

            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
            String bottomText = driver.findElement(By.xpath("//body")).getText();
            System.out.println(bottomText.equals("BOTTOM") ? "BOTTOM frame verified." : "BOTTOM frame mismatch.");

            driver.switchTo().defaultContent();
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle.equals("Frames") ? "Page title is 'Frames'." : "Page title mismatch.");

        } finally {
            driver.quit(); 
        }
    }
}
