package Maual;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Graming_Sample {
	static WebDriver driver = null;

	public static void main(String[] args) throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	// user input
		WebElement shape = driver.findElement(By.xpath("//img[@id='imgTarget']"));
		String expectedShape = shape.getAttribute("src");
		System.out.println(expectedShape);
		clickOnElement("//button[@id='btnNext']");
		waitTillevisible("//div[@id='eyeTrackingContainer']/div[@class='mpet-row']/div/img");

		List<WebElement> countOfShape = driver
				.findElements(By.xpath("//div[@id='eyeTrackingContainer']/div[@class='mpet-row']/div"));
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@id='eyeTrackingContainer']/div[@class='mpet-row']"));
		List<WebElement> column = driver
				.findElements(By.xpath("(//div[@id='eyeTrackingContainer']/div[@class='mpet-row'])[1]/div"));
		waitTillevisible("//div[@id=\"eyeTrackingContainer\"]/div[@class=\"mpet-row\"]/div/img");

		List<String> listofShape = new ArrayList<String>();
		for (int i = 1; i <= rows.size(); i++) {

			String shapee = "";
			if (i == 1) {
				for (int j = 2; j <= column.size(); j++) {
					System.out.println("if condition" + i);
					shapee = driver
							.findElement(By.xpath(
									"(//div[@id='eyeTrackingContainer']/div[@class='mpet-row'])[" + i + "]/div[" + (j)
											+ "]/img[@style='object-fit: contain; opacity: 1; display: inline;']"))
							.getAttribute("src");
					System.out.println(i + " " + j + " " + " " + shapee);
					listofShape.add(shapee);

				}
			} else if ((i > 1)) {
				for (int j = 1; j <= column.size(); j++) {
					shapee = driver
							.findElement(By
									.xpath("(//div[@id='eyeTrackingContainer']/div[@class='mpet-row'])[" + i + "]/div["
											+ j + "]/img[@style='object-fit: contain; opacity: 1; display: inline;']"))
							.getAttribute("src");

					String shapee1 = driver.findElement(By.xpath(
							"//div[@id='eyeTrackingContainer']/div[@class='mpet-row']/div/img[@style='object-fit: contain; opacity: 1; display: inline;']"))
							.getAttribute("src");
					System.out.println(i + " " + j + " " + " " + shapee);
					listofShape.add(shapee);
				}
			}
		}

		System.out.println(listofShape.size());
		System.out.println(listofShape);

		// To Validate it in count
		int count = 0;
		for (String item : listofShape) {
			if (item.equals(expectedShape)) {
				count++;
			}
		}

	}

	public static void clickOnElement(String locatorValue) throws Throwable {
		int start = 1, max = 5;
		while (start <= max) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorValue))));
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locatorValue))));
				driver.findElement(By.xpath(locatorValue)).click();
				System.out.println(locatorValue + " click on elememt");
				break;

			} catch (StaleElementReferenceException | org.openqa.selenium.ElementClickInterceptedException e) {
				Thread.sleep(1000);
				System.out.println(e);

			}
			start++;
		}
	}

	public static void waitTillevisible(String locatorValue) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorValue))));

	}

}
