package Maual;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class POM_PAGE_Scenario
{
	WebDriver driver;
   public POM_PAGE_Scenario(WebDriver driver)
   {
	   this.driver = driver;
	   PageFactory.initElements(driver,this);
   }
	
	
	@FindBy(xpath="//div[@class='homepage-container']/div[1]//div[@class='swiper-button-next']")
	WebElement swiperNextButton;
	
	@FindBy(xpath="//div[@class='homepage-container']/div[1]//span[contains(@class,'swiper')]")
	List<WebElement> swiperRoundButtons;
	
	@FindBy(xpath="//div[@class='homepage-container']/div[1]//div[contains(@class,'active')]//img")
	WebElement heroBanner;
	
	public void  nextButton() {
		swiperNextButton.click();
	}
	public List<WebElement> roundButton() {
		return swiperRoundButtons;
	}
	public void banner() {
		heroBanner.click();
	}
}
