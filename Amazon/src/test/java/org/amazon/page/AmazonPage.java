package org.amazon.page;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.findElement(By.linkText("Tizum Z65- Mouse Pad for Laptop, Notebook, MacBook Pro Air, Gaming Computer. 9.4 * 7.9 Inches, Anti-Skid Base Mousepad (MP4)")).click();
		driver.get("https://www.amazon.in/Notebook-MacBook-Computer-Anti-Skid-Mousepad/dp/B08QJJCY2Q/ref=sr_1_3?keywords=mouse+pad&qid=1661794607&sr=8-3");
		String mainwindow = driver.getWindowHandle();		
		driver.switchTo().window(mainwindow);
		WebElement we=driver.findElement(By.name("quantity"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select s=new Select(we);
		s.selectByVisibleText("2");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("a-color-link")).click();
		driver.get("https://www.amazon.in/gp/product/B08QJJCY2Q/ref=ox_sc_act_title_delete_1?smid=A14CZOWI0VEHLG&psc=1");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		Thread.sleep(9000);
		driver.findElement(By.id("createAccountSubmit")).click();
		Thread.sleep(9000);
		driver.findElement(By.id("ap_customer_name")).sendKeys("Sowndharya");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9876543210");
		driver.findElement(By.id("ap_email")).sendKeys("sow@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("sow@123");
		driver.quit();
		
	}		
}
