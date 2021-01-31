package myPack;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenBrowserWithUrl {
	
	WebDriver driver;
	
	//Launch

	public void StartUrl () {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\dilar\\Downloads\\chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.gittigidiyor.com/");
		
		WebElement DownLink=driver.findElement(By.cssSelector("div[data-cy= 'header-user-menu']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(DownLink).build().perform(); 
		
		@Deprecated
		WebElement element = (new WebDriverWait(driver, 5))
		        .until(ExpectedConditions.elementToBeClickable(By.linkText("Giriþ Yap")));
		driver.findElement(By.linkText("Giriþ Yap")).click();

		//write your Username
		WebElement txtbox_username = driver.findElement(By.id("L-UserNameField"));
		txtbox_username.sendKeys("caner_melami@hotmail.com");

		//Write your Password 
		driver.findElement(By.id("L-PasswordField")).sendKeys("melami123");

		//Click Login
		driver.findElement(By.id("gg-login-enter")).click();
		
		// Written 'bilgisayar' over search bar and click
		driver.findElement(By.cssSelector("input[data-cy=\"header-search-input\"]")).sendKeys("bilgisayar");
		driver.findElement(By.cssSelector("button[data-cy=\"search-find-button\"]")).click();
	

        


        
    }

    public void RandomProduct(){
    	List<WebElement> allProducts = driver.findElements(By.cssSelector(".catalog-seem-cell"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();

    }

    



    public static void main(String[] args) {

        OpenBrowserWithUrl cnr = new OpenBrowserWithUrl();
        cnr.StartUrl();
        cnr.RandomProduct();
      }
}




