package org.amazon.page;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPage {	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse pad");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String mainwindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/span[3]/div[2]/div[7]/div/div/div/div/div/div[2]/div/div/div/h2/a/span")).click();
		Set<String> windows = driver.getWindowHandles();
		String child=null;
		for(String a:windows) {
			if(!a.equalsIgnoreCase(mainwindow)) {
				child=a;
			}
		}
		driver.switchTo().window(child);
		WebElement we=driver.findElement(By.name("quantity"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select s=new Select(we);
		s.selectByVisibleText("2");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
		driver.findElement(By.className("a-color-link")).click();
		WebElement we1 =driver.findElement(By.xpath("//html/body/div/div[2]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div/div/div/span/a"));

		Actions a = new Actions(driver);
		a.moveToElement(we1).click().perform();


		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
			driver.switchTo().window(currentWindow);
		}

		WebElement we2 = driver.findElement(By.id("add-to-cart-button"));
		we2.click();

		driver.findElement(By.name("proceedToRetailCheckout")).click();
		driver.findElement(By.id("createAccountSubmit")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Sowndharya");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9876543210");
		driver.findElement(By.id("ap_email")).sendKeys("sow@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("sow@123");
		driver.quit();

	}		
}
