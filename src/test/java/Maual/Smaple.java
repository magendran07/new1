package Maual;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Smaple {
	public static void main(String[] args) throws InterruptedException {
		String audioWord=" to";
		try {
			   String output = audioWord.substring(0, 1).toUpperCase() + audioWord.substring(1);
		        System.out.println(output); 
		      
		        
		}
		catch(NoSuchElementException e) {
		System.out.println(e);
		}
	}

}

