package Maual;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Manual_Test {
	public static void main(String[] args) throws Exception {
		String emailid = "magendran.p@testyantra.in"; //your email id 
        String password="Manoj@2008";
		String project="Mindplay";
		String moduleName ="Fluency";
		String testcaseNumber="FL002";
		String createdBY="Magendran";
		String reviewedBY="Shivaprasad";
		String createdOn="04";
		String reviewedon="04";
		String url="https://account.mindplay.com/";
		WebDriver rj=new ChromeDriver();
		
		rj.get("https://app.fireflink.com/testdevelopment/Script");
		rj.manage().window().maximize();
		rj.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//Log in
		rj.findElement(By.xpath("//input[@name='emailId']")).sendKeys(emailid);
		rj.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	//	rj.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(5000);
		
		rj.findElement(By.xpath("//td[@role=\"cell\"]//span[text()="+"'"+project+"'"+"]")).click();
				
		JavascriptExecutor je=(JavascriptExecutor) rj;
						
		WebElement GivenModule = rj.findElement(By.xpath("//span[text()="+"'"+moduleName+"'"+"]/../..//span[@class='fancytree-expander']"));
		je.executeScript("arguments[0].scrollIntoView(true)",GivenModule);
		GivenModule.click();
		
		
		WebElement GivenScript = rj.findElement(By.xpath("//span[contains(@title,"+"'"+testcaseNumber+"'"+")"+"]/../../..//button[text()='Automation']"));
		
		je.executeScript("arguments[0].scrollIntoView(true)",GivenScript);
				
		GivenScript.click();
		
		
		Thread.sleep(2000);
		//To iterate steps
		List<WebElement> webElements = rj.findElements(By.xpath("//span[@class=' step-name-truncate']"));
		 
		int count = 0;
		ArrayList al=new ArrayList();
		for(WebElement element : webElements) {
			count++;
			String steps = element.getText();
			al.add(steps);
			
			//System.out.println(steps);	
		}
		
		System.out.println();
		//System.out.println(">>>>>>>>>>>>Iteration was successful<<<<<<<<<<<<<<<");
		
		Thread.sleep(1000);
		rj.findElement(By.xpath("//button[.='+ Manual Test Case']")).click();
		Thread.sleep(1000);
		rj.findElement(By.xpath("//input[@id=\"Requirement Id\"]")).sendKeys(testcaseNumber);
		rj.findElement(By.xpath("//input[@id=\"Created BY\"]")).sendKeys(createdBY);
		rj.findElement(By.xpath("//input[@id=\"Reviewed By\"]")).sendKeys(reviewedBY);
		rj.findElement(By.xpath("//input[@id=\"Created On\"]")).click();
		rj.findElement(By.xpath("//div[.='"+createdOn+"']")).click();
		rj.findElement(By.xpath("//input[@id=\"Reviewed On\"]")).click();
		rj.findElement(By.xpath("//div[.='"+reviewedon+"']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Since the script has "+count +" steps So we have to create same count of blocks");
		
		
		for(int i=0;i<=count;i++) {
			rj.findElement(By.xpath("//button[@contenteditable='false']")).click();
			rj.findElement(By.xpath("//span[text()='Insert row below']")).click();
			
			}
		
			System.out.println("said number of blocks created successfully");
			
			
			
			
			List<WebElement> slNo = rj.findElements(By.xpath("//td[starts-with(@class,'testStepTable')][2]"));
			int i=1;
			for(WebElement blockNO:slNo) {
				blockNO.sendKeys(""+i++);
			}
			
			Thread.sleep(2000);
			 WebElement TestDescr = rj.findElement(By.xpath("//label[contains(.,'"+testcaseNumber+"')]"));
			je.executeScript("arguments[0].scrollIntoView(true)",TestDescr);
			Thread.sleep(2000);
			String descrText = TestDescr.getText();
			String description = descrText.substring(6);
			rj.findElement(By.xpath("//td[starts-with(@class,'testStepTable')][3]")).sendKeys(description);
			
			WebElement enterurl = rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][4])[3]"));
			
			 List<WebElement> inputBlocks = rj.findElements(By.xpath("//td[starts-with(@class,'testStepTable')][4]"));
			 
			 for(WebElement inputblock:inputBlocks) {
				 if(inputblock.equals(enterurl)) {
					 enterurl.sendKeys(url);
				 }
				 else {
					 inputblock.sendKeys("NA");
				 }
			 }
			 
			 WebElement TestDescription = rj.findElement(By.xpath("//label[contains(.,'"+testcaseNumber+"')]"));
				je.executeScript("arguments[0].scrollIntoView(true)",TestDescription);
				Thread.sleep(2000);
				
				//Entering Concrete Steps
				rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])[1]")).sendKeys("Open browser");
				rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])[2]")).sendKeys("Maximize Browser");
				rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])[3]")).sendKeys("Navigate to url");
				//WebElement teststeps = rj.findElement(By.xpath("//td[starts-with(@class,'testStepTable')][5]"));
				//Thread.sleep(2000);
				
				//	for(WebElement autstep:webElements) {						
				//		String autText = autstep.getText();
				//		rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])["+ k++ +"]")).sendKeys(""+autText);
						
				//	}
					int n=4;
					for(int k=0;k<count;k++ ) {
						
						
						Object autText = al.get(k);
						
						rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])["+ n++ +"]")).sendKeys(""+autText);
												
					}
					int lastline=count+4;
					rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])["+ lastline +"]")).sendKeys("Close all browser window");

				
				
				
					WebElement TestDescriptions= rj.findElement(By.xpath("//label[contains(.,'"+testcaseNumber+"')]"));
					je.executeScript("arguments[0].scrollIntoView(true)",TestDescriptions);
					Thread.sleep(2000);
					
					//Entering Concrete Steps
					rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][6])[1]")).sendKeys("user should be able to open browser");
					rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][6])[2]")).sendKeys("user should be able to maximize Browser");
					rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][6])[3]")).sendKeys("user should be able to navigate to url");
					//WebElement teststeps = rj.findElement(By.xpath("//td[starts-with(@class,'testStepTable')][5]"));
					//Thread.sleep(2000);
					
					//	for(WebElement autstep:webElements) {						
					//		String autText = autstep.getText();
					//		rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][5])["+ k++ +"]")).sendKeys(""+autText);
							
					//	}
						int m=4;
						for(int k=0;k<count;k++ ) {
							
							
							Object autText = al.get(k);
							
							rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][6])["+ m++ +"]")).sendKeys("user should be able to "+autText);
													
						}
						int lastlines=count+4;
						rj.findElement(By.xpath("(//td[starts-with(@class,'testStepTable')][6])["+ lastlines +"]")).sendKeys("user should be able to close all browser window");

					
			Thread.sleep(1000);
			rj.findElement(By.xpath("//button[.='Save']")).click();
			Thread.sleep(2000);
			rj.quit();
			
		
	}

}
