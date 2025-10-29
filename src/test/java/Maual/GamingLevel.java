package Maual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gaming {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://account.mindplay.com");
		driver.manage().window().maximize();
		String shapeName="";
		Thread.sleep(50000);
		System.out.println("First timer Out");
	int count=0;
	Thread.sleep(30000);
WebElement shape=driver.findElement(By.xpath("//img[@id=\"imgTarget\"]"));
String shapeAttribute=shape.getAttribute("src");
	System.out.println(shapeAttribute);
int shapeIndex=shapeAttribute.lastIndexOf('/');
if(shapeIndex!=-1) {
	 shapeName=shapeAttribute.substring(shapeIndex+1);
	System.out.println(shapeName);
	
}
System.out.println("whole Time Completed");
driver.findElement(By.xpath("//button[@id='btnNext']")).click();
for(int row=0;row<=6;row++) {
	for(int col=10;col<=19;col++) {          
                WebElement  cellElement=driver.findElement(By.xpath("//div[@id='mpet-row"+row+"']//div["+col+"]/img"));
                   String  imgValue  =cellElement.getAttribute("scr");
          if(imgValue.contains(shapeName)){
                  count++;
			  System.out.println(shapeName);
			   System.out.println(shapeName);
                   	}
	}
}
	}
}

		
