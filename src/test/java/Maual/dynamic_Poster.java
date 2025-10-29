package Maual;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamic_Poster 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://reebok.abfrl.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		POM_PAGE_Scenario pom = new POM_PAGE_Scenario(driver);
		Thread.sleep(5000);
		try 
		{
			if(pom.heroBanner.isDisplayed()==true) 
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(pom.swiperNextButton));
				} catch (Exception e) {		}
				for(WebElement ele : pom.swiperRoundButtons)
				{
					try
					{
						System.out.println("Normal Click Start");
					String name=	pom.heroBanner.getAttribute("title");
					System.out.println(name);
						pom.heroBanner.click();
						System.out.println("Normal Click End");
					} 
					catch (ElementClickInterceptedException e) 
					{
						System.out.println("JS Click Start");
						String name2=	pom.heroBanner.getAttribute("title");
						System.out.println(name2);
						wait.until(ExpectedConditions.elementToBeClickable(pom.heroBanner));
						System.out.println("JS Click End ");
					}
					catch (Exception e) 		{		}
					
					Thread.sleep(5000);
					driver.navigate().back();
					try
					{
						wait.until(ExpectedConditions.elementToBeClickable(pom.swiperNextButton));

					} catch (Exception e) {			}
					jsExecutor.executeScript("arguments[0].click();",pom.swiperNextButton);
				}
			
			}
		}catch (Exception e) {	
			driver.quit();	
			}
	}
}