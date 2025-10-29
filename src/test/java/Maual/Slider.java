package Maual;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.model.DownloadProgress;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Slider {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://reebok.abfrl.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//WebElement move=driver.findElement(By.xpath("//div[@class='homepage-container']/div[1]//div[@class='swiper-button-next']"));
		int bannerSize=driver.findElements(By.xpath("//div[@class=' Carousel_link__MzK47']")).size();
		System.out.println(bannerSize);
		System.out.println("Waited");
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		WebElement element = (WebElement)js.executeScript("document.querySelector(\"#wzrkImageOnlyDiv > ct-web-popup-imageonly\").shadowRoot.querySelector(\"#close\")");
//		element.click();

		List bannerList=new ArrayList();
		for(int i=0; i<bannerSize; i++) {
			System.out.println("Hey Im for loop "+i);
			String bannertitle=driver.findElement(By.xpath("//div[@class='homepage-container']/div[1]//div[contains(@class,'active')]//img")).getAttribute("title");
			if(!bannerList.contains(bannertitle)) {
				bannerList.add(bannertitle);
          WebElement ele=driver.findElement(By.xpath("//div[@class='homepage-container']/div[1]//div[@class='swiper-button-next']"));
          js.executeScript("arguments[0].click();", ele);
          Thread.sleep(5000);
			}else {
				break;
			}
		}
		System.out.println("total list of banners is "+bannerList);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='homepage-container']/div[3]//div[contains(@class,'active')]//img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		System.out.println("It is SWiped Successfully");
		
		
	}
}


